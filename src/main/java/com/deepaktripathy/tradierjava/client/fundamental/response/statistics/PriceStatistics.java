package com.deepaktripathy.tradierjava.client.fundamental.response.statistics;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
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
}