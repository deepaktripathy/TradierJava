package com.deepaktripathy.tradierjava.client.fundamental.response.ratios; 

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty; 

public class EarningRatiosRestate extends UnrecognizedFieldsCollector {

   @JsonProperty("period_3m") 
   private Period3m period3Mo;

   @JsonProperty("period_6m") 
   private Period6m period6Mo;

   @JsonProperty("period_9m") 
   private Period9m period9Mo;

   @JsonProperty("period_1y") 
   private Period1y period1Yr;

   @JsonProperty("period_3y") 
   private Period3y period3Yr;

   @JsonProperty("period_5y") 
   private Period5y period5Yr;

   @JsonProperty("period_10y") 
   private Period10y period10Yr;

   @Override
   public String toString() {
      return "EarningRatiosRestate [period3Mo=" + period3Mo + ", period9Mo=" + period9Mo + ", period1Yr=" + period1Yr
            + ", period3Yr=" + period3Yr + ", period5Yr=" + period5Yr + ", period10Yr=" + period10Yr + "]";
   }
}
