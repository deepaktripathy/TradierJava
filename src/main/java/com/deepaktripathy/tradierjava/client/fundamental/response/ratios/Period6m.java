package com.deepaktripathy.tradierjava.client.fundamental.response.ratios;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Period6m extends UnrecognizedFieldsCollector {
   @JsonProperty("company_id") 
   private String companyId;

   @JsonProperty("as_of_date") 
   private String asOfDate;

   @JsonProperty("fiscal_year_end") 
   private String fiscalYearEnd;

   @JsonProperty("period") 
   private String period;

   @JsonProperty("report_type") 
   private String reportType;

   @JsonProperty("e_b_i_t_d_a_margin") 
   private Double ebitdaMargin;

   @JsonProperty("e_b_i_t_margin") 
   private Double ebitMargin;

   @JsonProperty("gross_margin") 
   private Double grossMargin;

   @JsonProperty("interest_coverage") 
   private Double interestCoverage;

   @JsonProperty("net_income_cont_ops_growth") 
   private Double netIncomeContOpsGrowth;

   @JsonProperty("net_income_growth") 
   private Double netIncomeGrowth;

   @JsonProperty("net_incomes_per_employee") 
   private Double netIncomesPerEmployee;

   @JsonProperty("net_margin") 
   private Double netMargin;

   @JsonProperty("normalized_net_profit_margin") 
   private Double normalizedNetProfitMargin;

   @JsonProperty("operation_income_growth") 
   private Double operationIncomeGrowth;

   @JsonProperty("operation_margin") 
   private Double operationMargin;

   @JsonProperty("operation_revenue_growth3_month_avg") 
   private Double operationRevenueGrowth3MonthAvg;

   @JsonProperty("pretax_margin") 
   private Double pretaxMargin;

   @JsonProperty("revenue_growth") 
   private Double revenueGrowth;

   @JsonProperty("sales_per_employee") 
   private Double salesPerEmployee;

   @JsonProperty("tax_rate") 
   private Double taxRate;

   @JsonProperty("share_class_id") 
   private String shareClassId;

   @JsonProperty("diluted_cont_e_p_s_growth") 
   private Double dilutedContEPSGrowth;

   @JsonProperty("diluted_e_p_s_growth") 
   private Double dilutedEPSGrowth;

   @JsonProperty("d_p_s_growth") 
   private Double dpsGrowth;

   @JsonProperty("normalized_basic_e_p_s_growth") 
   private Double normalizedBasicEPSGrowth;

   @JsonProperty("normalized_diluted_e_p_s_growth") 
   private Double normalizedDilutedEPSGrowth;

   @JsonProperty("assets_turnover")
   private Double assetsTurnover;

   @JsonProperty("cash_conversion_cycle")
   private Double cashConversionCycle;

   @JsonProperty("days_in_inventory")
   private Double daysInInventory;

   @JsonProperty("days_in_payment")
   private Double daysInPayment;

   @JsonProperty("days_in_sales")
   private Double daysInSales;

   @JsonProperty("fix_assets_turonver")
   private Double fixAssetsTuronver;

   @JsonProperty("inventory_turnover")
   private Double inventoryTurnover;

   @JsonProperty("normalized_r_o_i_c")
   private Double normalizedROIC;

   @JsonProperty("receivable_turnover")
   private Double receivableTurnover;

   @JsonProperty("r_o_a")
   private Double rOA;

   @JsonProperty("r_o_e")
   private Double rOE;

   @JsonProperty("r_o_i_c")
   private Double rOIC;

   @JsonProperty("working_capital_turnover_ratio")
   private Double workingCapitalTurnoverRatio;

   @JsonProperty("payment_turnover")
   private Double paymentTurnover;
   
   @Override
   public String toString() {
      return "Period6m [companyId=" + companyId + ", asOfDate=" + asOfDate + ", fiscalYearEnd=" + fiscalYearEnd
            + ", period=" + period + ", reportType=" + reportType + ", ebitdaMargin=" + ebitdaMargin + ", ebitMargin="
            + ebitMargin + ", grossMargin=" + grossMargin + ", interestCoverage=" + interestCoverage
            + ", netIncomeContOpsGrowth=" + netIncomeContOpsGrowth + ", netIncomeGrowth=" + netIncomeGrowth
            + ", netIncomesPerEmployee=" + netIncomesPerEmployee + ", netMargin=" + netMargin
            + ", normalizedNetProfitMargin=" + normalizedNetProfitMargin + ", operationIncomeGrowth="
            + operationIncomeGrowth + ", operationMargin=" + operationMargin + ", operationRevenueGrowth3MonthAvg="
            + operationRevenueGrowth3MonthAvg + ", pretaxMargin=" + pretaxMargin + ", revenueGrowth=" + revenueGrowth
            + ", salesPerEmployee=" + salesPerEmployee + ", taxRate=" + taxRate + ", shareClassId=" + shareClassId
            + ", dilutedContEPSGrowth=" + dilutedContEPSGrowth + ", dilutedEPSGrowth=" + dilutedEPSGrowth
            + ", dpsGrowth=" + dpsGrowth + ", normalizedBasicEPSGrowth=" + normalizedBasicEPSGrowth
            + ", normalizedDilutedEPSGrowth=" + normalizedDilutedEPSGrowth + ", assetsTurnover=" + assetsTurnover
            + ", cashConversionCycle=" + cashConversionCycle + ", daysInInventory=" + daysInInventory
            + ", daysInPayment=" + daysInPayment + ", daysInSales=" + daysInSales + ", fixAssetsTuronver="
            + fixAssetsTuronver + ", inventoryTurnover=" + inventoryTurnover + ", normalizedROIC=" + normalizedROIC
            + ", receivableTurnover=" + receivableTurnover + ", rOA=" + rOA + ", rOE=" + rOE + ", rOIC=" + rOIC
            + ", workingCapitalTurnoverRatio=" + workingCapitalTurnoverRatio + "]";
   }

}
