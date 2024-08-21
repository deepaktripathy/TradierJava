package com.deepaktripathy.tradierjava.client.fundamental.response.ratios.operationrestate;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Period6m extends UnrecognizedFieldsCollector {
   @JsonProperty("as_of_date") 
   private String asOfDate;

   @JsonProperty("assets_turnover")
   private Double assetsTurnover;

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

   @JsonProperty("fiscal_year_end") 
   private String fiscalYearEnd;

   @JsonProperty("fix_assets_turonver")
   private Double fixAssetsTuronver;

   @JsonProperty("gross_margin") 
   private Double grossMargin;

   @JsonProperty("interest_coverage") 
   private Double interestCoverage;

   @JsonProperty("inventory_turnover")
   private Double inventoryTurnover;

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

   @JsonProperty("receivable_turnover")
   private Double receivableTurnover;

   @JsonProperty("report_type") 
   private String reportType;

   @JsonProperty("revenue_growth") 
   private Double revenueGrowth;

   @JsonProperty("r_o_a")
   private Double rOA;

   @JsonProperty("r_o_e")
   private Double rOE;

   @JsonProperty("r_o_i_c")
   private Double rOIC;

   @JsonProperty("sales_per_employee") 
   private Double salesPerEmployee;

   @JsonProperty("tax_rate") 
   private Double taxRate;

   @JsonProperty("working_capital_turnover_ratio")
   private Double workingCapitalTurnoverRatio;
}
