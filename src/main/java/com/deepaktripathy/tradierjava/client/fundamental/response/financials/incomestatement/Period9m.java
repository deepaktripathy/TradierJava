package com.deepaktripathy.tradierjava.client.fundamental.response.financials.incomestatement;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Period9m extends UnrecognizedFieldsCollector {
   @JsonProperty("accession_number")
   private String accessionNumber;

   @JsonProperty("cost_of_revenue") 
   private Double costOfRevenue;

   @JsonProperty("currency_id") 
   private String currencyID;

   @JsonProperty("diluted_n_i_availto_com_stockholders") 
   private Double dilutedNIAvailtoComStockholders;
   
   @JsonProperty("e_b_i_t") 
   private Double eBIT;

   @JsonProperty("e_b_i_t_d_a") 
   private Double eBITDA;

   @JsonProperty("file_date")
   private String fileDate;

   @JsonProperty("fiscal_year_end")
   private Double fiscalYearEnd;

   @JsonProperty("fiscal_year_end_change")
   private Boolean fiscalYearEndChange;

   @JsonProperty("gross_profit") 
   private Double grossProfit;

   @JsonProperty("interest_expense") 
   private Double interestExpense;

   @JsonProperty("interest_expense_non_operating") 
   private Double interestExpenseNonOperating;

   @JsonProperty("interest_income") 
   private Double interestIncome;

   @JsonProperty("interest_income_non_operating") 
   private Double interestIncomeNonOperating;

   @JsonProperty("minority_interests")
   private Double minorityInterests;

   @JsonProperty("net_income") 
   private Double netIncome;

   @JsonProperty("net_income_common_stockholders") 
   private Double netIncomeCommonStockholders;

   @JsonProperty("net_income_continuous_operations") 
   private Double netIncomeContinuousOperations;

   @JsonProperty("net_income_from_continuing_and_discontinued_operation") 
   private Double netIncomeFromContinuingAndDiscontinuedOperation;

   @JsonProperty("net_income_from_continuing_operation_net_minority_interest") 
   private Double netIncomeFromContinuingOperationNetMinorityInterest;

   @JsonProperty("net_income_including_noncontrolling_interests") 
   private Double netIncomeIncludingNoncontrollingInterests;

   @JsonProperty("net_interest_income") 
   private Double netInterestIncome;

   @JsonProperty("net_non_operating_interest_income_expense") 
   private Double netNonOperatingInterestIncomeExpense;

   @JsonProperty("normalized_e_b_i_t_d_a") 
   private Double normalizedEBITDA;

   @JsonProperty("normalized_income") 
   private Double normalizedIncome;

   @JsonProperty("normalized_pre_tax_income") 
   private Double normalizedPreTaxIncome;

   @JsonProperty("number_of_share_holders")
   private Double numberOfShareHolders;

   @JsonProperty("operating_expense") 
   private Double operatingExpense;

   @JsonProperty("operating_income") 
   private Double operatingIncome;

   @JsonProperty("operating_revenue") 
   private Double operatingRevenue;

   @JsonProperty("other_income_expense") 
   private Double otherIncomeExpense;

   @JsonProperty("other_non_operating_income_expenses") 
   private Double otherNonOperatingIncomeExpenses;

   @JsonProperty("other_operating_expenses")
   private Double otherOperatingExpenses;

   @JsonProperty("period") 
   private String period;

   @JsonProperty("period_ending_date")
   private String periodEndingDate;

   @JsonProperty("pretax_income") 
   private Double pretaxIncome;

   @JsonProperty("reconciled_cost_of_revenue") 
   private Double reconciledCostOfRevenue;

   @JsonProperty("reconciled_depreciation") 
   private Double reconciledDepreciation;

   @JsonProperty("report_type")
   private String reportType;

   @JsonProperty("restructuring_and_mergern_acquisition")
   private Double restructuringAndMergernAcquisition;

   @JsonProperty("selling_general_and_administration") 
   private Double sellingGeneralAndAdministration;

   @JsonProperty("special_income_charges") 
   private Double specialIncomeCharges;

   @JsonProperty("tax_effect_of_unusual_items") 
   private Double taxEffectOfUnusualItems;

   @JsonProperty("tax_provision") 
   private Double taxProvision;

   @JsonProperty("total_expenses") 
   private Double totalExpenses;

   @JsonProperty("total_operating_income_as_reported") 
   private Double totalOperatingIncomeAsReported;

   @JsonProperty("total_revenue") 
   private Double totalRevenue;

   @JsonProperty("total_unusual_items") 
   private Double totalUnusualItems;

   @JsonProperty("total_unusual_items_excluding_goodwill") 
   private Double totalUnusualItemsExcludingGoodwill;  
   
   @JsonProperty("i_s_file_date") 
   private String isFileDate;

   @JsonProperty("tax_rate_for_calcs")
   private Double taxRateForCalcs;

   @JsonProperty("form_type")
   private String formType;

   @JsonProperty("impairment_of_capital_assets")
   private Double impairmentOfCapitalAssets;
}