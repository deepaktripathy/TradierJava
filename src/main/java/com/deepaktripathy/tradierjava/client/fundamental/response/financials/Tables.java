package com.deepaktripathy.tradierjava.client.fundamental.response.financials;

import java.util.List;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Tables extends UnrecognizedFieldsCollector {

   @JsonProperty("earning_reports_a_o_r") 
   private List<EarningReportsAOR> earningReportsAOR;

   @JsonProperty("earning_reports_restate") 
   private List<EarningReportsRestate> earningReportsRestate;

   @JsonProperty("financial_statements_restate") 
   private FinancialStatementsRestate financialStatementsRestate;

   @JsonProperty("historical_returns") 
   private HistoricalReturns historicalReturns;

   @JsonProperty("segmentation") 
   private Segmentation segmentation;
}