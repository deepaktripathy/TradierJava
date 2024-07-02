package com.tradierapi.tradierjava.client.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tradierapi.tradierjava.client.account.request.GainLossRequest;
import com.tradierapi.tradierjava.client.account.response.Balances;
import com.tradierapi.tradierjava.client.account.response.GainLossResponse;
import com.tradierapi.tradierjava.client.account.response.Order;
import com.tradierapi.tradierjava.client.account.response.Orders;
import com.tradierapi.tradierjava.client.account.response.Position;
import com.tradierapi.tradierjava.client.account.response.Positions;
import com.tradierapi.tradierjava.client.trader.TraderAPI;
import com.tradierapi.tradierjava.utils.Utils;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 
 * @author deepak tripathy created on 07/02/2024
 *
 */
public class AccountAPI {
   private static final Logger LOGGER = LoggerFactory.getLogger(AccountAPI.class);

   public static final String KEY_ACCOUNT_ACCOUNT_TYPE = "account_type";
   public static final String KEY_ACCOUNT_TOTAL_CASH = "total_cash";
   public static final String KEY_ACCOUNT_PENDING_CASH = "pending_cash";// cash allocated for pending orders
   public static final String KEY_ACCOUNT_CASH_AVAILABLE = "cash_available";// in a CASH account
   public static final String KEY_ACCOUNT_STOCK_BP = "stock_buying_power";// in a Margin account
   public static final String KEY_ACCOUNT_OPTION_BP = "option_buying_power";// in a Margin account

   private String baseUrl;
   private String apiKey;
   private OkHttpClient httpClient;
   private Map<String, String> headers = new HashMap<String, String>();

   private TraderAPI trader;

   public AccountAPI(String baseUrl, String apiSecretKey, OkHttpClient okHttpClient) {

      this.baseUrl = baseUrl;
      this.apiKey = apiSecretKey;
      this.httpClient = okHttpClient;

      headers.put("Authorization", "Bearer " + apiKey);
      headers.put("Accept", "application/json");
   }

   /**
    * Returns the TraderAPI servicing all the trading related endpoints. This is a
    * subset under accounts '/accounts'
    */
   public synchronized TraderAPI trader() {
      if (trader == null) {
         trader = new TraderAPI(baseUrl, apiKey, httpClient);
      }
      return trader;
   }

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

   public Balances getAccountBalances(@Nonnull String accountId) {
      Objects.requireNonNull(accountId);

      Map<String, Object> params = new HashMap<>();

      try {
         String url = String.format(baseUrl + "/v1/accounts/%s/balances", accountId);

         Request.Builder requestBuilder = new Request.Builder().url(url).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

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

   public List<Position> getPositions(@Nonnull String accountId) {
      Objects.requireNonNull(accountId);

      List<Position> positions = new ArrayList<>();
      try {
         String url = String.format(baseUrl + "/v1/accounts/%s/positions", accountId);

         Request.Builder requestBuilder = new Request.Builder().url(url).get();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

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

   public GainLossResponse getGainLoss(@Nonnull String accountId, GainLossRequest gainLossRequest) {
      Objects.requireNonNull(accountId);

      try {
         String url = String.format(baseUrl + "/v1/accounts/%s/gainloss", accountId);

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         if (gainLossRequest != null) {
            gainLossRequest.buildParametersMap().entrySet()
                  .forEach(entry -> httpBuilder.addQueryParameter(entry.getKey(), entry.getValue()));
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

   public List<Order> getOrders(@Nonnull String accountId, @Nullable Integer page, @Nullable Boolean includeTags) {
      List<Order> orders = new ArrayList<>();

      String url = String.format(baseUrl + "/v1/accounts/%s/orders", accountId);

      HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
      httpBuilder.addQueryParameter("page", (page == null) ? "1" : page.toString());
      httpBuilder.addQueryParameter("includeTags", (includeTags == null) ? "false" : includeTags.toString());

      Request.Builder requestBuilder = new Request.Builder().url(httpBuilder.build()).get();
      headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
      Request request = requestBuilder.build();

      try {
         Response response = httpClient.newCall(request).execute();

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

   public Optional<Order> getOrder(@Nonnull String accountId, @Nonnull Long orderId, @Nullable Boolean includeTags) {
      Objects.requireNonNull(accountId);
      Objects.requireNonNull(orderId);

      try {
         String url = String.format(baseUrl + "/v1/accounts/%s/orders/%s", accountId, orderId);

         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
         httpBuilder.addQueryParameter("includeTags", (includeTags == null) ? "false" : includeTags.toString());

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

   // TODO: get History
}
