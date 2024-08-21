package com.deepaktripathy.tradierjava.client.fundamental.response.ratios; 

import com.deepaktripathy.tradierjava.client.fundamental.response.ratios.earningrestate.Period10y;
import com.deepaktripathy.tradierjava.client.fundamental.response.ratios.earningrestate.Period1y;
import com.deepaktripathy.tradierjava.client.fundamental.response.ratios.earningrestate.Period3m;
import com.deepaktripathy.tradierjava.client.fundamental.response.ratios.earningrestate.Period3y;
import com.deepaktripathy.tradierjava.client.fundamental.response.ratios.earningrestate.Period5y;
import com.deepaktripathy.tradierjava.client.fundamental.response.ratios.earningrestate.Period6m;
import com.deepaktripathy.tradierjava.client.fundamental.response.ratios.earningrestate.Period9m;
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EarningRatiosRestate extends UnrecognizedFieldsCollector {

   @JsonProperty("period_10y") 
   private Period10y period10Yr;

   @JsonProperty("period_1y") 
   private Period1y period1Yr;

   @JsonProperty("period_3m") 
   private Period3m period3Mo;

   @JsonProperty("period_3y") 
   private Period3y period3Yr;

   @JsonProperty("period_5y") 
   private Period5y period5Yr;

   @JsonProperty("period_6m") 
   private Period6m period6Mo;

   @JsonProperty("period_9m") 
   private Period9m period9Mo;
}
