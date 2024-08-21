package com.deepaktripathy.tradierjava.client.fundamental.response.financials.earningreports;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Period3m extends UnrecognizedFieldsCollector {

   @JsonProperty("accession_number")
   private String accessionNumber;

   @JsonProperty("as_of_date") 
   private String asOfDate;

   @JsonProperty("basic_average_shares") 
   private Double basicAverageShares;

   @JsonProperty("basic_continuous_operations") 
   private Double basicContinuousOperations;

   @JsonProperty("basic_discontinuous_operations")
   private Double basicDiscontinuousOperations;

   @JsonProperty("basic_e_p_s") 
   private Double basicEPS;

   @JsonProperty("continuing_and_discontinued_basic_e_p_s") 
   private Double continuingAndDiscontinuedBasicEPS;

   @JsonProperty("continuing_and_discontinued_diluted_e_p_s") 
   private Double continuingAndDiscontinuedDilutedEPS;

   @JsonProperty("currency_id") 
   private String currencyID;

   @JsonProperty("diluted_average_shares") 
   private Double diluted_average_shares;

   @JsonProperty("diluted_continuous_operations") 
   private Double dilutedContinuousOperations;

   @JsonProperty("diluted_discontinuous_operations")
   private Double dilutedDiscontinuousOperations;

   @JsonProperty("diluted_e_p_s") 
   private Double dilutedEPS;

   @JsonProperty("dividend_coverage_ratio") 
   private Double dividendCoverageRatio;

   @JsonProperty("dividend_per_share") 
   private Double dividendPerShare;

   @JsonProperty("file_date")
   private String fileDate;

   @JsonProperty("fiscal_year_end")
   private Double fiscalYearEnd;

   @JsonProperty("fiscal_year_end_change")
   private Boolean fiscalYearEndChange;

   @JsonProperty("form_type")
   private String formType;

   @JsonProperty("normalized_basic_e_p_s") 
   private Double normalizedBasicEPS;

   @JsonProperty("normalized_diluted_e_p_s") 
   private Double normalizedDilutedEPS;

   @JsonProperty("period") 
   private String period;

   @JsonProperty("period_ending_date")
   private String periodEndingDate;

   @JsonProperty("reported_normalized_basic_e_p_s")
   private Double reportedNormalizedBasicEPS;

   @JsonProperty("reported_normalized_diluted_e_p_s") 
   private Double reportedNormalizedDilutedEPS;

   @JsonProperty("report_type")
   private String reportType;

   @JsonProperty("share_class_id") 
   private String shareClassID;

   @JsonProperty("total_dividend_per_share") 
   private Double totalDividendPerShare;
}