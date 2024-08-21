package com.deepaktripathy.tradierjava.client.fundamental.response.financials;

import com.deepaktripathy.tradierjava.client.fundamental.response.financials.cashflow.Period12m;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.cashflow.Period3m;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.cashflow.Period6m;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.cashflow.Period9m;
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CashFlowStatement extends UnrecognizedFieldsCollector {

   @JsonProperty("period_3m") 
   private Period3m period3Mo;

   @JsonProperty("period_6m") 
   private Period6m period6Mo;

   @JsonProperty("period_9m") 
   private Period9m period9Mo;
   
   @JsonProperty("period_12m") 
   private Period12m period12Mo;
}