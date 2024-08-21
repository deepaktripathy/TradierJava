package com.deepaktripathy.tradierjava.client.fundamental.response.ratios.earningrestate;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;






public class Period9m extends UnrecognizedFieldsCollector {
   @JsonProperty("as_of_date") 
   private String asOfDate;

   @JsonProperty("diluted_cont_e_p_s_growth") 
   private Double dilutedContEPSGrowth;

   @JsonProperty("diluted_e_p_s_growth") 
   private Double dilutedEPSGrowth;

   @JsonProperty("d_p_s_growth") 
   private Double dpsGrowth;

   @JsonProperty("fiscal_year_end") 
   private String fiscalYearEnd;

   @JsonProperty("normalized_basic_e_p_s_growth") 
   private Double normalizedBasicEPSGrowth;

   @JsonProperty("normalized_diluted_e_p_s_growth") 
   private Double normalizedDilutedEPSGrowth;

   @JsonProperty("period") 
   private String period;

   @JsonProperty("report_type") 
   private String reportType;

   @JsonProperty("share_class_id") 
   private String shareClassId;
}