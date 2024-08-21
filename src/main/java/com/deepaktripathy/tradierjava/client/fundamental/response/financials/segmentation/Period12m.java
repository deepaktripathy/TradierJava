package com.deepaktripathy.tradierjava.client.fundamental.response.financials.segmentation;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Period12m extends UnrecognizedFieldsCollector {

   @JsonProperty("as_of_date") 
   private String asOfDate;

   @JsonProperty("company_id") 
   private String companyId;

   @JsonProperty("operating_income") 
   private Double operatingIncome;

   @JsonProperty("operating_revenue") 
   private Double operatingRevenue;

   @JsonProperty("period") 
   private String period;

   @JsonProperty("total_assets") 
   private Double totalAssets;

   @JsonProperty("total_non_current_assets") 
   private Double totalNonCurrentAssets;
}
