package com.deepaktripathy.tradierjava.client.fundamental.response.financials.segmentation;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Period6m extends UnrecognizedFieldsCollector {
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
}