package com.deepaktripathy.tradierjava.client.fundamental.response.ratios.earningrestate; 
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Period1y extends UnrecognizedFieldsCollector {
   @JsonProperty("as_of_date")
   private String asOfDate;

   @JsonProperty("book_value_per_share_growth")
   private Double bookValuePerShareGrowth;

   @JsonProperty("diluted_cont_e_p_s_growth") 
   private Double dilutedContEpsGrowth;

   @JsonProperty("diluted_e_p_s_growth") 
   private Double dilutedEpsGrowth;

   @JsonProperty("d_p_s_growth")
   private Double dpsGrowth;

   @JsonProperty("equity_per_share_growth")
   private Double equityPerShareGrowth;

   @JsonProperty("f_c_f_per_share_growth") 
   private Double fcfPerShareGrowth;

   @JsonProperty("fiscal_year_end")
   private String fiscalYearEnd;

   @JsonProperty("normalized_basic_e_p_s_growth") 
   private Double normalizedBasicEpsGrowth;
   
   @JsonProperty("normalized_diluted_e_p_s_growth") 
   private Double normalizedDilutedEpsGrowth;
   
   @JsonProperty("period")
   private String period;
   
   @JsonProperty("report_type")
   private String reportType;
   
   @JsonProperty("share_class_id")
   private String shareClassId;
}
