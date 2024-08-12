package com.deepaktripathy.tradierjava.client.fundamental.response.financials;

import com.deepaktripathy.tradierjava.client.fundamental.response.financials.balancesheet.Period3m;
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BalanceSheet extends UnrecognizedFieldsCollector {
   @JsonProperty("period_3m") 
   private Period3m period3Mo;  
   
   @JsonProperty("period_12m") 
   private Period3m period12Mo;

   @Override
   public String toString() {
      return "BalanceSheet [period3Mo=" + period3Mo + ", period12Mo=" + period12Mo + "]";
   }  
}