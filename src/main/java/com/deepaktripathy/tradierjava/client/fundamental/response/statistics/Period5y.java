package com.deepaktripathy.tradierjava.client.fundamental.response.statistics;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Period5y extends UnrecognizedFieldsCollector {

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
   
   @JsonProperty("total_return") 
   private Double totalReturn;
}
