package com.deepaktripathy.tradierjava.client.fundamental.response.statistics;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Period10y extends UnrecognizedFieldsCollector {

   @JsonProperty("arithmetic_mean") 
   private Double arithmeticMean;
   
   @JsonProperty("as_of_date") 
   private String asOfDate;
   
   @JsonProperty("best3_month_total_return") 
   private Double best3MonthTotalReturn;
   
   @JsonProperty("period") 
   private String period;
   
   @JsonProperty("share_class_id") 
   private String shareClassID;
   
   @JsonProperty("standard_deviation") 
   private Double standardDeviation;
   
   @JsonProperty("total_return") 
   private Double totalReturn;
   
   @JsonProperty("worst3_month_total_return") 
   private Double worst3MonthTotalReturn;
 }