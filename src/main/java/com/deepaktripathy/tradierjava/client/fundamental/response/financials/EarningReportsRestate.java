package com.deepaktripathy.tradierjava.client.fundamental.response.financials;

import com.deepaktripathy.tradierjava.client.fundamental.response.financials.earningreports.Period12m;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.earningreports.Period3m;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.earningreports.Period6m;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.earningreports.Period9m;
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EarningReportsRestate extends UnrecognizedFieldsCollector {
   @JsonProperty("period_3m") 
   private Period3m period3Mo;
   
   @JsonProperty("period_6m") 
   private Period6m period6Mo;

   @JsonProperty("period_9m") 
   private Period9m period9Mo;
   
   @JsonProperty("period_12m") 
   private Period12m period12Mo;

   @Override
   public String toString() {
      return "EarningReportsRestate [period3Mo=" + period3Mo + ", period6Mo=" + period6Mo + ", period9Mo=" + period9Mo
            + ", period12Mo=" + period12Mo + "]";
   }
}