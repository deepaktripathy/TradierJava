package com.deepaktripathy.tradierjava.client.trader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deepaktripathy.tradierjava.client.trader.request.EquityOrderRequest;
import com.deepaktripathy.tradierjava.client.trader.request.OptionOrderRequest;
import com.deepaktripathy.tradierjava.utils.Utils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Recommended Workflow from Tradier docs:
 * For most integrations, follow this pattern for any order:
 * Preview the order with preview=true to validate parameters and see costs
 * If result: true, submit the same payload with preview=false
 * Poll GET /v1/accounts/{account_id}/orders/{order_id} to monitor status — confirm it reaches open, partially_filled, or filled rather than rejected or canceled
 * Cancel or modify as needed while the order is still open
 * 
 * @author deepak tripathy created on 07/02/2024
 *
 */
public class TraderAPI {
   private static final Logger LOGGER = LoggerFactory.getLogger(TraderAPI.class);

   private String baseUrl;
   private String apiKey;
   private OkHttpClient httpClient;
   private final Map<String, String> headers = new HashMap<String, String>();

   public TraderAPI(String baseUrl, String apiSecretKey, OkHttpClient okHttpClient) {

      this.baseUrl = baseUrl;
      this.apiKey = apiSecretKey;
      this.httpClient = okHttpClient;

      headers.put("Authorization", "Bearer " + apiKey);
      headers.put("Accept", "application/json");
   }

   /** 
    * Deletes an order.<br> 
    * Tradier may return 200 - OK response which means the API call submitting 
    * the order was correct and the order has been received but the order could 
    * still be rejected at the brokerage level.<br> 
    * So, it is important to check the order status after placing the order. 
    * 
    * @param accountId
    * @param orderId id of existing order.
    * @return supplied orderId if order is received,
    */
   public long cancelOrder(@Nonnull String accountId, @Nonnull Long orderId) {
      Objects.requireNonNull(accountId);
      Objects.requireNonNull(orderId);

      try {
         String url = String.format(baseUrl + "/v1/accounts/%s/orders/%s", accountId, orderId);

         Request.Builder requestBuilder = new Request.Builder().url(url).delete();
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

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
         response.close();
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }

      return 0;
   }

   /**
    * Posts a stock trade order.<br>
    * Tradier may return 200 - OK response which means the API call submitting 
    * the order was correct and the order has been received but the order could 
    * still be rejected at the brokerage level.<br> 
    * So, it is important to check the order status after placing the order. 
    * 
    * @param accountId
    * @param orderReq
    * @return
    */
   public long postStockOrder(@Nonnull String accountId, EquityOrderRequest orderReq) {
      Objects.requireNonNull(accountId);
      try {
         String url = String.format(baseUrl + "/v1/accounts/%s/orders", accountId);

         FormBody.Builder formBody = new FormBody.Builder();
         orderReq.getRequestParams().entrySet().forEach(entry -> formBody.add(entry.getKey(), entry.getValue()));
         RequestBody body = formBody.build();

         Request.Builder requestBuilder = new Request.Builder().url(url).post(body);
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

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
         response.close();
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }
      return 0;
   }

   /**
    * Posts an Option trade order.<br>
    * Tradier may return 200 - OK response which means the API call submitting 
    * the order was correct and the order has been received but the order could 
    * still be rejected at the brokerage level.<br> 
    * So, it is important to check the order status after placing the order. 
    * 
    * @param accountId
    * @param orderReq
    * @return
    */
   public long postOptionOrder(@Nonnull String accountId, OptionOrderRequest orderReq) {
      Objects.requireNonNull(accountId);
      try {
         String url = String.format(baseUrl + "/v1/accounts/%s/orders", accountId);

         FormBody.Builder formBody = new FormBody.Builder();
         orderReq.getRequestParams().entrySet().forEach(entry -> formBody.add(entry.getKey(), entry.getValue()));
         RequestBody body = formBody.build();

         Request.Builder requestBuilder = new Request.Builder().url(url).post(body);
         headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
         Request request = requestBuilder.build();

         Response response = httpClient.newCall(request).execute();

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
         response.close();
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }
      return 0;
   }

   /**
    * Modify the type, duration, price or stop price of an open order.<br>
    * The quantity can not be modified.<br>
    * An order is modifiable only if its status is open or partially_filled.<br> 
    * So, check the order status before sending for modification.<br>
    * 
    * Tradier may return 200 - OK response which means the API call submitting 
    * the order was correct and the order has been received but the order could 
    * still be rejected at the brokerage level.<br> 
    * So, it is important to check the order status after placing the order. 
    * 
    * 
    * @param accountId
    * @param existingOrderId
    * @param orderType
    * @param duration
    * @param price
    * @param stopPrice
    * @return
    */
   public long modifyOrder(@Nonnull String accountId, @Nonnull Long existingOrderId, @Nullable String orderType,
         @Nullable String duration, @Nullable Double price, @Nullable Double stopPrice) {
      Objects.requireNonNull(accountId);
      Objects.requireNonNull(existingOrderId);

      try {
         String url = String.format(baseUrl + "/v1/accounts/%s/orders/%s", accountId, existingOrderId);

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

         Response response = httpClient.newCall(request).execute();

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
         response.close();
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }

      return 0;
   }

}
