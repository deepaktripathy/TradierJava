package com.deepaktripathy.tradierjava.client.fundamental.response.ratios; 
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty; 

public class Period3m extends UnrecognizedFieldsCollector {

   @JsonProperty("interest_coverage")
   private Double interestCoverage;

   @JsonProperty("net_income_cont_ops_growth")
   private Double netIncomeContOpsGrowth;

   @JsonProperty("net_income_growth")
   private Double netIncomeGrowth;

   @JsonProperty("net_incomes_per_employee")
   private Double netIncomesPerEmployee;

   @JsonProperty("operation_income_growth")
   private Double operationIncomeGrowth;

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

   @JsonProperty("assets_turnover")
   private Double assetsTurnover;

   @JsonProperty("cash_conversion_cycle")
   private Double cashConversionCycle;

   @JsonProperty("cash_ratio")
   private Double cashRatio;

   @JsonProperty("cashto_total_assets")
   private Double cashToTotalAssets;

   @JsonProperty("common_equity_to_assets")
   private Double commonEquityToAssets;

   @JsonProperty("current_ratio")
   private Double currentRatio;

   @JsonProperty("days_in_inventory")
   private Double daysInInventory;

   @JsonProperty("days_in_payment")
   private Double daysInPayment;

   @JsonProperty("days_in_sales")
   private Double daysInSales;

   @JsonProperty("debtto_assets")
   private Double debtToAssets;

   @JsonProperty("e_b_i_t_d_a_margin")
   private Double ebitdaMargin;

   @JsonProperty("e_b_i_t_margin")
   private Double ebitMargin;

   @JsonProperty("financial_leverage")
   private Double financialLeverage;

   @JsonProperty("fix_assets_turonver")
   private Double fixedAssetsTurnover;

   @JsonProperty("gross_margin")
   private Double grossMargin;

   @JsonProperty("inventory_turnover")
   private Double inventoryTurnover;

   @JsonProperty("long_term_debt_equity_ratio")
   private Double longTermDebtEquityRatio;

   @JsonProperty("long_term_debt_total_capital_ratio")
   private Double longTermDebtTotalCapitalRatio;

   @JsonProperty("net_margin")
   private Double netMargin;

   @JsonProperty("normalized_net_profit_margin")
   private Double normalizedNetProfitMargin;

   @JsonProperty("normalized_r_o_i_c")
   private Double normalizedROIC;

   @JsonProperty("operation_margin")
   private Double operationMargin;

   @JsonProperty("operation_revenue_growth3_month_avg")
   private Double operationRevenueGrowth3MonthAvg;

   @JsonProperty("payment_turnover")
   private Double paymentTurnover;

   @JsonProperty("pretax_margin")
   private Double pretaxMargin;

   @JsonProperty("quick_ratio")
   private Double quickRatio;

   @JsonProperty("receivable_turnover")
   private Double receivableTurnover;

   @JsonProperty("revenue_growth")
   private Double revenueGrowth;

   @JsonProperty("r_o_a")
   private Double roa;

   @JsonProperty("r_o_e")
   private Double roe;

   @JsonProperty("r_o_i_c")
   private Double roic;

   @JsonProperty("sales_per_employee")
   private Double salesPerEmployee;

   @JsonProperty("total_debt_equity_ratio")
   private Double totalDebtEquityRatio;

   @JsonProperty("working_capital_turnover_ratio")
   private Double workingCapitalTurnoverRatio;

   @JsonProperty("book_value_per_share_growth")
   private Double bookValuePerShareGrowth;
   @JsonProperty("equity_per_share_growth")
   private Double equityPerShareGrowth;
   
   @Override
   public String toString() {
      return "Period3m [interestCoverage=" + interestCoverage + ", netIncomeContOpsGrowth=" + netIncomeContOpsGrowth
            + ", netIncomeGrowth=" + netIncomeGrowth + ", netIncomesPerEmployee=" + netIncomesPerEmployee
            + ", operationIncomeGrowth=" + operationIncomeGrowth + ", taxRate=" + taxRate + ", shareClassId="
            + shareClassId + ", dilutedContEPSGrowth=" + dilutedContEPSGrowth + ", dilutedEPSGrowth=" + dilutedEPSGrowth
            + ", dpsGrowth=" + dpsGrowth + ", normalizedBasicEPSGrowth=" + normalizedBasicEPSGrowth
            + ", normalizedDilutedEPSGrowth=" + normalizedDilutedEPSGrowth + ", companyId=" + companyId + ", asOfDate="
            + asOfDate + ", fiscalYearEnd=" + fiscalYearEnd + ", period=" + period + ", reportType=" + reportType
            + ", assetsTurnover=" + assetsTurnover + ", cashConversionCycle=" + cashConversionCycle + ", cashRatio="
            + cashRatio + ", cashToTotalAssets=" + cashToTotalAssets + ", commonEquityToAssets=" + commonEquityToAssets
            + ", currentRatio=" + currentRatio + ", daysInInventory=" + daysInInventory + ", daysInPayment="
            + daysInPayment + ", daysInSales=" + daysInSales + ", debtToAssets=" + debtToAssets + ", ebitdaMargin="
            + ebitdaMargin + ", ebitMargin=" + ebitMargin + ", financialLeverage=" + financialLeverage
            + ", fixedAssetsTurnover=" + fixedAssetsTurnover + ", grossMargin=" + grossMargin + ", inventoryTurnover="
            + inventoryTurnover + ", longTermDebtEquityRatio=" + longTermDebtEquityRatio
            + ", longTermDebtTotalCapitalRatio=" + longTermDebtTotalCapitalRatio + ", netMargin=" + netMargin
            + ", normalizedNetProfitMargin=" + normalizedNetProfitMargin + ", normalizedROIC=" + normalizedROIC
            + ", operationMargin=" + operationMargin + ", operationRevenueGrowth3MonthAvg="
            + operationRevenueGrowth3MonthAvg + ", paymentTurnover=" + paymentTurnover + ", pretaxMargin="
            + pretaxMargin + ", quickRatio=" + quickRatio + ", receivableTurnover=" + receivableTurnover
            + ", revenueGrowth=" + revenueGrowth + ", roa=" + roa + ", roe=" + roe + ", roic=" + roic
            + ", salesPerEmployee=" + salesPerEmployee + ", totalDebtEquityRatio=" + totalDebtEquityRatio
            + ", workingCapitalTurnoverRatio=" + workingCapitalTurnoverRatio + "]";
   }
}
