package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AssetClassification extends UnrecognizedFieldsCollector {

   @JsonProperty("company_id")
   private String companyId;

   @JsonProperty("c_a_n_n_a_i_c_s")
   private Integer cannaics;

   @JsonProperty("financial_health_grade")
   private String financialHealthGrade;

   @JsonProperty("FinancialHealthGrade.asOfDate")
   private String financialHealthGradeAsOfDate;

   @JsonProperty("growth_grade")
   private String growthGrade;

   @JsonProperty("GrowthGrade.asOfDate")
   private String growthGradeAsOfDate;

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

   @JsonProperty("n_a_c_e")
   private Double nace;

   @JsonProperty("n_a_i_c_s")
   private Integer naics;

   @JsonProperty("profitability_grade")
   private String profitabilityGrade;

   @JsonProperty("ProfitabilityGrade.asOfDate")
   private String profitabilityGradeAsOfDate;

   @JsonProperty("s_i_c")
   private Integer sic;

   @JsonProperty("size_score")
   private Double sizeScore;

   @JsonProperty("stock_type")
   private Integer stockType;

   @JsonProperty("StockType.asOfDate")
   private String stockTypeAsOfDate;

   @JsonProperty("style_box")
   private Integer styleBox;

   @JsonProperty("StyleBox.asOfDate")
   private String styleBoxAsOfDate;

   @JsonProperty("style_score")
   private Double styleScore;

   @JsonProperty("value_score")
   private Double valueScore;
}