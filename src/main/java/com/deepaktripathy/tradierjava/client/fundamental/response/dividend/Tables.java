package com.deepaktripathy.tradierjava.client.fundamental.response.dividend;

import java.util.List;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tables extends UnrecognizedFieldsCollector {
   @JsonProperty("cash_dividends") 
   private List<CashDividend> cashDividends;
   
   @Override
   public String toString() {
      return "Tables [cashDividends=" + cashDividends + "]";
   }

}