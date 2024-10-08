package com.deepaktripathy.tradierjava.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deepaktripathy.tradierjava.client.TradierAPI;
import com.deepaktripathy.tradierjava.client.account.request.GainLossRequest;
import com.deepaktripathy.tradierjava.client.account.request.SortByColumn;
import com.deepaktripathy.tradierjava.client.account.request.SortDirection;
import com.deepaktripathy.tradierjava.client.account.response.Balances;
import com.deepaktripathy.tradierjava.client.account.response.GainLossResponse;
import com.deepaktripathy.tradierjava.client.account.response.Order;
import com.deepaktripathy.tradierjava.client.account.response.Position;
import com.deepaktripathy.tradierjava.client.marketdata.request.OptionStrikePricesRequest;
import com.deepaktripathy.tradierjava.client.marketdata.response.Clock;
import com.deepaktripathy.tradierjava.client.marketdata.response.HistoricPrice;
import com.deepaktripathy.tradierjava.client.marketdata.response.Interval;
import com.deepaktripathy.tradierjava.client.marketdata.response.MarketCalendar;
import com.deepaktripathy.tradierjava.client.marketdata.response.Option;
import com.deepaktripathy.tradierjava.client.marketdata.response.Quote;
import com.deepaktripathy.tradierjava.client.marketdata.response.Security;
import com.deepaktripathy.tradierjava.client.marketdata.response.SessionFilter;
import com.deepaktripathy.tradierjava.client.marketdata.response.TimeSalesResponse;
import com.deepaktripathy.tradierjava.client.model.Duration;
import com.deepaktripathy.tradierjava.client.model.ExchangeCode;
import com.deepaktripathy.tradierjava.client.model.SecurityType;
import com.deepaktripathy.tradierjava.client.trader.request.EquityOrderRequest;
import com.deepaktripathy.tradierjava.client.trader.request.EquitySide;
import com.deepaktripathy.tradierjava.client.trader.request.OptionOrderRequest;
import com.deepaktripathy.tradierjava.client.trader.request.OptionSide;
import com.deepaktripathy.tradierjava.client.trader.request.OrderType;
import com.deepaktripathy.tradierjava.client.user.response.Profile;

@RestController
public class TradierController {
   private static final Logger LOGGER = LoggerFactory.getLogger(TradierController.class);

   /****************************
    * MarketDataAPI Endpoints
    ****************************/
   @GetMapping("/markets/quote")
   public String getQuote(@RequestHeader HttpHeaders headers,
         @RequestParam(value = "symbol", required = true) String symbol,
         @RequestParam(value = "greeks", required = false) Boolean includeGreeks) {

      Properties tradierProps = buildProperties(headers);
      Optional<Quote> quote = new TradierAPI(tradierProps).marketData().getQuote(symbol, includeGreeks);
      LOGGER.debug("Response quote: " + quote);
      return quote.toString();
   }

   @GetMapping("/markets/quotes")
   public List<Quote> getQuotes(@RequestHeader HttpHeaders headers,
         @RequestParam(value = "symbols", required = true) String[] symbols,
         @RequestParam(value = "greeks", required = false) Boolean includeGreeks) {
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).marketData().getQuotes(Arrays.stream(symbols).collect(Collectors.toList()),
            includeGreeks);
   }

   @PostMapping("/markets/quotes")
   public List<Quote> postQuotes(@RequestHeader HttpHeaders headers,
         @RequestParam(value = "symbols", required = true) String[] symbols,
         @RequestParam(value = "greeks", required = false) Boolean includeGreeks) {
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).marketData().postQuotes(Arrays.stream(symbols).collect(Collectors.toList()),
            includeGreeks);
   }

   @GetMapping("/markets/options/chains")
   public List<Option> getOptionChainFor(@RequestHeader HttpHeaders headers,
         @RequestParam(value = "symbol") String symbol, @RequestParam(value = "expieryDate") LocalDate expieryDate,
         @RequestParam(value = "greeks", required = false) Boolean greeks) {
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).marketData().getOptionChainFor(symbol, expieryDate, greeks);
   }

   @GetMapping("/markets/options/strikes")
   public List<Double> getOptionStrikes(@RequestHeader HttpHeaders headers,
         @RequestParam(value = "symbol") String symbol, @RequestParam(value = "expiration") LocalDate expiration,
         @RequestParam(value = "includeAllRoots") Boolean includeAllRoots) {
      Properties tradierProps = buildProperties(headers);
      OptionStrikePricesRequest request = new OptionStrikePricesRequest();
      request.setSymbol(symbol);
      request.setExpiration(expiration);
      request.setIncludeAllRoots(includeAllRoots);
      return new TradierAPI(tradierProps).marketData().getOptionStrikes(request);
   }

   @GetMapping("/markets/options/expirations")
   public List<LocalDate> getOptionExpieryDates(@RequestHeader HttpHeaders headers,
         @RequestParam(value = "symbol") String symbol) {
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).marketData().getOptionExpiryDates(symbol);
   }

   @GetMapping("/markets/options/lookup")
   public List<String> lookupOptionSymbols(@RequestHeader HttpHeaders headers,
         @RequestParam(value = "underlying") String symbol) {
      Properties tradierProps = buildProperties(headers);
      List<String> options = new TradierAPI(tradierProps).marketData().lookupOptionSymbolsFor(symbol);
//       LOGGER.debug("Response options: " + options);

      return options;
   }

   @GetMapping("/markets/history")
   public List<HistoricPrice> getHistory(@RequestHeader HttpHeaders headers,
         @RequestParam(value = "symbol", required = true) String symbol,
         @RequestParam(value = "from_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
         @RequestParam(value = "to_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).marketData().getPriceHistory(symbol, fromDate, toDate);
   }

   @GetMapping("/markets/timesales")
   public TimeSalesResponse getTimesales(@RequestHeader HttpHeaders headers,
         @RequestParam(value = "symbol", required = true) String symbol,
         @RequestParam(value = "interval", required = false) Interval interval,
         @RequestParam(value = "start", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
         @RequestParam(value = "end", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
         @RequestParam(value = "session_filter", required = false) SessionFilter sessionFilter) {
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).marketData().getTimeSales(symbol, interval, start, end, sessionFilter);
   }
   
   @GetMapping("/markets/clock")
   public Clock getClock(@RequestHeader HttpHeaders headers,
         @RequestParam(value = "delayed", required = false) Boolean delayed) {
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).marketData().getClock(delayed);
   }

   @GetMapping("/markets/calendar")
   public MarketCalendar getCalendar(@RequestHeader HttpHeaders headers,
         @RequestParam(value = "month", required = false) Integer month,
         @RequestParam(value = "year", required = false) Integer year) {
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).marketData().getCalendar(month, year);
   }

   @GetMapping("/markets/search")
   public ResponseEntity<List<Security>> searchCompany(@RequestHeader HttpHeaders headers,
         @RequestParam(value = "q", required = true) String symbol,
         @RequestParam(value = "indexes", required = false) Boolean indexes) {
      Properties tradierProps = buildProperties(headers);
      List<Security> securityList = new TradierAPI(tradierProps).marketData().searchCompany(symbol, indexes);
      return ResponseEntity.status(HttpStatus.OK).body(securityList);
   }

   @GetMapping("/markets/lookup")
   public ResponseEntity<List<Security>> lookupSymbol(@RequestHeader HttpHeaders headers,
         @RequestParam(value = "q") String symbol, @RequestParam("exchanges") List<ExchangeCode> exchangeCodes,
         @RequestParam("types") List<SecurityType> types) {
      Properties tradierProps = buildProperties(headers);
      List<Security> securityList = new TradierAPI(tradierProps).marketData().lookupSymbol(symbol, exchangeCodes,
            types);
      return ResponseEntity.status(HttpStatus.OK).body(securityList);
   }

   /****************************
    * TraderAPI Endpoints
    ****************************/
   @PostMapping(value = "/accounts/{account_id}/orders")
   public long postEquityOrder(@RequestHeader HttpHeaders headers,
         @PathVariable(name = "account_id", required = true) String accountId,
         @RequestParam(value = "symbol", required = true) String symbol,
         @RequestParam(value = "side", required = true) String side,
         @RequestParam(value = "quantity", required = true) Double quantity,
         @RequestParam(value = "type", required = true) String orderType,
         @RequestParam(value = "duration", required = true) String duration,

         @RequestParam(value = "price", required = false) Double price,
         @RequestParam(value = "stop_price", required = false) Double stopPrice,
         @RequestParam(value = "order_tag", required = false) String orderTag) {
      EquityOrderRequest request = new EquityOrderRequest(EquitySide.valueOf(side), symbol, quantity, price,
            OrderType.valueOf(orderType), Duration.valueOf(duration), stopPrice, orderTag);
      Properties tradierProps = buildProperties(headers);

      LOGGER.debug("Calling postStockOrder");
      return new TradierAPI(tradierProps).accounts().trader().postStockOrder(accountId, request);
   }

   @PostMapping(value = "/accounts/{account_id}/orders", params = { "class=option" })
   public long postOptionOrder(@RequestHeader HttpHeaders headers,
         @PathVariable(name = "account_id", required = true) String accountId,
         @RequestParam(value = "symbol", required = true) String symbol,
         @RequestParam(value = "option_symbol", required = true) String optionSymbol,
         @RequestParam(value = "side", required = true) String side,
         @RequestParam(value = "quantity", required = true) Double quantity,
         @RequestParam(value = "type", required = true) String orderType,
         @RequestParam(value = "duration", required = true) String duration,

         @RequestParam(value = "price", required = false) Double price,
         @RequestParam(value = "stop_price", required = false) Double stopPrice,
         @RequestParam(value = "order_tag", required = false) String orderTag) {
      OptionOrderRequest request = new OptionOrderRequest(OptionSide.valueOf(side), symbol, quantity, price,
            OrderType.valueOf(orderType), Duration.valueOf(duration), stopPrice, orderTag, optionSymbol);
      Properties tradierProps = buildProperties(headers);
      LOGGER.debug("Calling postOptionOrder");
      return new TradierAPI(tradierProps).accounts().trader().postOptionOrder(accountId, request);
   }

   @PutMapping("/accounts/{account_id}/orders/{order_id}")
   public long modifyOrder(@RequestHeader HttpHeaders headers,
         @PathVariable(name = "account_id", required = true) String accountId,
         @PathVariable(name = "order_id", required = true) Long orderId,
         @RequestParam(value = "type", required = false) String orderType,
         @RequestParam(value = "duration", required = false) String duration,
         @RequestParam(value = "price", required = false) Double price,
         @RequestParam(value = "stop", required = false) Double stopPrice) {

      // since all these input parameters are optional, the validation can only be
      // done at the service level
      Properties tradierProps = buildProperties(headers);
      LOGGER.debug("test");
      return new TradierAPI(tradierProps).accounts().trader().modifyOrder(accountId, orderId, orderType, duration,
            price, stopPrice);
   }

   @DeleteMapping("/accounts/{account_id}/orders/{order_id}")
   public long cancelOrder(@RequestHeader HttpHeaders headers,
         @PathVariable(name = "account_id", required = true) String accountId,
         @PathVariable(name = "order_id", required = true) Long orderId) {
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).accounts().trader().cancelOrder(accountId, orderId);
   }

   /****************************
    * UserAPI Endpoints
    ****************************/
   @GetMapping("/user/profile")
   @ResponseBody
   public Profile getUserProfile(@RequestHeader HttpHeaders headers) {
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).user().getUserProfile();
   }

   /****************************
    * AccountAPI Endpoints
    ****************************/
   @GetMapping("/accounts/{account_id}/balances")
   @ResponseBody
   public Balances getAccountBalances(@RequestHeader HttpHeaders headers,
         @PathVariable(name = "account_id", required = true) String accountId) {
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).accounts().getAccountBalances(accountId);
   }

   @GetMapping("/accounts/{account_id}/positions")
   @ResponseBody
   public List<Position> getPositions(@RequestHeader HttpHeaders headers,
         @PathVariable(name = "account_id", required = true) String accountId) {
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).accounts().getPositions(accountId);
   }

   // account history.

   @GetMapping("/accounts/{account_id}/gainloss")
   @ResponseBody
   public GainLossResponse getGainLoss(@RequestHeader HttpHeaders headers,
         @PathVariable(name = "account_id", required = true) String accountId,
         @RequestParam(value = "page", required = false) Integer page,
         @RequestParam(value = "limit", required = false) Integer limit,
         @RequestParam(value = "sort_by", required = false) SortByColumn sortByColumn,
         @RequestParam(value = "sort", required = false) SortDirection sortDirection,
         @RequestParam(value = "start_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
         @RequestParam(value = "end_date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
         @RequestParam(value = "symbol", required = false) String symbol) {
      GainLossRequest request = new GainLossRequest();
      request.setPage(page);
      request.setLimit(limit);
      request.setSortBy(sortByColumn);
      request.setStartDate(startDate);
      request.setEndDate(endDate);
      request.setSymbol(symbol);
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).accounts().getGainLoss(accountId, new GainLossRequest());
   }

   @GetMapping("/accounts/{account_id}/orders")
   @ResponseBody
   public List<Order> getOrders(@RequestHeader HttpHeaders headers,
         @PathVariable(name = "account_id", required = true) String accountId,
         @RequestParam(value = "page", required = false) Integer page,
         @RequestParam(value = "includeTags", required = false) Boolean includeTags) {
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).accounts().getOrders(accountId, page, includeTags);
   }

   @GetMapping("/accounts/{account_id}/orders/{id}")
   @ResponseBody
   public ResponseEntity<Order> getOrder(@RequestHeader HttpHeaders headers,
         @PathVariable(name = "account_id", required = true) String accountId,
         @PathVariable(name = "id", required = true) long orderId,
         @RequestParam(value = "includeTags", required = true) Boolean includeTags) {
      Properties tradierProps = buildProperties(headers);
      Optional<Order> order = new TradierAPI(tradierProps).accounts().getOrder(accountId, orderId, includeTags);
      if (order.isPresent()) {
         return ResponseEntity.status(HttpStatus.OK).body(order.get());
      }
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
   }

   @GetMapping("/stockExchangeCodes")
   public Map<String, String> getStockExchangeCodeMap(@RequestHeader HttpHeaders headers) {
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).getStockExchangeCodeMap();
   }

   @GetMapping("/optionExchangeCodes")
   public Map<String, String> getOptionExchangeCodeMap(@RequestHeader HttpHeaders headers) {
      Properties tradierProps = buildProperties(headers);
      return new TradierAPI(tradierProps).getStockExchangeCodeMap();
   }

   private Properties buildProperties(HttpHeaders headers) {
      Properties tradierProps = new Properties();
//    	LOGGER.debug("Headers: " + headers.toString());
//    	LOGGER.debug("Headers map: " + headers.toSingleValueMap().toString());
//    	final String authorizationHeaderValue = request.getHeader("Authorization");
//        if (authorizationHeaderValue != null && authorizationHeaderValue.startsWith("Bearer")) {
//          String token = authorizationHeaderValue.substring(7, authorizationHeaderValue.length());

      if (headers.get(HttpHeaders.AUTHORIZATION) == null)
         return null;

      LOGGER.debug("Headers: auth all: " + headers.get(HttpHeaders.AUTHORIZATION));
      final String authValue = headers.getFirst(HttpHeaders.AUTHORIZATION);
      LOGGER.debug("Headers: auth first: " + authValue);
      // also expects the url as a header.

      String token = null;
      if (authValue != null && authValue.startsWith("Bearer"))
         token = authValue.substring(7, authValue.length());// 6 chars + space
      LOGGER.debug("Headers: token: " + token);
      tradierProps.setProperty(TradierAPI.K_TRADIER_TOKEN, token);

      String accept = headers.getAccept().toString();
      LOGGER.debug("Headers: accept: " + accept);
      // String contentType = headers.getContentType();

      tradierProps.setProperty(TradierAPI.K_TRADIER_URL, "https://sandbox.tradier.com");
      tradierProps.setProperty(TradierAPI.K_TRADIER_ACCOUNTID, "VA12933718");
      return tradierProps;
   }
}