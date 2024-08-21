package com.deepaktripathy.tradierjava.client.fundamental.response.ratios;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ValuationRatios extends UnrecognizedFieldsCollector {

   @JsonProperty("as_of_date")
   private String asOfDate;

   @JsonProperty("book_value_per_share")
   private Double bookValuePerShare;

   @JsonProperty("book_value_yield")
   private Double bookValueYield;

   @JsonProperty("buy_back_yield")
   private Double buyBackYield;

   @JsonProperty("c_a_p_e_ratio")
   private Double capeRatio;

   @JsonProperty("cash_return")
   private Double cashReturn;

   @JsonProperty("c_f_o_per_share")
   private Double cfOPerShare;

   @JsonProperty("c_f_yield")
   private Double cfYield;

   @JsonProperty("dividend_rate")
   private Double dividendRate;

   @JsonProperty("dividend_yield")
   private Double dividendYield;

   @JsonProperty("div_yield5_year")
   private Double divYield5Year;

   @JsonProperty("earning_yield")
   private Double earningYield;

   @JsonProperty("e_vto_e_b_i_t")
   private Double evToEbit;

   @JsonProperty("e_v_to_e_b_i_t_d_a")
   private Double evToEbitDa;

   @JsonProperty("e_vto_f_c_f")
   private Double evToFcf;

   @JsonProperty("e_v_to_forward_e_b_i_t")
   private Double evToForwardEbit;

   @JsonProperty("e_v_to_forward_e_b_i_t_d_a")
   private Double evToForwardEbitDa;

   @JsonProperty("e_v_to_forward_revenue")
   private Double evToForwardRevenue;

   @JsonProperty("e_vto_pre_tax_income")
   private Double evToPreTaxIncome;

   @JsonProperty("e_vto_revenue")
   private Double evToRevenue;

   @JsonProperty("e_vto_total_assets")
   private Double evToTotalAssets;

   @JsonProperty("expected_dividend_growth_rate")
   private Double expectedDividendGrowthRate;

   @JsonProperty("f_c_f_per_share")
   private Double fcfPerShare;

   @JsonProperty("f_c_f_ratio")
   private Double fcfRatio;

   @JsonProperty("f_c_f_yield")
   private Double fcfYield;

   @JsonProperty("1st_year_estimated_e_p_s_growth")
   private Double firstYearEstimatedEpsGrowth;

   @JsonProperty("forward_calculation_style")
   private String forwardCalculationStyle;

   @JsonProperty("forward_dividend_yield")
   private Double forwardDividendYield;

   @JsonProperty("forward_earning_yield")
   private Double forwardEarningYield;

   @JsonProperty("forward_p_e_ratio")
   private Double forwardPeRatio;

   @JsonProperty("forward_r_o_a")
   private Double forwardRoa;

   @JsonProperty("forward_r_o_e")
   private Double forwardRoe;

   @JsonProperty("normalized_p_e_gatio")
   private Double normalizedPegatio;

   @JsonProperty("normalized_p_e_ratio")
   private Double normalizedPeRatio;

   @JsonProperty("payout_ratio")
   private Double payoutRatio;

   @JsonProperty("p_b_ratio")
   private Double pbRatio;

   @JsonProperty("p_b_ratio10_year_growth")
   private Double pbRatio10YearGrowth;

   @JsonProperty("p_b_ratio1_year_growth")
   private Double pbRatio1YearGrowth;

   @JsonProperty("p_b_ratio3_year_growth")
   private Double pbRatio3YearGrowth;

   @JsonProperty("p_b_ratio3_yr_avg")
   private Double pbRatio3YrAvg;

   @JsonProperty("p_b_ratio3_yr_avg_change")
   private Double pbRatio3YrAvgChange;

   @JsonProperty("p_b_ratio5_year_growth")
   private Double pbRatio5YearGrowth;

   @JsonProperty("p_cash_ratio3_yr_avg")
   private Double pcashRatio3YrAvg;

   @JsonProperty("p_c_f_ratio")
   private Double pcfRatio;

   @JsonProperty("p_e_g_payback")
   private Double pegPayback;

   @JsonProperty("p_e_g_ratio")
   private Double pegRatio;

   @JsonProperty("p_e_ratio")
   private Double peRatio;

   @JsonProperty("p_e_ratio10_year_average")
   private Double peRatio10YearAverage;

   @JsonProperty("p_e_ratio10_year_growth")
   private Double peRatio10YearGrowth;

   @JsonProperty("p_e_ratio10_year_high")
   private Double peRatio10YearHigh;

   @JsonProperty("p_e_ratio10_year_low")
   private Double peRatio10YearLow;

   @JsonProperty("p_e_ratio1_year_average")
   private Double peRatio1YearAverage;

   @JsonProperty("p_e_ratio1_year_growth")
   private Double peRatio1YearGrowth;

   @JsonProperty("p_e_ratio1_year_high")
   private Double peRatio1YearHigh;

   @JsonProperty("p_e_ratio1_year_low")
   private Double peRatio1YearLow;

   @JsonProperty("p_e_ratio3_year_growth")
   private Double peRatio3YearGrowth;

   @JsonProperty("p_e_ratio3_yr_avg")
   private Double peRatio3YrAvg;

   @JsonProperty("p_e_ratio3_yr_avg_change")
   private Double peRatio3YrAvgChange;

   @JsonProperty("p_e_ratio5_year_average")
   private Double peRatio5YearAverage;

   @JsonProperty("p_e_ratio5_year_growth")
   private Double peRatio5YearGrowth;

   @JsonProperty("p_e_ratio5_year_high")
   private Double peRatio5YearHigh;

   @JsonProperty("p_e_ratio5_year_low")
   private Double peRatio5YearLow;

   @JsonProperty("p_f_c_f_ratio10_year_growth")
   private Double pfCfRatio10YearGrowth;

   @JsonProperty("p_f_c_f_ratio1_year_growth")
   private Double pfCfRatio1YearGrowth;

   @JsonProperty("p_f_c_f_ratio3_year_growth")
   private Double pfCfRatio3YearGrowth;

   @JsonProperty("p_f_c_f_ratio3_yr_avg")
   private Double pfCfRatio3YrAvg;

   @JsonProperty("p_f_c_f_ratio3_yr_avg_change")
   private Double pfCfRatio3YrAvgChange;

   @JsonProperty("p_f_c_f_ratio5_year_growth")
   private Double pfCfRatio5YearGrowth;

   @JsonProperty("price_change1_m")
   private Double priceChange1M;

   @JsonProperty("priceto_cash_ratio")
   private Double priceToCashRatio;

   @JsonProperty("priceto_e_b_i_t_d_a")
   private Double priceToEbitda;

   @JsonProperty("p_s_ratio")
   private Double psRatio;

   @JsonProperty("p_s_ratio10_year_growth")
   private Double psRatio10YearGrowth;

   @JsonProperty("p_s_ratio1_year_growth")
   private Double psRatio1YearGrowth;

   @JsonProperty("p_s_ratio3_year_growth")
   private Double psRatio3YearGrowth;

   @JsonProperty("p_s_ratio3_yr_avg")
   private Double psRatio3YrAvg;

   @JsonProperty("p_s_ratio3_yr_avg_change")
   private Double psRatio3YrAvgChange;

   @JsonProperty("p_s_ratio5_year_growth")
   private Double psRatio5YearGrowth;

   @JsonProperty("ratio_p_e5_year_average")
   private Double ratioPe5YearAverage;

   @JsonProperty("sales_per_share")
   private Double salesPerShare;

   @JsonProperty("sales_yield")
   private Double salesYield;

   @JsonProperty("2nd_year_estimated_e_p_s_growth")
   private Double secondYearEstimatedEpsGrowth;

   @JsonProperty("share_class_id")
   private String shareClassId;

   @JsonProperty("sustainable_growth_rate")
   private Double sustainableGrowthRate;

   @JsonProperty("tangible_book_value_per_share")
   private Double tangibleBookValuePerShare;

   @JsonProperty("tangible_b_v_per_share3_yr_avg")
   private Double tangibleBvPerShare3YrAvg;

   @JsonProperty("tangible_b_v_per_share5_yr_avg")
   private Double tangibleBvPerShare5YrAvg;

   @JsonProperty("total_asset_per_share")
   private Double totalAssetPerShare;

   @JsonProperty("total_yield")
   private Double totalYield;

   @JsonProperty("2_years_forward_earning_yield")
   private Double twoYearsForwardEarningYield;

   @JsonProperty("2_years_forward_p_e_ratio")
   private Double twoYearsForwardPeRatio;

   @JsonProperty("2_yrs_e_v_to_forward_e_b_i_t")
   private Double twoYrsEvToForwardEbit;

   @JsonProperty("2_yrs_e_v_to_forward_e_b_i_t_d_a")
   private Double twoYrsEvToForwardEbitDa;

   @JsonProperty("working_capital_per_share")
   private Double workingCapitalPerShare;

   @JsonProperty("working_capital_per_share3_yr_avg")
   private Double workingCapitalPerShare3YrAvg;

   @JsonProperty("working_capital_per_share5_yr_avg")
   private Double workingCapitalPerShare5YrAvg;
}