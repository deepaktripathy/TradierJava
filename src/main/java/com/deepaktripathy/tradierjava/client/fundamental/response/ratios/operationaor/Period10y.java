package com.deepaktripathy.tradierjava.client.fundamental.response.ratios.operationaor;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Period10y extends UnrecognizedFieldsCollector {
   
   @JsonProperty("as_of_date") 
   private String asOfDate;

   @JsonProperty("capital_expenditure_annual5_yr_growth") 
   private Double capitalExpenditureAnnual5YrGrowth;

   @JsonProperty("cash_ratio_growth") 
   private Double cashRatioGrowth;

   @JsonProperty("c_f_o_growth3_month_avg") 
   private Double cFOGrowth3MonthAvg;

   @JsonProperty("company_id") 
   private String companyID;

   @JsonProperty("current_ratio_growth") 
   private Double currentRatioGrowth;

   @JsonProperty("e_b_i_t_d_a_growth") 
   private Double eBITDAGrowth;
   
   @JsonProperty("f_c_f_growth3_month_avg") 
   private Double fCFGrowth3MonthAvg;    
   
   @JsonProperty("fiscal_year_end") 
   private String fiscalYearEnd;
   
   @JsonProperty("gross_profit_annual5_yr_growth") 
   private Double grossProfitAnnual5YrGrowth;
   
   @JsonProperty("net_income_cont_ops_growth") 
   private Double netIncomeContOpsGrowth;
   
   @JsonProperty("net_income_growth") 
   private Double netIncomeGrowth;
   
   @JsonProperty("operation_income_growth") 
   private Double operationIncomeGrowth;
   
   @JsonProperty("operation_revenue_growth3_month_avg") 
   private Double operationRevenueGrowth3MonthAvg;
   
   @JsonProperty("period") 
   private String period;
   
   @JsonProperty("report_type") 
   private String reportType;
   
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
}
