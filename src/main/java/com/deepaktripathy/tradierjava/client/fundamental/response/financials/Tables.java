package com.deepaktripathy.tradierjava.client.fundamental.response.financials;

import java.util.List;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tables extends UnrecognizedFieldsCollector {
   @JsonProperty("segmentation") 
   private Segmentation segmentation;

   @JsonProperty("financial_statements_restate") 
   private FinancialStatementsRestate financialStatementsRestate;

   @JsonProperty("historical_returns") 
   private HistoricalReturns historicalReturns;

   @JsonProperty("earning_reports_restate") 
   private List<EarningReportsRestate> earningReportsRestate;

   @JsonProperty("earning_reports_a_o_r") 
   private List<EarningReportsAOR> earningReportsAOR;

   @Override
   public String toString() {
      return "Tables [segmentation=" + segmentation + ", financialStatementsRestate=" + financialStatementsRestate
            + ", historicalReturns=" + historicalReturns + ", earningReportsRestate=" + earningReportsRestate
            + ", earningReportsAOR=" + earningReportsAOR + "]";
   }
   
}