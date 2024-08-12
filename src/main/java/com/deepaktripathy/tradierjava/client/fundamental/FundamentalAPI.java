package com.deepaktripathy.tradierjava.client.fundamental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deepaktripathy.tradierjava.client.fundamental.response.companystats.CompanyStatisticsResponse;
import com.deepaktripathy.tradierjava.client.fundamental.response.companystats.CompanyStatisticsRoot;
import com.deepaktripathy.tradierjava.client.fundamental.response.corpaction.CorpActionRoot;
import com.deepaktripathy.tradierjava.client.fundamental.response.corpcalendar.CalendarRoot;
import com.deepaktripathy.tradierjava.client.fundamental.response.corpcalendar.CorpCalendarsResponse;
import com.deepaktripathy.tradierjava.client.fundamental.response.dividend.DividendRoot;
import com.deepaktripathy.tradierjava.client.fundamental.response.dividend.DividendsResponse;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.FinancialsResponse;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.FinancialsRoot;
import com.deepaktripathy.tradierjava.client.fundamental.response.ratios.FinancialRatiosResponse;
import com.deepaktripathy.tradierjava.client.fundamental.response.ratios.RatiosRoot;
import com.deepaktripathy.tradierjava.client.fundamental.response.statistics.StatisticsResponse;
import com.deepaktripathy.tradierjava.client.fundamental.response.statistics.StatisticsRoot;
import com.deepaktripathy.tradierjava.client.marketdata.MarketDataAPI;
import com.deepaktripathy.tradierjava.utils.Utils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Tradier's Fundamental API is in experimental stage and the API returns extra data as well as more 
 * columns. The data is also not correct. Use with caution.
 * 
 * The response parameters are manually copied and converted and may contain typos. Corrections will 
 * be done as detected.
 * 
 * @author deepak created on 07/31/2024
 *
 */
public class FundamentalAPI {
   private static final Logger LOGGER = LoggerFactory.getLogger(MarketDataAPI.class);

   private String baseUrl;
   private String apiKey;
   private OkHttpClient httpClient;
   private Map<String, String> headers = new HashMap<String, String>();

   public FundamentalAPI(String baseUrl, String apiSecretKey, OkHttpClient okHttpClient) {

      this.baseUrl = baseUrl;
      this.apiKey = apiSecretKey;
      this.httpClient = okHttpClient;

      headers.put("Authorization", "Bearer " + apiKey);
      headers.put("Accept", "application/json");
   }
   
   public StatisticsResponse getPriceStatistics(List<String> symbols) {
      Objects.requireNonNull(symbols);

      StatisticsResponse statisticsResponse = new StatisticsResponse();
      try {
         String url = String.format(baseUrl + "/beta/markets/fundamentals/statistics");
         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();

         httpBuilder.addQueryParameter("symbols", symbols.stream().collect(Collectors.joining(",")));

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();

         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         LOGGER.debug("resp length: " + responseBodyStr.length());
         for(int count = 0; count < responseBodyStr.length(); count+=9000)
            LOGGER.debug(responseBodyStr.substring(count,  Math.min(count+9000, responseBodyStr.length()-1)));
         
         //LOGGER.debug("resp: " + responseBodyStr);
         
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            LOGGER.debug("treeNode: " + jsonTree);
//            JsonNode quoteNode = jsonTree.findPath("quotes").findPath("quote");

            // Tradier returns single quote as an object while multi as an Array
            if (jsonTree.isObject()) {
               StatisticsRoot statisticsRoot = mapper.treeToValue(jsonTree, StatisticsRoot.class);
               LOGGER.debug("single Node: " + statisticsRoot);
               statisticsResponse.setStatistics(List.of(statisticsRoot));
            } else {
               StatisticsRoot[] statisticsRoot = mapper.treeToValue(jsonTree, StatisticsRoot[].class);
               LOGGER.debug("list Node: " + Stream.of(statisticsRoot).collect(Collectors.toList()));
               statisticsResponse.setStatistics(Stream.of(statisticsRoot).collect(Collectors.toList()));
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (Exception ex) {
         throw new RuntimeException(ex);
      }
      return statisticsResponse;
   }

   /** 
    * There is possible duplication and unrelated fields for each category. 
    * TODO: Separate them to different groups. 
    * */
   public FinancialRatiosResponse getFinancialRatios(List<String> symbols) {
      Objects.requireNonNull(symbols);

      FinancialRatiosResponse finRatiosResponse = new FinancialRatiosResponse();
      try {
         String url = String.format(baseUrl + "/beta/markets/fundamentals/ratios");
         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();

         httpBuilder.addQueryParameter("symbols", symbols.stream().collect(Collectors.joining(",")));

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();

         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         LOGGER.debug("resp length: " + responseBodyStr.length());
         for(int count = 0; count < responseBodyStr.length(); count+=9000)
            LOGGER.debug(responseBodyStr.substring(count,  Math.min(count+9000, responseBodyStr.length()-1)));
         
         //LOGGER.debug("resp: " + responseBodyStr);
         
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            LOGGER.debug("treeNode: " + jsonTree);
//            JsonNode quoteNode = jsonTree.findPath("quotes").findPath("quote");

            // Tradier returns single quote as an object while multi as an Array
            if (jsonTree.isObject()) {
               RatiosRoot ratiosRoot = mapper.treeToValue(jsonTree, RatiosRoot.class);
               LOGGER.debug("single Node: " + ratiosRoot);
               finRatiosResponse.setRatios(List.of(ratiosRoot));
            } else {
               RatiosRoot[] ratiosRoot = mapper.treeToValue(jsonTree, RatiosRoot[].class);
               LOGGER.debug("list Node: " + Stream.of(ratiosRoot).collect(Collectors.toList()));
               finRatiosResponse.setRatios(Stream.of(ratiosRoot).collect(Collectors.toList()));
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (Exception ex) {
         throw new RuntimeException(ex);
      }
      return finRatiosResponse;
   }

   /**
    * This method in particular needs to be revisited as the source data structure 
    * is changing as well as new fields are being added by Tradier. So, this will be 
    * revisited and get fixed.
    * Note: Since the return data is huge, it is suggested to send very few symbols 
    * each batch to not slow the system.
    * Ex: For TSLA, a newwe company, the returned data size is 33k.
    * */
   public FinancialsResponse getFinacialStatements(List<String> symbols) {
      Objects.requireNonNull(symbols);

      FinancialsResponse financialsResponse = new FinancialsResponse();
      try {
         String url = String.format(baseUrl + "/beta/markets/fundamentals/financials");
         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();

         httpBuilder.addQueryParameter("symbols", symbols.stream().collect(Collectors.joining(",")));

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();

         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         LOGGER.debug("resp length: " + responseBodyStr.length());
         for(int count = 0; count < responseBodyStr.length(); count+=9000)
            System.out.println(responseBodyStr.substring(count,  Math.min(count+9000, responseBodyStr.length())));
         
         //LOGGER.debug("resp: " + responseBodyStr);
         
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            LOGGER.debug("treeNode: " + jsonTree.toString());

            // Tradier returns single quote as an object while multi as an Array
            if (jsonTree.isObject()) {
               FinancialsRoot financialsRoot = mapper.treeToValue(jsonTree, FinancialsRoot.class);
               LOGGER.debug("single Node: " + financialsRoot);
               financialsResponse.setFinancials(List.of(financialsRoot));
            } else {
               FinancialsRoot[] financialsRoot = mapper.treeToValue(jsonTree, FinancialsRoot[].class);
               LOGGER.debug("list Node: " + Stream.of(financialsRoot).collect(Collectors.toList()));
               financialsResponse.setFinancials(Stream.of(financialsRoot).collect(Collectors.toList()));
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (Exception ex) {
         throw new RuntimeException(ex);
      }
      return financialsResponse;
   }

   
   public CorpCalendarsResponse getCorpCalendars(List<String> symbols) {
      Objects.requireNonNull(symbols);

      CorpCalendarsResponse calResponse = new CorpCalendarsResponse();
      try {
         String url = String.format(baseUrl + "/beta/markets/fundamentals/calendars");
         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();

         httpBuilder.addQueryParameter("symbols", symbols.stream().collect(Collectors.joining(",")));

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();

         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         LOGGER.debug("resp length: " + responseBodyStr.length());
         for(int count = 0; count < responseBodyStr.length(); count+=9000)
            LOGGER.debug(responseBodyStr.substring(count,  Math.min(count+9000, responseBodyStr.length()-1)));
         
         //LOGGER.debug("resp: " + responseBodyStr);
         
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            LOGGER.debug("treeNode: " + jsonTree);
//            JsonNode quoteNode = jsonTree.findPath("quotes").findPath("quote");

            // Tradier returns single quote as an object while multi as an Array
            if (jsonTree.isObject()) {
               CalendarRoot calRoot = mapper.treeToValue(jsonTree, CalendarRoot.class);
               LOGGER.debug("single Node: " + calRoot);
               calResponse.setCalendars(List.of(calRoot));
            } else {
               CalendarRoot[] calRoots = mapper.treeToValue(jsonTree, CalendarRoot[].class);
               LOGGER.debug("list Node: " + Stream.of(calRoots).collect(Collectors.toList()));
               calResponse.setCalendars(Stream.of(calRoots).collect(Collectors.toList()));
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (Exception ex) {
         throw new RuntimeException(ex);
      }
      return calResponse;
   }

   public DividendsResponse getDividends(List<String> symbols) {
      Objects.requireNonNull(symbols);

      DividendsResponse diviResponse = new DividendsResponse();
      try {
         //String url = String.format(baseUrl + "/beta/markets/fundamentals/corporate_actions?symbols=MSFT");
         String url = String.format(baseUrl + "/beta/markets/fundamentals/dividends");
         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();

         httpBuilder.addQueryParameter("symbols", symbols.stream().collect(Collectors.joining(",")));

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();

         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         LOGGER.debug("resp length: " + responseBodyStr.length());
         for(int count = 0; count < responseBodyStr.length(); count+=9000)
            LOGGER.debug(responseBodyStr.substring(count,  Math.min(count+9000, responseBodyStr.length()-1)));
         
         //LOGGER.debug("resp: " + responseBodyStr);
         
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            LOGGER.debug("treeNode: " + jsonTree);

            // Tradier returns single quote as an object while multi as an Array
            if (jsonTree.isObject()) {
               DividendRoot diviRoot = mapper.treeToValue(jsonTree, DividendRoot.class);
               LOGGER.debug("single Node: " + diviRoot);
               diviResponse.setDividends(List.of(diviRoot));
            } else {
               DividendRoot[] diviRoots = mapper.treeToValue(jsonTree, DividendRoot[].class);
               LOGGER.debug("list Node: " + Stream.of(diviRoots).collect(Collectors.toList()));
               diviResponse.setDividends(Stream.of(diviRoots).collect(Collectors.toList()));
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (Exception ex) {
         throw new RuntimeException(ex);
      }
      return diviResponse;
   }

   public CompanyStatisticsResponse getCompanyStatistics(List<String> symbols) {
      Objects.requireNonNull(symbols);

      CompanyStatisticsResponse statResponse = new CompanyStatisticsResponse();
      try {
         //String url = String.format(baseUrl + "/beta/markets/fundamentals/corporate_actions");
         String url = String.format(baseUrl + "/beta/markets/fundamentals/company");
         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();

         httpBuilder.addQueryParameter("symbols", symbols.stream().collect(Collectors.joining(",")));

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();

         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         LOGGER.debug("resp length: " + responseBodyStr.length());
         for(int count = 0; count < responseBodyStr.length(); count+=9000)
            LOGGER.debug(responseBodyStr.substring(count,  Math.min(count+9000, responseBodyStr.length()-1)));
         
         //LOGGER.debug("resp: " + responseBodyStr);
         
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            LOGGER.debug("treeNode: " + jsonTree);
//            JsonNode quoteNode = jsonTree.findPath("quotes").findPath("quote");

            // Tradier returns single quote as an object while multi as an Array
            if (jsonTree.isObject()) {
               CompanyStatisticsRoot root = mapper.treeToValue(jsonTree, CompanyStatisticsRoot.class);
               LOGGER.debug("single Node: " + root);
               statResponse.setCompanyStatistics(List.of(root));
            } else {
               CompanyStatisticsRoot[] roots = mapper.treeToValue(jsonTree, CompanyStatisticsRoot[].class);
               LOGGER.debug("list Node: " + Stream.of(roots).collect(Collectors.toList()));
               statResponse.setCompanyStatistics(Stream.of(roots).collect(Collectors.toList()));
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (Exception ex) {
         throw new RuntimeException(ex);
      }
      return statResponse;
   }
   
   //this is broken. splits coming as date keys
   public List<CorpActionRoot> getCorpActions(List<String> symbols) {
      Objects.requireNonNull(symbols);

      List<CorpActionRoot> corpActions = new ArrayList<>();
      try {
         String url = String.format(baseUrl + "/beta/markets/fundamentals/corporate_actions");
         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();

         httpBuilder.addQueryParameter("symbols", symbols.stream().collect(Collectors.joining(",")));

         Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();

         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

         ResponseBody responseBody = response.body();
         int responseCode = response.code();
         String responseBodyStr = responseBody.string();
         LOGGER.debug("resp length: " + responseBodyStr.length());
         for(int count = 0; count < responseBodyStr.length(); count+=9000)
            LOGGER.debug(responseBodyStr.substring(count,  Math.min(count+9000, responseBodyStr.length()-1)));
         
         //LOGGER.debug("resp: " + responseBodyStr);
         
         if (responseCode == 200) {
            ObjectMapper mapper = Utils.objectMapper();
//            mapper.configure(DeserializationFeature.pr, false)
            final JsonNode jsonTree = mapper.readTree(responseBodyStr);
            LOGGER.debug("treeNode: " + jsonTree);
//            JsonNode quoteNode = jsonTree.findPath("quotes").findPath("quote");

            // Tradier returns single quote as an object while multi as an Array
            if (jsonTree.isObject()) {
               CorpActionRoot quote = mapper.treeToValue(jsonTree, CorpActionRoot.class);
               corpActions.add(quote);
            } else {
               CorpActionRoot[] roots = mapper.treeToValue(jsonTree, CorpActionRoot[].class);
               if (roots != null && roots.length > 0)
                  corpActions.addAll(Stream.of(roots).collect(Collectors.toList()));
            }
         } else
            LOGGER.warn("Response code: " + responseCode + ", reason: " + responseBodyStr);
      } catch (Exception ex) {
         throw new RuntimeException(ex);
      }
      return corpActions;
   }

}
