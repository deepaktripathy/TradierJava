package com.tradierapi.tradierjava.client.marketdata;

import static com.tradierapi.tradierjava.utils.Utils.isoDate;
import static com.tradierapi.tradierjava.utils.Utils.isoDateTime;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tradierapi.tradierjava.client.marketdata.request.OptionStrikePricesRequest;
import com.tradierapi.tradierjava.client.marketdata.response.Clock;
import com.tradierapi.tradierjava.client.marketdata.response.HistoricPrice;
import com.tradierapi.tradierjava.client.marketdata.response.Interval;
import com.tradierapi.tradierjava.client.marketdata.response.MarketCalendar;
import com.tradierapi.tradierjava.client.marketdata.response.Option;
import com.tradierapi.tradierjava.client.marketdata.response.Options;
import com.tradierapi.tradierjava.client.marketdata.response.Quote;
import com.tradierapi.tradierjava.client.marketdata.response.Quotes;
import com.tradierapi.tradierjava.client.marketdata.response.Security;
import com.tradierapi.tradierjava.client.marketdata.response.SessionFilter;
import com.tradierapi.tradierjava.client.marketdata.response.TimeSalesResponse;
import com.tradierapi.tradierjava.model.ExchangeCode;
import com.tradierapi.tradierjava.model.SecurityType;
import com.tradierapi.tradierjava.utils.Utils;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 
 * @author deepak tripathy created on 07/02/2024
 *
 */
public class MarketDataAPI {
   private static final Logger LOGGER = LoggerFactory.getLogger(MarketDataAPI.class);

   private String baseUrl;
   private String apiKey;
   private OkHttpClient httpClient;
   private Map<String, String> headers = new HashMap<String, String>();

   public MarketDataAPI(String baseUrl, String apiSecretKey, OkHttpClient okHttpClient) {

      this.baseUrl = baseUrl;
      this.apiKey = apiSecretKey;
      this.httpClient = okHttpClient;

      headers.put("Authorization", "Bearer " + apiKey);
      headers.put("Accept", "application/json");
   }

   public Optional<Quote> getQuote(@Nonnull String symbol, @Nullable Boolean includeGreeks) {
      List<Quote> quotes = getQuotes(List.of(symbol), includeGreeks);
      return quotes.isEmpty() ? Optional.empty() : Optional.of(quotes.get(0));
   }

   // TODO: Add retryable as Tradier sometimes refuses connection
   public List<Quote> getQuotes(List<String> symbols, @Nullable Boolean includeGreeks) {
      return fetchQuotes(symbols, includeGreeks, false);
   }

   // TODO: Add retryable as Tradier sometimes refuses connection
   public List<Quote> postQuotes(List<String> symbols, @Nullable Boolean includeGreeks) {
      return fetchQuotes(symbols, includeGreeks, true);
   }

   private List<Quote> fetchQuotes(List<String> symbols, @Nullable Boolean includeGreeks, boolean isPost) {
      Objects.requireNonNull(symbols);

      List<Quote> quotes = new ArrayList<>();
      try {
         String url = String.format(baseUrl + "/v1/markets/quotes");
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

         Response response = httpClient.newCall(request).execute();

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

   public List<HistoricPrice> getPriceHistory(@Nonnull String symbol) {
      return getPriceHistory(symbol, null, null, null, null);
   }

   public List<HistoricPrice> getPriceHistory(@Nonnull String symbol, @Nullable LocalDate fromDate,
         @Nullable LocalDate toDate) {
      return getPriceHistory(symbol, null, fromDate, toDate, null);
   }

   public List<HistoricPrice> getPriceHistory(@Nonnull String symbol, @Nullable Interval interval,
         @Nullable LocalDate fromDate, @Nullable LocalDate toDate, @Nullable SessionFilter sessionFilter) {
      Objects.requireNonNull(symbol);

      if (fromDate != null && toDate != null && fromDate.isAfter(toDate))
         throw new IllegalArgumentException("From date can not be after To date");

      try {
         String url = String.format(baseUrl + "/v1/markets/history");
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

         Response response = httpClient.newCall(request).execute();

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

   public TimeSalesResponse getTimeSales(@Nonnull String symbol, @Nullable Interval interval,
         @Nullable LocalDateTime start, @Nullable LocalDateTime end, @Nullable SessionFilter sessionFilter) {
      Objects.requireNonNull(symbol);

      if (start != null && end != null && start.isAfter(end))
         throw new IllegalArgumentException("Start time can not be after end time");

      try {
         String url = String.format(baseUrl + "/v1/markets/timesales");
         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         httpBuilder.addQueryParameter("symbol", symbol);
         httpBuilder.addQueryParameter("interval", (interval == null) ? "daily" : interval.toString());
         httpBuilder.addQueryParameter("session_filter", (interval == null) ? "all" : interval.toString());
         if (start != null) {
            httpBuilder.addQueryParameter("start", isoDateTime(start));
         }
         if (end != null) {
            httpBuilder.addQueryParameter("end", isoDateTime(end));
         }

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
//            JsonNode dayNode = jsonTree.findPath("history").findPath("day");

            if (jsonTree.isNull() || jsonTree.isMissingNode())
               return new TimeSalesResponse();

            // Tradier returns single quote as an object while multi as an Array
            if (jsonTree.isObject()) {
               TimeSalesResponse timeSeries = mapper.treeToValue(jsonTree, TimeSalesResponse.class);
               return timeSeries;
            } else {
               TimeSalesResponse timeSeries = mapper.treeToValue(jsonTree, TimeSalesResponse.class);
               // direct mapping to List<> may not parse and will make List<LinkedHashMap<..>>.
               // Rather map to a object[] and then stream to list
//               if (historicArray.length > 0)
//                  return Arrays.stream(historicArray).collect(Collectors.toList());
               return timeSeries;
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }
      return new TimeSalesResponse();
   }

   //TODO: NOT yet complete as the response structure changes based on the request.
   public List<LocalDate> getOptionExpieryDates(@Nonnull String underlyingSymbol) {
      Objects.requireNonNull(underlyingSymbol);

      List<LocalDate> expireDates = new ArrayList<>();
      try {
         String url = String.format(baseUrl + "/v1/markets/options/expirations");

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

         Response response = httpClient.newCall(request).execute();

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

   public List<Option> getOptionChainFor(@Nonnull String underlyingSymbol, @Nonnull LocalDate expieryDate,
         @Nullable Boolean greeks) {
      Objects.requireNonNull(underlyingSymbol);
      Objects.requireNonNull(expieryDate);

      List<Option> optionQuotes = new ArrayList<>();
      try {
         String url = String.format(baseUrl + "/v1/markets/options/chains");

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         httpBuilder.addQueryParameter("symbol", underlyingSymbol)
               .addQueryParameter("expiration", expieryDate.format(DateTimeFormatter.ISO_LOCAL_DATE))
               .addQueryParameter("greeks", (greeks == null) ? "true" : greeks.toString());

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

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

   public List<Double> getOptionStrikes(OptionStrikePricesRequest strikePricesRequest) {
      Objects.requireNonNull(strikePricesRequest);
      Objects.requireNonNull(strikePricesRequest.getSymbol());
      Objects.requireNonNull(strikePricesRequest.getExpiration());

      List<Double> expireDates = new ArrayList<>();
      try {
         String url = String.format(baseUrl + "/v1/markets/options/strikes");

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         strikePricesRequest.buildParametersMap().entrySet()
               .forEach(entry -> httpBuilder.addQueryParameter(entry.getKey(), entry.getValue()));

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

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

   public Optional<Security> lookupSymbol(String symbol) {
      List<SecurityType> types = new ArrayList<>();
      List<ExchangeCode> exchanges = new ArrayList<>();

      List<Security> securities = lookupSymbol(symbol, exchanges, types);
      return securities.isEmpty() ? Optional.empty() : Optional.of(securities.get(0));
   }

   public List<Security> lookupSymbol(@Nonnull String symbol, @Nullable List<ExchangeCode> exchangeCodes,
         @Nullable List<SecurityType> securityTypes) {
      Objects.requireNonNull(symbol);
      try {
         String url = String.format(baseUrl + "/v1/markets/lookup");

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         httpBuilder.addQueryParameter("q", symbol);
         if (exchangeCodes != null && !exchangeCodes.isEmpty())
            httpBuilder.addQueryParameter("exchanges",
                  exchangeCodes.stream().map(String::valueOf).collect(Collectors.joining(",")));
         if (securityTypes != null && !securityTypes.isEmpty())
            httpBuilder.addQueryParameter("types",
                  securityTypes.stream().map(String::valueOf).collect(Collectors.joining(",")));

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

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
                  return Arrays.stream(securityArray).collect(Collectors.toList());
               }
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }

      return new ArrayList<>();
   }

   public List<String> lookupOptionSymbolsFor(@Nonnull String underlyingStockSymbol) {
      Objects.requireNonNull(underlyingStockSymbol);

      try {
         String url = String.format(baseUrl + "/v1/markets/options/lookup");

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         httpBuilder.addQueryParameter("underlying", underlyingStockSymbol);

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

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

   public List<Security> searchCompany(@Nonnull String name, @Nullable Boolean includeIndexes) {
      try {
         String url = String.format(baseUrl + "/v1/markets/search");

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         httpBuilder.addQueryParameter("q", name);
         if (includeIndexes != null)
            httpBuilder.addQueryParameter("exchanges", includeIndexes.toString());

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

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
                  return Arrays.stream(securityArray).collect(Collectors.toList());
               }
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }

      return new ArrayList<>();
   }

   public Clock getClock(@Nullable Boolean delayed) {
      try {
         String url = String.format(baseUrl + "/v1/markets/clock");

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         httpBuilder.addQueryParameter("delayed", (delayed == null) ? "true" : delayed.toString());

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

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

   public MarketCalendar getCalendar(@Nullable Integer month, @Nullable Integer year) {
      try {
         String url = String.format(baseUrl + "/v1/markets/calendar");

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         if (month != null)
            httpBuilder.addQueryParameter("month", month.toString());
         if (year != null)
            httpBuilder.addQueryParameter("year", year.toString());

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

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

}
