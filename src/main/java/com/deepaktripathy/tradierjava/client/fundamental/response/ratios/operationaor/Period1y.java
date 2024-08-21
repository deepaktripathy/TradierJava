package com.deepaktripathy.tradierjava.client.fundamental.response.ratios.operationaor; 
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Period1y extends UnrecognizedFieldsCollector {
   
   @JsonProperty("as_of_date")
   private String asOfDate;

   @JsonProperty("assets_turnover")
   private Double assetsTurnover;

   @JsonProperty("cap_ex_sales_ratio")
   private Double capExSalesRatio;

   @JsonProperty("capital_expenditure_annual5_yr_growth") 
   private Double capitalExpenditureAnnual5YrGrowth;

   @JsonProperty("capital_expenditureto_e_b_i_t_d_a")
   private Double capitalExpenditureToEBITDA;

   @JsonProperty("cash_conversion_cycle")
   private Double cashConversionCycle;

   @JsonProperty("cash_flowfrom_investing_growth") 
   private Double cashFlowfromInvestingGrowth;

   @JsonProperty("cash_ratio")
   private Double cashRatio;

   @JsonProperty("cash_ratio_growth") 
   private Double cashRatioGrowth;

   @JsonProperty("cashto_total_assets")
   private Double cashToTotalAssets;

   @JsonProperty("c_f_o_growth3_month_avg") 
   private Double cfoGrowth3MonthAvg;

   @JsonProperty("common_equity_to_assets")
   private Double commonEquityToAssets;

   @JsonProperty("company_id")
   private String companyId;

   @JsonProperty("current_ratio")
   private Double currentRatio;

   @JsonProperty("current_ratio_growth") 
   private Double currentRatioGrowth;

   @JsonProperty("days_in_inventory")
   private Double daysInInventory;

   @JsonProperty("days_in_payment")
   private Double daysInPayment;

   @JsonProperty("days_in_sales")
   private Double daysInSales;

   @JsonProperty("debtto_assets")
   private Double debtToAssets;

   @JsonProperty("e_b_i_t_d_a_growth") 
   private Double ebitdaGrowth;

   @JsonProperty("e_b_i_t_d_a_margin")
   private Double ebitdaMargin;

   @JsonProperty("e_b_i_t_margin")
   private Double ebitMargin;

   @JsonProperty("f_c_f_growth3_month_avg") 
   private Double fcfGrowth3MonthAvg;

   @JsonProperty("f_c_f_net_income_ratio")
   private Double fCFNetIncomeRatio;

   @JsonProperty("f_c_f_sales_ratio")
   private Double fCFSalesRatio;

   @JsonProperty("f_c_fto_c_f_o")
   private Double fCFToCFO;

   @JsonProperty("financial_leverage")
   private Double financialLeverage;

   @JsonProperty("fiscal_year_end")
   private String fiscalYearEnd;

   @JsonProperty("fix_assets_turonver")
   private Double fixedAssetsTurnover;

   @JsonProperty("gross_margin")
   private Double grossMargin;

   @JsonProperty("gross_profit_annual5_yr_growth") 
   private Double grossProfitAnnual5YrGrowth;

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

   //////////////////////////////////////////
   
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

   @JsonProperty("stockholders_equity_growth")
   private Double stockholdersEquityGrowth;

   @JsonProperty("tax_rate")
   private Double taxRate;

   @JsonProperty("total_assets_growth") 
   private Double totalAssetsGrowth;

   @JsonProperty("total_debt_equity_ratio")
   private Double totalDebtEquityRatio;
   
   @JsonProperty("total_debt_equity_ratio_growth")
   private Double totalDebtEquityRatioGrowth;
   
   @JsonProperty("total_liabilities_growth")
   private Double totalLiabilitiesGrowth;
   
   @JsonProperty("working_capital_turnover_ratio")
   private Double workingCapitalTurnoverRatio;
   
}
