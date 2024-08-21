package com.deepaktripathy.tradierjava.client.fundamental.response.financials;

import com.deepaktripathy.tradierjava.client.fundamental.response.financials.balancesheet.Period3m;
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BalanceSheet extends UnrecognizedFieldsCollector {

   @JsonProperty("period_12m") 
   private Period3m period12Mo;  
   
   @JsonProperty("period_3m") 
   private Period3m period3Mo;
}