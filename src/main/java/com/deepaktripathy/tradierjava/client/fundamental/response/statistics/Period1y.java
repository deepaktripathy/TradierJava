package com.deepaktripathy.tradierjava.client.fundamental.response.statistics;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Period1y extends UnrecognizedFieldsCollector {
   @JsonProperty("share_class_id") 
   private String shareClassID;
   
   @JsonProperty("as_of_date") 
   private String asOfDate;
   
   @JsonProperty("period") 
   private String period;
   
   @JsonProperty("arithmetic_mean") 
   private Double arithmeticMean;
   
   @JsonProperty("best3_month_total_return") 
   private Double best3MonthTotalReturn;
   
   @JsonProperty("standard_deviation") 
   private Double standardDeviation;
   
   @JsonProperty("worst3_month_total_return") 
   private Double worst3MonthTotalReturn;
   
   @JsonProperty("high_price") 
   private Double highPrice;
   
   @JsonProperty("low_price") 
   private Double lowPrice;
   
   @JsonProperty("total_return") 
   private Double totalReturn;

   @Override
   public String toString() {
      return "Period1y [shareClassID=" + shareClassID + ", asOfDate=" + asOfDate + ", period=" + period
            + ", arithmeticMean=" + arithmeticMean + ", best3MonthTotalReturn=" + best3MonthTotalReturn
            + ", standardDeviation=" + standardDeviation + ", worst3MonthTotalReturn=" + worst3MonthTotalReturn
            + ", highPrice=" + highPrice + ", lowPrice=" + lowPrice + ", totalReturn=" + totalReturn + "]";
   }
}