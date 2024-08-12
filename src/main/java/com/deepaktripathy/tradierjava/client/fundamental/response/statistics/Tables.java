package com.deepaktripathy.tradierjava.client.fundamental.response.statistics;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tables extends UnrecognizedFieldsCollector {
   @JsonProperty("price_statistics") 
   private PriceStatistics priceStatistics;

   @JsonProperty("trailing_returns") 
   private TrailingReturns trailingReturns;

   @Override
   public String toString() {
      return "Tables [priceStatistics=" + priceStatistics + ", trailingReturns=" + trailingReturns + "]";
   }
   
}