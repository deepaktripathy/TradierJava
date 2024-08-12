package com.deepaktripathy.tradierjava.client.fundamental.response.ratios; 
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty; 

public class Period1y extends UnrecognizedFieldsCollector {

   @JsonProperty("as_of_date")
   private String asOfDate;

   @JsonProperty("assets_turnover")
   private Double assetsTurnover;

   @JsonProperty("book_value_per_share_growth")
   private Double bookValuePerShareGrowth;

   @JsonProperty("cap_ex_sales_ratio")
   private Double capExSalesRatio;

   @JsonProperty("capital_expenditureto_e_b_i_t_d_a")
   private Double capitalExpenditureToEBITDA;

   @JsonProperty("cash_conversion_cycle")
   private Double cashConversionCycle;

   @JsonProperty("company_id")
   private String companyId;

   @JsonProperty("days_in_inventory")
   private Double daysInInventory;

   @JsonProperty("days_in_payment")
   private Double daysInPayment;

   @JsonProperty("days_in_sales")
   private Double daysInSales;

   @JsonProperty("e_b_i_t_d_a_margin")
   private Double ebitdaMargin;

   @JsonProperty("e_b_i_t_margin")
   private Double ebitMargin;

   @JsonProperty("equity_per_share_growth")
   private Double equityPerShareGrowth;

   @JsonProperty("f_c_f_net_income_ratio")
   private Double fCFNetIncomeRatio;

   @JsonProperty("f_c_f_sales_ratio")
   private Double fCFSalesRatio;

   @JsonProperty("f_c_fto_c_f_o")
   private Double fCFToCFO;

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

   @JsonProperty("net_incomes_per_employee")
   private Double netIncomesPerEmployee;

   @JsonProperty("net_margin")
   private Double netMargin;

   @JsonProperty("normalized_net_profit_margin")
   private Double normalizedNetProfitMargin;

   @JsonProperty("normalized_r_o_i_c")
   private Double normalizedROIC;

   @JsonProperty("operation_margin")
   private Double operationMargin;

   @JsonProperty("payment_turnover")
   private Double paymentTurnover;

   @JsonProperty("period")
   private String period;

   @JsonProperty("pretax_margin")
   private Double pretaxMargin;

   @JsonProperty("receivable_turnover")
   private Double receivableTurnover;

   @JsonProperty("report_type")
   private String reportType;

   @JsonProperty("r_o_a")
   private Double roa;

   @JsonProperty("r_o_e")
   private Double roe;

   @JsonProperty("r_o_i_c")
   private Double roic;

   @JsonProperty("sales_per_employee")
   private Double salesPerEmployee;

   @JsonProperty("share_class_id")
   private String shareClassId;

   @JsonProperty("tax_rate")
   private Double taxRate;

   @JsonProperty("working_capital_turnover_ratio")
   private Double workingCapitalTurnoverRatio;
   
   @JsonProperty("c_f_o_growth3_month_avg") 
   private Double cfoGrowth3MonthAvg;
   
   @JsonProperty("capital_expenditure_annual5_yr_growth") 
   private Double capitalExpenditureAnnual5YrGrowth;
   
   @JsonProperty("cash_ratio_growth") 
   private Double cashRatioGrowth;
   
   @JsonProperty("current_ratio_growth") 
   private Double currentRatioGrowth;
   
   @JsonProperty("d_p_s_growth")
   private Double dpsGrowth;
   
   @JsonProperty("diluted_cont_e_p_s_growth") 
   private Double dilutedContEpsGrowth;
   
   @JsonProperty("diluted_e_p_s_growth") 
   private Double dilutedEpsGrowth;
   
   @JsonProperty("e_b_i_t_d_a_growth") 
   private Double ebitdaGrowth;
   
   @JsonProperty("f_c_f_growth3_month_avg") 
   private Double fcfGrowth3MonthAvg;
   
   @JsonProperty("f_c_f_per_share_growth") 
   private Double fcfPerShareGrowth;
   
   @JsonProperty("gross_profit_annual5_yr_growth") 
   private Double grossProfitAnnual5YrGrowth;
   
   @JsonProperty("net_income_cont_ops_growth") 
   private Double netIncomeContOpsGrowth;
   
   @JsonProperty("net_income_growth") 
   private Double netIncomeGrowth;
   
   @JsonProperty("normalized_basic_e_p_s_growth") 
   private Double normalizedBasicEpsGrowth;
   
   @JsonProperty("normalized_diluted_e_p_s_growth") 
   private Double normalizedDilutedEpsGrowth;
   
   @JsonProperty("operation_income_growth")
   private Double operationIncomeGrowth;
   
   @JsonProperty("operation_revenue_growth3_month_avg")
   private Double operationRevenueGrowth3MonthAvg;
   
   @JsonProperty("revenue_growth") 
   private Double revenueGrowth;
   
   @JsonProperty("stockholders_equity_growth")
   private Double stockholdersEquityGrowth;
   
   @JsonProperty("total_assets_growth") 
   private Double totalAssetsGrowth;
   
   @JsonProperty("total_debt_equity_ratio_growth")
   private Double totalDebtEquityRatioGrowth;
   
   @JsonProperty("total_liabilities_growth")
   private Double totalLiabilitiesGrowth;
   
   @JsonProperty("cash_flowfrom_investing_growth") 
   private Double cashFlowfromInvestingGrowth;
   
   @JsonProperty("cash_ratio") 
   private Double cashRatio;
   
   @JsonProperty("cashto_total_assets") 
   private Double cashtoTotalAssets;
   
   @JsonProperty("common_equity_to_assets")
   private Double commonEquityToAssets;
   
   @JsonProperty("current_ratio")
   private Double currentRatio;
   
   @JsonProperty("debtto_assets")
   private Double debttoAssets;
   
   @JsonProperty("financial_leverage")
   private Double financialLeverage;
   
   @JsonProperty("long_term_debt_equity_ratio") 
   private Double longTermDebtEquityRatio;
   
   @JsonProperty("long_term_debt_total_capital_ratio") 
   private Double longTermDebtTotalCapitalRatio;
   
   @JsonProperty("quick_ratio") 
   private Double quickRatio;
   
   @JsonProperty("total_debt_equity_ratio")
   private Double totalDebtEquityRatio;
}
