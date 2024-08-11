package com.deepaktripathy.tradierjava.client.marketdata.request;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.deepaktripathy.tradierjava.utils.Utils;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OptionStrikePricesRequest {

   @JsonProperty("symbol")
   String symbol;

   @JsonProperty("expiration")
   LocalDate expiration;

   @JsonProperty("includeAllRoots")
   Boolean includeAllRoots;

   public String getSymbol() {
      return symbol;
   }

   public void setSymbol(String symbol) {
      this.symbol = symbol;
   }

   @javax.annotation.Nullable
   public LocalDate getExpiration() {
      return expiration;
   }

   public void setExpiration(LocalDate expiration) {
      this.expiration = expiration;
   }

   @javax.annotation.Nullable
   public Boolean getIncludeAllRoots() {
      return includeAllRoots;
   }

   public void setIncludeAllRoots(Boolean includeAllRoots) {
      this.includeAllRoots = includeAllRoots;
   }

   /** Returns a map of keys and values */
   public Map<String, String> buildParametersMap() {
      Map<String, String> paramsMap = new HashMap<>();

      Utils.addIfValid(paramsMap, "symbol", symbol);
      Utils.addIfValid(paramsMap, "expiration", expiration);
      Utils.addIfValid(paramsMap, "includeAllRoots", includeAllRoots);

      return paramsMap;
   }

}
