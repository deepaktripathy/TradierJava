package com.deepaktripathy.tradierjava.client.fundamental.response.ratios.operationaor;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Period3m extends UnrecognizedFieldsCollector {
   
   @JsonProperty("as_of_date")
   private String asOfDate;

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

   @JsonProperty("company_id")
   private String companyId;

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

   @JsonProperty("fiscal_year_end")
   private String fiscalYearEnd;

   @JsonProperty("fix_assets_turonver")
   private Double fixedAssetsTurnover;

   @JsonProperty("gross_margin")
   private Double grossMargin;

   @JsonProperty("interest_coverage")
   private Double interestCoverage;

   @JsonProperty("inventory_turnover")
   private Double inventoryTurnover;

   @JsonProperty("long_term_debt_equity_ratio")
   private Double longTermDebtEquityRatio;

   @JsonProperty("long_term_debt_total_capital_ratio")
   private Double longTermDebtTotalCapitalRatio;

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

   @JsonProperty("normalized_r_o_i_c")
   private Double normalizedROIC;

   @JsonProperty("operation_income_growth")
   private Double operationIncomeGrowth;

   @JsonProperty("operation_margin")
   private Double operationMargin;

   @JsonProperty("operation_revenue_growth3_month_avg")
   private Double operationRevenueGrowth3MonthAvg;

   @JsonProperty("payment_turnover")
   private Double paymentTurnover;

   @JsonProperty("period")
   private String period;

   @JsonProperty("pretax_margin")
   private Double pretaxMargin;

   @JsonProperty("quick_ratio")
   private Double quickRatio;

   @JsonProperty("receivable_turnover")
   private Double receivableTurnover;

   @JsonProperty("report_type")
   private String reportType;

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

   @JsonProperty("tax_rate")
   private Double taxRate;

   @JsonProperty("total_debt_equity_ratio")
   private Double totalDebtEquityRatio;
   
   @JsonProperty("working_capital_turnover_ratio")
   private Double workingCapitalTurnoverRatio;
}
