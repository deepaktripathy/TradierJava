package com.deepaktripathy.tradierjava.client.fundamental.response.financials.incomestatement;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Period3m extends UnrecognizedFieldsCollector {
   @JsonProperty("accession_number")
   private String accessionNumber;

   @JsonProperty("amortization")
   private Double amortization;

   @JsonProperty("amortization_of_intangibles")
   private Double amortizationOfIntangibles;

   @JsonProperty("average_dilution_earn") 
   private Double averageDilutionEarn;

   @JsonProperty("cost_of_revenue") 
   private Double costOfRevenue;

   @JsonProperty("currency_id") 
   private String currencyID;

   @JsonProperty("depletion")
   private Double depletion;

   @JsonProperty("depreciation") 
   private Double depreciation;

   @JsonProperty("depreciation_amortization_depletion")
   private Double depreciationAmortizationDepletion;

   @JsonProperty("depreciation_and_amortization") 
   private Double depreciationAndAmortization;

   @JsonProperty("diluted_n_i_availto_com_stockholders") 
   private Double dilutedNIAvailtoComStockholders;
   
   @JsonProperty("earnings_from_equity_interest")
   private Double earningsFromEquityInterest;

   @JsonProperty("earningsfrom_equity_interest_net_of_tax")
   private Double earningsfromEquityInterestNetOfTax;

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

   @JsonProperty("form_type")
   private String formType;

   @JsonProperty("gain_on_sale_of_business")
   private Double gain_on_sale_of_business;

   @JsonProperty("gain_loss_on_sale_of_business")
   private Double gainLossOnSaleOfBusiness;

   @JsonProperty("gain_on_sale_of_security") 
   private Double gainOnSaleOfSecurity;

   @JsonProperty("general_and_administrative_expense") 
   private Double generalAndAdministrativeExpense;

   @JsonProperty("gross_profit") 
   private Double grossProfit;

   @JsonProperty("impairment_of_capital_assets")
   private Double impairmentOfCapitalAssets;

   @JsonProperty("insurance_and_claims") 
   private Double insuranceAndClaims;

   @JsonProperty("interest_expense") 
   private Double interestExpense;

   @JsonProperty("interest_expense_non_operating") 
   private Double interestExpenseNonOperating;

   @JsonProperty("interest_income") 
   private Double interestIncome;

   @JsonProperty("interest_income_non_operating") 
   private Double interestIncomeNonOperating;

   @JsonProperty("i_s_file_date") 
   private String isFileDate;

   @JsonProperty("minority_interests")
   private Double minorityInterests;

   @JsonProperty("net_income") 
   private Double netIncome;

   @JsonProperty("net_income_common_stockholders") 
   private Double netIncomeCommonStockholders;

   @JsonProperty("net_income_continuous_operations") 
   private Double netIncomeContinuousOperations;

   @JsonProperty("net_income_discontinuous_operations")
   private Double netIncomeDiscontinuousOperations;

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

   @JsonProperty("other_gn_a") 
   private Double otherGnA;

   @JsonProperty("other_income_expense") 
   private Double otherIncomeExpense;

   @JsonProperty("other_non_operating_income_expenses") 
   private Double otherNonOperatingIncomeExpenses;

   @JsonProperty("other_operating_expenses")
   private Double otherOperatingExpenses;

   @JsonProperty("other_taxes") 
   private Double otherTaxes;

   @JsonProperty("period") 
   private String period;

   @JsonProperty("period_ending_date")
   private String periodEndingDate;

   @JsonProperty("pretax_income") 
   private Double pretaxIncome;

   @JsonProperty("provision_for_doubtful_accounts")
   private Double provisionForDoubtfulAccounts;

   @JsonProperty("reconciled_cost_of_revenue") 
   private Double reconciledCostOfRevenue;

   @JsonProperty("reconciled_depreciation") 
   private Double reconciledDepreciation;

   @JsonProperty("rent_and_landing_fees")
   private Double rentAndLandingFees;

   @JsonProperty("rent_expense_supplemental")
   private Double rentExpenseSupplemental;

   @JsonProperty("report_type")
   private String reportType;

   @JsonProperty("research_and_development") 
   private Double researchAndDevelopment;

   @JsonProperty("restructuring_and_mergern_acquisition")
   private Double restructuringAndMergernAcquisition;

   @JsonProperty("salaries_and_wages")
   private Double salariesAndWages;   
   
   @JsonProperty("selling_and_marketing_expense") 
   private Double sellingAndMarketingExpense;
   
   @JsonProperty("selling_general_and_administration") 
   private Double sellingGeneralAndAdministration;
   
   @JsonProperty("special_income_charges") 
   private Double specialIncomeCharges;
   
   @JsonProperty("tax_effect_of_unusual_items") 
   private Double taxEffectOfUnusualItems;
   
   @JsonProperty("tax_provision") 
   private Double taxProvision;
   
   @JsonProperty("tax_rate_for_calcs")
   private Double taxRateForCalcs;
   
   @JsonProperty("total_expenses") 
   private Double totalExpenses;
   
   @JsonProperty("total_operating_income_as_reported") 
   private Double totalOperatingIncomeAsReported;
   
   @JsonProperty("total_other_finance_cost")
   private Double totalOtherFinanceCost;

   @JsonProperty("total_revenue") 
   private Double totalRevenue;
   
   @JsonProperty("total_unusual_items") 
   private Double totalUnusualItems;

   @JsonProperty("total_unusual_items_excluding_goodwill") 
   private Double totalUnusualItemsExcludingGoodwill;

   @JsonProperty("write_off") 
   private Double writeOff;
}