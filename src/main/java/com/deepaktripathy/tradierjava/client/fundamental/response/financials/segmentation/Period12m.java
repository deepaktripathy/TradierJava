package com.deepaktripathy.tradierjava.client.fundamental.response.financials.segmentation;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Period12m extends UnrecognizedFieldsCollector {

   @JsonProperty("company_id") 
   private String companyId;

   @JsonProperty("as_of_date") 
   private String asOfDate;

   @JsonProperty("period") 
   private String period;

   @JsonProperty("operating_income") 
   private Double operatingIncome;

   @JsonProperty("operating_revenue") 
   private Double operatingRevenue;

   @JsonProperty("total_assets") 
   private Double totalAssets;

   @JsonProperty("total_non_current_assets") 
   private Double totalNonCurrentAssets;

   @Override
   public String toString() {
      return "Period12m [companyId=" + companyId + ", asOfDate=" + asOfDate + ", period=" + period
            + ", operatingIncome=" + operatingIncome + ", operatingRevenue=" + operatingRevenue + ", totalAssets="
            + totalAssets + ", totalNonCurrentAssets=" + totalNonCurrentAssets + "]";
   }
}
