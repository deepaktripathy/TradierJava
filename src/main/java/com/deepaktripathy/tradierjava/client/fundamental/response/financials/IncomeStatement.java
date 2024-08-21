package com.deepaktripathy.tradierjava.client.fundamental.response.financials;

import com.deepaktripathy.tradierjava.client.fundamental.response.financials.incomestatement.Period12m;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.incomestatement.Period3m;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.incomestatement.Period6m;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.incomestatement.Period9m;
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class IncomeStatement extends UnrecognizedFieldsCollector {

   @JsonProperty("period_12m") 
   private Period12m period12Mo;
   
   @JsonProperty("period_3m") 
   private Period3m period3Mo;

   @JsonProperty("period_6m") 
   private Period6m period6Mo;
   
   @JsonProperty("period_9m") 
   private Period9m period9Mo;
}