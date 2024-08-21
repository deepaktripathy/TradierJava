package com.deepaktripathy.tradierjava.client.fundamental.response.ratios.operationaor;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Period9m extends UnrecognizedFieldsCollector {
   
   @JsonProperty("as_of_date") 
   private String asOfDate;

   @JsonProperty("company_id") 
   private String companyId;

   @JsonProperty("e_b_i_t_d_a_margin") 
   private Double ebitdaMargin;

   @JsonProperty("e_b_i_t_margin") 
   private Double ebitMargin;

   @JsonProperty("fiscal_year_end") 
   private String fiscalYearEnd;

   @JsonProperty("gross_margin") 
   private Double grossMargin;

   @JsonProperty("interest_coverage") 
   private Double interestCoverage;

   @JsonProperty("net_incomes_per_employee") 
   private Double netIncomesPerEmployee;

   @JsonProperty("net_margin") 
   private Double netMargin;

   @JsonProperty("normalized_net_profit_margin") 
   private Double normalizedNetProfitMargin;

   @JsonProperty("operation_margin") 
   private Double operationMargin;

   @JsonProperty("period") 
   private String period;

   @JsonProperty("pretax_margin") 
   private Double pretaxMargin;

   @JsonProperty("report_type") 
   private String reportType;

   @JsonProperty("sales_per_employee") 
   private Double salesPerEmployee;

   @JsonProperty("tax_rate") 
   private Double taxRate;
}
