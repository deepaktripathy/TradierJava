package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoricalAssetClassification extends UnrecognizedFieldsCollector {
   @JsonProperty("company_id")
   private String companyId;

   @JsonProperty("as_of_date")
   private String asOfDate;

   @JsonProperty("financial_health_grade")
   private String financialHealthGrade;

   @JsonProperty("growth_grade")
   private String growthGrade;

   @JsonProperty("growth_score")
   private Double growthScore;

   @JsonProperty("morningstar_economy_sphere_code")
   private Integer morningstarEconomySphereCode;

   @JsonProperty("morningstar_industry_code")
   private Integer morningstarIndustryCode;

   @JsonProperty("morningstar_industry_group_code")
   private Integer morningstarIndustryGroupCode;

   @JsonProperty("morningstar_sector_code")
   private Integer morningstarSectorCode;

   @JsonProperty("profitability_grade")
   private String profitabilityGrade;

   @JsonProperty("size_score")
   private Double sizeScore;

   @JsonProperty("stock_type")
   private Integer stockType;

   @JsonProperty("style_box")
   private Integer styleBox;

   @JsonProperty("style_score")
   private Double styleScore;

   @JsonProperty("value_score")
   private Double valueScore;
}