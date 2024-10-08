package com.deepaktripathy.tradierjava.client.fundamental.response.financials;

import com.deepaktripathy.tradierjava.client.fundamental.response.financials.historical.Period1m;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.historical.Period1w;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.historical.Period1y;
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HistoricalReturns extends UnrecognizedFieldsCollector {

   @JsonProperty("period_1m") 
   private Period1m period1Mo;

   @JsonProperty("period_1w") 
   private Period1w period1Wk;
   
   @JsonProperty("period_1y") 
   private Period1y period1Yr;
}