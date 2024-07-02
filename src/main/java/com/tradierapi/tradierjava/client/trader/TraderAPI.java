package com.tradierapi.tradierjava.client.trader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tradierapi.tradierjava.client.trader.request.EquityOrderRequest;
import com.tradierapi.tradierjava.client.trader.request.OptionOrderRequest;
import com.tradierapi.tradierjava.utils.Utils;

import okhttp3.FormBody;
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
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }

      return 0;
   }

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
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }
      return 0;
   }

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
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }
      return 0;
   }

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
      } catch (IOException ex) {
         throw new RuntimeException(ex);
      }

      return 0;
   }

}
