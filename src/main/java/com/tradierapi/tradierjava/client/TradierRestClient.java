package com.tradierapi.tradierjava.client;

import static com.tradierapi.tradierjava.utils.Utils.isoDate;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tradierapi.tradierjava.model.ExchangeCode;
import com.tradierapi.tradierjava.model.SecurityType;
import com.tradierapi.tradierjava.model.request.EquityOrderRequest;
import com.tradierapi.tradierjava.model.request.GainLossRequest;
import com.tradierapi.tradierjava.model.request.OptionOrderRequest;
import com.tradierapi.tradierjava.model.request.OptionStrikePricesRequest;
import com.tradierapi.tradierjava.model.response.Balances;
import com.tradierapi.tradierjava.model.response.Clock;
import com.tradierapi.tradierjava.model.response.GainLossResponse;
import com.tradierapi.tradierjava.model.response.HistoricPrice;
import com.tradierapi.tradierjava.model.response.Interval;
import com.tradierapi.tradierjava.model.response.MarketCalendar;
import com.tradierapi.tradierjava.model.response.Option;
import com.tradierapi.tradierjava.model.response.Options;
import com.tradierapi.tradierjava.model.response.Order;
import com.tradierapi.tradierjava.model.response.Orders;
import com.tradierapi.tradierjava.model.response.Position;
import com.tradierapi.tradierjava.model.response.Positions;
import com.tradierapi.tradierjava.model.response.Profile;
import com.tradierapi.tradierjava.model.response.Quote;
import com.tradierapi.tradierjava.model.response.Quotes;
import com.tradierapi.tradierjava.model.response.Security;
import com.tradierapi.tradierjava.model.response.SessionFilter;
import com.tradierapi.tradierjava.utils.Utils;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Looks like we cant use Gson for parsing since Gson mangles all the numbers to
 * doubles, even orderIds are returned as E'notations. So, Jackson is the better
 * choice even though somewhat slower.
 * 
 * This has all the code using pure HttpClient & jackson similar to the Tradier
 * API site examples. But in the next change try to move to OkHttp since that
 * feels faster and has better support.
 * 
 * 
 * Created by Deepak Tripathy on 5/17/2024.
 * 
 */
public class TradierRestClient implements TradierClient {
   private static final Logger LOGGER = LoggerFactory.getLogger(TradierRestClient.class);

   protected static final String DEFAULT_PATH = "https://sandbox.tradier.com/v1";

   // property keys
   public static String K_TRADIER_URL = "tradierjava.api.url";
   public static String K_TRADIER_ACCOUNTID = "tradierjava.api.accountid";
   public static String K_TRADIER_TOKEN = "tradierjava.api.token";

   private Properties tradierProps;
   private final Map<String, String> headers;

   public TradierRestClient() {
      this(null);
   }

   public TradierRestClient(Properties props) {
      LOGGER.info("Initiating TradierClient...");

      this.tradierProps = (props == null) ? initProps() : props;

      validateProps(this.tradierProps);

      this.headers = new HashMap<>();
      setupHeaders();
   }

   protected static Properties initProps() {
      try (InputStream in = TradierRestClient.class.getClassLoader()
            .getResourceAsStream("tradier-api-config.properties")) {
         Properties tradProperties = new Properties();
         tradProperties.load(in);
         LOGGER.info("Properties loaded, keys: " + tradProperties.keySet());
         return tradProperties;
      } catch (IOException e) {
         throw new IllegalArgumentException(
               "Could not load default properties from tradier-api-config.properties in classpath");
      }
   }

   /**
    * validates the necessary props like token and account id. If others are
    * missing, just use friendly defaults.
    *
    * @param tdaProps the required props to validate
    */
   protected static void validateProps(Properties tradierProps) {
      LOGGER.trace("Validating props: {}", tradierProps.toString());
      String accountId = tradierProps.getProperty(K_TRADIER_ACCOUNTID);
      if (StringUtils.isBlank(accountId)) {
         throw new IllegalArgumentException(
               "Missing tradierjava.api.accountid property. This is obtained from Tradier account API settings page");
      }

      String token = tradierProps.getProperty(K_TRADIER_TOKEN);
      if (StringUtils.isBlank(token)) {
         throw new IllegalArgumentException(
               "Missing tradierjava.api.token property. This is obtained from the Tradier account API settings page when creating a authentication token");
      }

      String url = tradierProps.getProperty(K_TRADIER_URL);
      if (StringUtils.isBlank(url)) {
         tradierProps.setProperty(K_TRADIER_URL, DEFAULT_PATH);
      }
   }

   private void setupHeaders() {
      headers.put("Authorization", "Bearer " + tradierProps.getProperty(K_TRADIER_TOKEN));
      // this removes all the 'POST' content of HttpClient. Dont use.
      // headers.put("Content-Type", "application/json");
      headers.put("Accept", "application/json");
   }

   @Override
   public Optional<Quote> getQuote(@Nonnull String symbol, @Nullable Boolean includeGreeks) {
      List<Quote> quotes = getQuotes(List.of(symbol), includeGreeks);
      return quotes.isEmpty() ? Optional.empty() : Optional.of(quotes.get(0));
   }

   // TODO: Add retryable as Tradier sometimes refuses connection
   @Override
   public List<Quote> getQuotes(List<String> symbols, @Nullable Boolean includeGreeks) {
      return fetchQuotes(symbols, includeGreeks, false);
   }

   // TODO: Add retryable as Tradier sometimes refuses connection
   @Override
   public List<Quote> postQuotes(List<String> symbols, @Nullable Boolean includeGreeks) {
      return fetchQuotes(symbols, includeGreeks, true);
   }

   private List<Quote> fetchQuotes(List<String> symbols, @Nullable Boolean includeGreeks, boolean isPost) {
      Objects.requireNonNull(symbols);

      List<Quote> quotes = new ArrayList<>();
      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/markets/quotes");
         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();

         Request.Builder requestBuilder;
         if (isPost) {
            RequestBody body = new FormBody.Builder().add("symbols", symbols.stream().collect(Collectors.joining(",")))
                  .add("greeks", (includeGreeks == null) ? "false" : includeGreeks.toString()).build();

            requestBuilder = new Request.Builder().url(httpBuilder.build()).post(body);
         } else {
            httpBuilder.addQueryParameter("symbols", symbols.stream().collect(Collectors.joining(",")))
                  .addQueryParameter("greeks", (includeGreeks == null) ? "false" : includeGreeks.toString());
            requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         }

         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         System.out.println("resp: " + responseBodyStr);
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            JsonNode quoteNode = jsonTree.findPath("quotes").findPath("quote");

            // Tradier returns single quote as an object while multi as an Array
            if (quoteNode.isObject()) {
               Quote quote = mapper.treeToValue(quoteNode, Quote.class);
               quotes.add(quote);
            } else {
               List<Quote> myQuotes = mapper.treeToValue(jsonTree.findPath("quotes"), Quotes.class).getQuotes();
               if (myQuotes != null && !myQuotes.isEmpty())
                  quotes.addAll(myQuotes);
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (Exception ex) {
         throw new RuntimeException(ex);
      }
      return quotes;
   }

   @Override
   public List<HistoricPrice> getPriceHistory(@Nonnull String symbol) {
      return getPriceHistory(symbol, null, null, null, null);
   }

   public List<HistoricPrice> getPriceHistory(@Nonnull String symbol, @Nullable LocalDate fromDate,
         @Nullable LocalDate toDate) {
      return getPriceHistory(symbol, null, fromDate, toDate, null);
   }

   @Override
   public List<HistoricPrice> getPriceHistory(@Nonnull String symbol, @Nullable Interval interval,
         @Nullable LocalDate fromDate, @Nullable LocalDate toDate, @Nullable SessionFilter sessionFilter) {
      Objects.requireNonNull(symbol);

      if (fromDate != null && toDate != null && fromDate.isAfter(toDate))
         throw new IllegalArgumentException("From date can not be after To date");

      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/markets/history");
         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         httpBuilder.addQueryParameter("symbol", symbol);
         httpBuilder.addQueryParameter("interval", (interval == null) ? "daily" : interval.toString());
         httpBuilder.addQueryParameter("session_filter", (interval == null) ? "all" : interval.toString());
         if (fromDate != null) {
            httpBuilder.addQueryParameter("start", isoDate(fromDate));
         }
         if (toDate != null) {
            httpBuilder.addQueryParameter("end", isoDate(toDate));
         }

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            JsonNode dayNode = jsonTree.findPath("history").findPath("day");

            if (dayNode.isNull() || dayNode.isMissingNode())
               return new ArrayList<>();

            // Tradier returns single quote as an object while multi as an Array
            if (dayNode.isObject()) {
               HistoricPrice historic = mapper.treeToValue(dayNode, HistoricPrice.class);
               return List.of(historic);
            } else {
               HistoricPrice[] historicArray = mapper.treeToValue(dayNode, HistoricPrice[].class);
               // direct mapping to List<> may not parse and will make List<LinkedHashMap<..>>.
               // Rather map to a object[] and then stream to list
               if (historicArray.length > 0)
                  return Arrays.stream(historicArray).collect(Collectors.toList());
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }
      return new ArrayList<>();
   }

   @Override
   public Clock getClock(@Nullable Boolean delayed) {
      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/markets/clock");

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         httpBuilder.addQueryParameter("delayed", (delayed == null) ? "true" : delayed.toString());

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            JsonNode clockNode = jsonTree.findPath("clock");

            if (clockNode.isMissingNode())
               return null;

            // Tradier returns single security as an object while multi as an Array
            // but, since this does approx matches, it can return an array of similar ones
            if (clockNode.isObject()) {
               Clock clock = mapper.treeToValue(clockNode, Clock.class);
               return clock;
            }
            // this can never be an array.
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }

      return null;
   }

   @Override
   public MarketCalendar getCalendar(@Nullable Integer month, @Nullable Integer year) {
      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/markets/calendar");

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         if (month != null)
            httpBuilder.addQueryParameter("month", month.toString());
         if (year != null)
            httpBuilder.addQueryParameter("year", year.toString());

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            JsonNode calendarNode = jsonTree.findPath("calendar");

            if (calendarNode.isMissingNode())
               return null;

            // Tradier returns single security as an object while multi as an Array
            // but, since this does approx matches, it can return an array of similar ones
            if (calendarNode.isObject()) {
               MarketCalendar calendar = mapper.treeToValue(calendarNode, MarketCalendar.class);
               return calendar;
            }
            // this can never be an array.
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }

      return null;
   }

   @Override
   public List<Security> searchCompany(@Nonnull String name, @Nullable Boolean includeIndexes) {
      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/markets/search");

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         httpBuilder.addQueryParameter("q", name);
         if (includeIndexes != null)
            httpBuilder.addQueryParameter("exchanges", includeIndexes.toString());

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            JsonNode lookupNode = jsonTree.findPath("securities").findPath("security");

            if (lookupNode.isMissingNode())
               return new ArrayList<>();

            // Tradier returns single security as an object while multi as an Array
            // but, since this does approx matches, it can return an array of similar ones
            if (lookupNode.isObject()) {
               Security security = mapper.treeToValue(lookupNode, Security.class);
               return List.of(security);
            } else {
               Security[] securityArray = mapper.treeToValue(lookupNode, Security[].class);
               // direct mapping to List<> may not parse and will make List<LinkedHashMap<..>>.
               // Rather map to a object[] and then stream to list
               if (securityArray.length > 0) {
                  return Arrays.stream(securityArray)
                        .collect(Collectors.toList());
               }
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }

      return new ArrayList<>();
   }

   @Override
   public Optional<Security> lookupSymbol(String symbol) {
      List<SecurityType> types = new ArrayList<>();
      List<ExchangeCode> exchanges = new ArrayList<>();

      List<Security> securities = lookupSymbol(symbol, exchanges, types);
      return securities.isEmpty() ? Optional.empty() : Optional.of(securities.get(0));
   }

   @Override
   public List<Security> lookupSymbol(@Nonnull String symbol, @Nonnull List<ExchangeCode> exchangeCodes,
         @Nonnull List<SecurityType> securityTypes) {
      Objects.requireNonNull(symbol);
      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/markets/lookup");

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         httpBuilder.addQueryParameter("q", symbol);
         if (!exchangeCodes.isEmpty())
            httpBuilder.addQueryParameter("exchanges",
                  exchangeCodes.stream().map(String::valueOf).collect(Collectors.joining(",")));
         if (!securityTypes.isEmpty())
            httpBuilder.addQueryParameter("types",
                  securityTypes.stream().map(String::valueOf).collect(Collectors.joining(",")));

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            JsonNode lookupNode = jsonTree.findPath("securities").findPath("security");

            if (lookupNode.isMissingNode())
               return List.of();

            // Tradier returns single security as an object while multi as an Array
            // but, since this does approx matches, it can return an array of similar ones
            if (lookupNode.isObject()) {
               Security security = mapper.treeToValue(lookupNode, Security.class);
               return List.of(security);
            } else {
               Security[] securityArray = mapper.treeToValue(lookupNode, Security[].class);
               // direct mapping to List<> may not parse and will make List<LinkedHashMap<..>>.
               // Rather map to a object[] and then stream to list
               if (securityArray.length > 0) {
                  return Arrays.stream(securityArray)
                        .collect(Collectors.toList());
               }
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }

      return new ArrayList<>();
   }

   @Override
   public List<String> lookupOptionSymbolsFor(@Nonnull String underlyingStockSymbol) {
      Objects.requireNonNull(underlyingStockSymbol);

      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/markets/options/lookup");

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         httpBuilder.addQueryParameter("underlying", underlyingStockSymbol);

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            JsonNode optionsNode = jsonTree.findPath("symbols").findPath("options");

            // Tradier returns single quote as an object while multi as an Array
            if (optionsNode.isObject()) {
               String optionSymbol = mapper.treeToValue(optionsNode, String.class);
               return Collections.singletonList(optionSymbol);
            } else if (optionsNode.isArray()) {
               List<String> optionSymbols = mapper.treeToValue(optionsNode, List.class);
               // trim the end quotes
               return optionSymbols.stream().map(val -> Utils.stripEndQuotes(val)).collect(Collectors.toList());
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }

      return new ArrayList<>();
   }

   @Override
   public Optional<Order> getOrder(@Nonnull Long orderId, @Nullable Boolean includeTags) {
      Objects.requireNonNull(orderId);

      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/accounts/%s/orders/%s",
               tradierProps.getProperty(K_TRADIER_ACCOUNTID), orderId);

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         httpBuilder.addQueryParameter("includeTags", (includeTags == null) ? "false" : includeTags.toString());

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);

            JsonNode orderNode = jsonTree.findPath("order");

            if (orderNode.isObject()) {
               Order order = mapper.treeToValue(orderNode, Order.class);
               return Optional.of(order);
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }
      return Optional.empty();
   }

   @Override
   public List<Position> getPositions() {
      List<Position> positions = new ArrayList<>();
      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/accounts/%s/positions",
               tradierProps.getProperty(K_TRADIER_ACCOUNTID));

         Request.Builder requestBuilder = new Request.Builder().url(url).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);

            JsonNode positionNode = jsonTree.findPath("positions").findPath("position");
            if (positionNode.isObject()) {
               Position position = mapper.treeToValue(positionNode, Position.class);
               positions.add(position);
            } else {
               List<Position> myPositions = mapper.treeToValue(jsonTree.findPath("positions"), Positions.class)
                     .getPositions();
               if (myPositions != null && !myPositions.isEmpty())
                  positions.addAll(myPositions);
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }

      return positions;
   }

   @Override
   public GainLossResponse getGainLoss(@Nonnull String accountId, GainLossRequest gainLossRequest) {
      Objects.requireNonNull(accountId);

      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/accounts/%s/gainloss", accountId);

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         if (gainLossRequest != null) {
            gainLossRequest.buildParametersMap().entrySet()
                  .forEach(entry -> httpBuilder.addQueryParameter(entry.getKey(), entry.getValue()));
         }

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();

            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            JsonNode gainLossNode = jsonTree.findPath("gainloss");
            if (gainLossNode.isObject()) {
               GainLossResponse gainLoss = mapper.treeToValue(gainLossNode, GainLossResponse.class);
               return gainLoss;
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (Exception ex) {
         throw new RuntimeException(ex);
      }
      return null;
   }

   @Override
   public List<Order> getOrders(@Nullable Integer page, @Nullable Boolean includeTags) {
      List<Order> orders = new ArrayList<>();

      String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/accounts/%s/orders",
            tradierProps.getProperty(K_TRADIER_ACCOUNTID));

      HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
      httpBuilder.addQueryParameter("page", (page == null) ? "1" : page.toString());
      httpBuilder.addQueryParameter("includeTags", (includeTags == null) ? "false" : includeTags.toString());

      Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
      headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
      Request request = requestBuilder.build();

      OkHttpClient client = prepareClient();
      try {
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);

            JsonNode orderNode = jsonTree.findPath("orders").findPath("order");
            // Tradier returns single quote as an object while multi as an Array
            if (orderNode.isObject()) {
               Order order = mapper.treeToValue(orderNode, Order.class);
               orders.add(order);
            } else {
               List<Order> myOrders = mapper.treeToValue(jsonTree.findPath("orders"), Orders.class).getOrders();
               if (myOrders != null && !myOrders.isEmpty())
                  orders.addAll(myOrders);
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }
      return orders;
   }

   @Override
   public Profile getUserProfile() {
      try {
         String url = tradierProps.getProperty(K_TRADIER_URL) + "/v1/user/profile";
         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();

            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            JsonNode profileNode = jsonTree.findPath("profile");
            if (profileNode.isObject()) {
               Profile profile = mapper.treeToValue(profileNode, Profile.class);
               return profile;
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (Exception ex) {
         throw new RuntimeException(ex);
      }
      return null;
   }

   @Override
   public Map<String, Object> getAccountCashBalances(@Nonnull String accountId) {
      Balances balances = getAccountBalances(accountId);

      Map<String, Object> params = new HashMap<>();
      if (balances != null) {
         String accountType = balances.getAccountType().toString();
         double totalCash = balances.getTotalCash();
         double pendingCash = balances.getPendingCash();

         double availableCash = 0;
         if (balances.getCash() != null) {
            availableCash = balances.getCash().getCashAvailable();
         }
         double stockBp, optionBp;
         stockBp = optionBp = 0;
         if (balances.getMargin() != null) {
            stockBp = balances.getMargin().getStockBuyingPower();
            optionBp = balances.getMargin().getOptionBuyingPower();
         }
         if (balances.getPdt() != null) {
            stockBp = balances.getPdt().getStockBuyingPower();
            optionBp = balances.getPdt().getOptionBuyingPower();
         }

         // common entries
         params.put(KEY_ACCOUNT_ACCOUNT_TYPE, accountType);
         params.put(KEY_ACCOUNT_TOTAL_CASH, totalCash);
         params.put(KEY_ACCOUNT_PENDING_CASH, pendingCash);
         // margin acct entries
         params.put(KEY_ACCOUNT_STOCK_BP, stockBp);
         params.put(KEY_ACCOUNT_OPTION_BP, optionBp);
         // cash acct entries
         params.put(KEY_ACCOUNT_CASH_AVAILABLE, availableCash);

      }
      return params;
   }

   @Override
   public Balances getAccountBalances(@Nonnull String accountId) {
      Objects.requireNonNull(accountId);

      Map<String, Object> params = new HashMap<>();

      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/accounts/%s/balances", accountId);

         Request.Builder requestBuilder = new Request.Builder().url(url).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);

            JsonNode balancesNode = jsonTree.findPath("balances");

            if (balancesNode.isObject()) {
               Balances balances = mapper.treeToValue(balancesNode, Balances.class);
               return balances;
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (Exception ex) {
         throw new RuntimeException(ex);
      }
      return null;
   }

   @Override
   public long cancelOrder(@Nonnull Long orderId) {
      Objects.requireNonNull(orderId);

      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/accounts/%s/orders/%s",
               tradierProps.getProperty(K_TRADIER_ACCOUNTID), orderId);

         Request.Builder requestBuilder = new Request.Builder().url(url).delete();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final com.fasterxml.jackson.databind.JsonNode responseJson = mapper.readTree(responseBodyStr);

            if (responseJson.isObject()) {
               return responseJson.findValue("id").asLong();
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }

      return 0;
   }

   @Override
   public long postStockOrder(EquityOrderRequest orderReq) {
      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/accounts/%s/orders",
               tradierProps.getProperty(K_TRADIER_ACCOUNTID));

         FormBody.Builder formBody = new FormBody.Builder();
         orderReq.getRequestParams().entrySet().forEach(entry -> formBody.add(entry.getKey(), entry.getValue()));
         RequestBody body = formBody.build();

         Request.Builder requestBuilder = new Request.Builder().url(url).post(body);
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final com.fasterxml.jackson.databind.JsonNode jsonNode = mapper.readTree(responseBodyStr);

            if (jsonNode.hasNonNull("order"))
               return jsonNode.findValue("id").asLong();
            if (jsonNode.has("errors")) {
               JsonNode errorNode = jsonNode.findPath("errors").findPath("error");
               String errorStr = mapper.writeValueAsString(errorNode);
               LOGGER.error("postStockOrder Error response: " + errorStr);
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }
      return 0;
   }

   @Override
   public long postOptionOrder(OptionOrderRequest orderReq) {
      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/accounts/%s/orders",
               tradierProps.getProperty(K_TRADIER_ACCOUNTID));

         FormBody.Builder formBody = new FormBody.Builder();
         orderReq.getRequestParams().entrySet().forEach(entry -> formBody.add(entry.getKey(), entry.getValue()));
         RequestBody body = formBody.build();

         Request.Builder requestBuilder = new Request.Builder().url(url).post(body);
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final com.fasterxml.jackson.databind.JsonNode jsonNode = mapper.readTree(responseBodyStr);

            if (jsonNode.hasNonNull("order"))
               return jsonNode.findValue("id").asLong();
            if (jsonNode.has("errors")) {
               JsonNode errorNode = jsonNode.findPath("errors").findPath("error");
               String errorStr = mapper.writeValueAsString(errorNode);
               LOGGER.error("postOptionOrder Error response: " + errorStr);
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }
      return 0;
   }

   // NOT yet complete as the response structure changes based on the request.
   @Override
   public List<LocalDate> getOptionExpieryDates(@Nonnull String underlyingSymbol) {
      Objects.requireNonNull(underlyingSymbol);

      List<LocalDate> expireDates = new ArrayList<>();
      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/markets/options/expirations");

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         httpBuilder.addQueryParameter("symbol", underlyingSymbol)
               // uncomment if there is an use case
               // .addQueryParameter("strikes", "true")
               // .addQueryParameter("contractSize", "true")
               // .addQueryParameter("expirationType", "true")
               .addQueryParameter("includeAllRoots", "true");

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);

            // if only single date then this does not return the expiration block.
            JsonNode expireDateNode = jsonTree.findPath("expirations").findPath("date");

            // Tradier returns single quote as an object while multi as an Array
            if (expireDateNode.isObject()) {
               String expireDateStr = expireDateNode.asText();
               LocalDate expireDate = LocalDate.parse(expireDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
               expireDates.add(expireDate);
            } else {
               for (final JsonNode objNode : expireDateNode) {
                  String expireDateStr = objNode.asText();
                  LocalDate expireDate = LocalDate.parse(expireDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
                  expireDates.add(expireDate);
               }
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (Exception ex) {
         throw new RuntimeException(ex);
      }
      return expireDates;
   }

   @Override
   public List<Option> getOptionChainFor(@Nonnull String underlyingSymbol, @Nonnull LocalDate expieryDate,
         @Nullable Boolean greeks) {
      Objects.requireNonNull(underlyingSymbol);
      Objects.requireNonNull(expieryDate);

      List<Option> optionQuotes = new ArrayList<>();
      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/markets/options/chains");

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         httpBuilder.addQueryParameter("symbol", underlyingSymbol)
               .addQueryParameter("expiration", expieryDate.format(DateTimeFormatter.ISO_LOCAL_DATE))
               .addQueryParameter("greeks", (greeks == null) ? "true" : greeks.toString());

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            JsonNode optionNode = jsonTree.findPath("options").findPath("option");

            // Tradier returns single quote as an object while multi as an Array
            if (optionNode.isObject()) {
               Option quote = mapper.treeToValue(optionNode, Option.class);
               optionQuotes.add(quote);
            } else {
               List<Option> myQuotes = mapper.treeToValue(jsonTree.findPath("options"), Options.class).getOptions();
               if (myQuotes != null && !myQuotes.isEmpty())
                  optionQuotes.addAll(myQuotes);
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (Exception ex) {
         throw new RuntimeException(ex);
      }
      return optionQuotes;
   }

   @Override
   public List<Double> getOptionStrikes(OptionStrikePricesRequest strikePricesRequest) {
      Objects.requireNonNull(strikePricesRequest);
      Objects.requireNonNull(strikePricesRequest.getSymbol());
      Objects.requireNonNull(strikePricesRequest.getExpiration());

      List<Double> expireDates = new ArrayList<>();
      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/markets/options/strikes");

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         strikePricesRequest.buildParametersMap().entrySet()
               .forEach(entry -> httpBuilder.addQueryParameter(entry.getKey(), entry.getValue()));

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);

            // if only single date then this does not return the expiration block.
            JsonNode strikeNode = jsonTree.findPath("strikes").findPath("strike");

            // Tradier returns single quote as an object while multi as an Array
            if (strikeNode.isObject()) {
               Double strike = Double.valueOf(strikeNode.asText());
               expireDates.add(strike);
            } else {
               for (final JsonNode objNode : strikeNode) {
                  Double strike = Double.valueOf(objNode.asText());
                  expireDates.add(strike);
               }
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (Exception ex) {
         throw new RuntimeException(ex);
      }
      return expireDates;
   }

   @Override
   public long modifyOrder(@Nonnull Long existingOrderId, @Nullable String orderType, @Nullable String duration,
         @Nullable Double price, @Nullable Double stopPrice) {
      Objects.requireNonNull(existingOrderId);

      try {
         String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "/v1/accounts/%s/orders/%s",
               tradierProps.getProperty(K_TRADIER_ACCOUNTID), existingOrderId);

         Map<String, String> bodyParamMap = new HashMap<>();
         Utils.addIfValid(bodyParamMap, "type", orderType);
         Utils.addIfValid(bodyParamMap, "duration", duration);
         Utils.addIfValid(bodyParamMap, "price", price.toString());
         Utils.addIfValid(bodyParamMap, "stop", stopPrice.toString());

         FormBody.Builder formBody = new FormBody.Builder();
         bodyParamMap.entrySet().forEach(entry -> formBody.add(entry.getKey(), entry.getValue()));
         RequestBody body = formBody.build();

         Request.Builder requestBuilder = new Request.Builder().url(url).put(body);
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         OkHttpClient client = prepareClient();
         Response response = client.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200 || responseCode == 201) {
            ObjectMapper mapper = Utils.objectMapper();
            final com.fasterxml.jackson.databind.JsonNode jsonTree = mapper.readTree(responseBodyStr);

            if (jsonTree.hasNonNull("order"))
               return jsonTree.findValue("id").asLong();
            if (jsonTree.has("errors")) {
               JsonNode errorNode = jsonTree.findPath("errors").findPath("error");
               String errorStr = mapper.writeValueAsString(errorNode);
               LOGGER.error("modifyOrder Error response: " + errorStr);
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }

      return 0;
   }

   @Override
   public Map<String, String> getOptionExchangeCodeMap() {
      String exchMapStr = "A=NYSE Amex Options" + ",B=BOX Options Exchange" + ",C=Chicago Board Options Exchange (CBOE)"
            + ",H=ISE Gemini" + ",I=International Securities Exchange (ISE)" + ",M=MIAX Options Exchange"
            + ",N=NYSE Arca Options" + ",O=Options Price Reporting Authority (OPRA)" + ",P=MIAX PEARL"
            + ",Q=NASDAQ Options Market" + ",T=NASDAQ OMX BX" + ",W=C2 Options Exchange" + ",X=NASDAQ OMX PHLX"
            + ",Z=BATS Options Market";

      return Stream.of(exchMapStr.split("\\,"))
            .collect(Collectors.toMap(t -> t.toString().split("=")[0], t -> t.toString().split("=")[1]));
   }

   @Override
   public Map<String, String> getStockExchangeCodeMap() {
      String exchMapStr = "A=NYSE MKT" + ",B=NASDAQ OMX BX" + ",C=National Stock Exchange" + ",D=FINRA ADF"
            + ",E=Market Independent (Generated by Nasdaq SIP)" + ",F=Mutual Funds/Money Markets (NASDAQ)"
            + ",I=International Securities Exchange" + ",J=Direct Edge A" + ",K=Direct Edge X"
            + ",L=Long Term Stock Exchange" + ",M=Chicago Stock Exchange" + ",N=NYSE" + ",P=NYSE Arca" + ",Q=NASDAQ OMX"
            + ",S=NASDAQ Small Cap" + ",T=NASDAQ Int" + ",U=OTCBB" + ",V=OTC other" + ",W=CBOE" + ",X=NASDAQ OMX PSX"
            + ",G=GLOBEX" + ",Y=BATS Y-Exchange" + ",Z=BATS";

      return Stream.of(exchMapStr.split("\\,"))
            .collect(Collectors.toMap(t -> t.toString().split("=")[0], t -> t.toString().split("=")[1]));
   }

   // Returns a client customized for timeout.
   private OkHttpClient prepareClient() {
      OkHttpClient.Builder builder = new OkHttpClient.Builder();
      builder.connectTimeout(2, TimeUnit.MINUTES) // connect timeout
            .writeTimeout(1, TimeUnit.MINUTES) // write timeout
            .readTimeout(1, TimeUnit.MINUTES); // read timeout

      OkHttpClient client = builder.build();
      return client;

   }
}
