package com.deepaktripathy.tradierjava.client.fundamental.response.statistics;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceStatistics extends UnrecognizedFieldsCollector {
   @JsonProperty("period_30d") 
   private Period30d period30d;
   
   @JsonProperty("period_60d") 
   private Period60d period60d;
   
   @JsonProperty("period_90d") 
   private Period90d period90d;

   @JsonProperty("period_1y") 
   private Period1y period1yr;
 
   @JsonProperty("period_3y") 
   private Period3y period3yr;
   
   @JsonProperty("period_5y") 
   private Period5y period5yr;
   
   @JsonProperty("period_10y") 
   private Period10y period10yr;

   @Override
   public String toString() {
      return "PriceStatistics [period30d=" + period30d + ", period60d=" + period60d + ", period90d=" + period90d
            + ", period1yr=" + period1yr + ", period3yr=" + period3yr + ", period5yr=" + period5yr + ", period10yr="
            + period10yr + "]";
   }
   
   
}