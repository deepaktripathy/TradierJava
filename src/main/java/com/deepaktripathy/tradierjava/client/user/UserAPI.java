package com.deepaktripathy.tradierjava.client.user;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deepaktripathy.tradierjava.client.user.response.Profile;
import com.deepaktripathy.tradierjava.utils.Utils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
public class UserAPI {
   private static final Logger LOGGER = LoggerFactory.getLogger(UserAPI.class);

   private String baseUrl;
   private String apiKey;
   private OkHttpClient httpClient;
   private Map<String, String> headers = new HashMap<String, String>();

   public UserAPI(String baseUrl, String apiSecretKey, OkHttpClient okHttpClient) {

      this.baseUrl = baseUrl;
      this.apiKey = apiSecretKey;
      this.httpClient = okHttpClient;

      headers.put("Authorization", "Bearer " + apiKey);
      headers.put("Accept", "application/json");
   }

   public Profile getUserProfile() {
      try {
         String url = baseUrl + "/v1/user/profile";
         HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();

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
}
