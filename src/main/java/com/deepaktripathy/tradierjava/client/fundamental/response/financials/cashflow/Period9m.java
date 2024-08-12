package com.deepaktripathy.tradierjava.client.fundamental.response.financials.cashflow;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Period9m extends UnrecognizedFieldsCollector {
   @JsonProperty("asset_impairment_charge") 
   private Double assetImpairmentCharge;

   @JsonProperty("beginning_cash_position") 
   private Double beginningCashPosition;

   @JsonProperty("cap_ex_reported")
   private Double capExPeported;

   @JsonProperty("capital_expenditure") 
   private Double capitalExpenditure;

   @JsonProperty("cash_dividends_paid") 
   private Double cashDividendsPaid;

   @JsonProperty("cash_flow_from_continuing_financing_activities") 
   private Double cashFlowFromContinuingFinancingActivities;

   @JsonProperty("cash_flow_from_continuing_investing_activities") 
   private Double cashFlowFromContinuingInvestingActivities;

   @JsonProperty("cash_flow_from_continuing_operating_activities") 
   private Double cashFlowFromContinuingOperatingActivities;

   @JsonProperty("c_f_file_date") 
   private String cfFileDate;

   @JsonProperty("change_in_account_payable") 
   private Double changeInAccountPayable;

   @JsonProperty("change_in_accrued_expense") 
   private Double changeInAccruedExpense;

   @JsonProperty("change_in_inventory") 
   private Double changeInInventory;

   @JsonProperty("change_in_other_current_assets") 
   private Double changeInOtherCurrentAssets;

   @JsonProperty("change_in_other_working_capital") 
   private Double changeInOtherWorkingCapital;

   @JsonProperty("change_in_payable") 
   private Double changeInPayable;

   @JsonProperty("change_in_payables_and_accrued_expense") 
   private Double changeInPayablesAndAccruedExpense;

   @JsonProperty("change_in_receivables") 
   private Double changeInReceivables;

   @JsonProperty("change_in_tax_payable") 
   private Double changeInTaxPayable;

   @JsonProperty("change_in_working_capital") 
   private Double changeInWorkingCapital;

   @JsonProperty("changes_in_account_receivables") 
   private Double changesInAccountReceivables;

   @JsonProperty("changes_in_cash") 
   private Double changesInCash;

   @JsonProperty("common_stock_dividend_paid") 
   private Double commonStockDividendPaid;

   @JsonProperty("common_stock_payments") 
   private Double commonStockPayments;

   @JsonProperty("currency_id") 
   private String currencyId;

   @JsonProperty("deferred_income_tax") 
   private Double deferredIncomeTax;

   @JsonProperty("deferred_tax") 
   private Double deferredTax;

   @JsonProperty("depreciation_amortization_depletion") 
   private Double depreciationAmortizationDepletion;

   @JsonProperty("depreciation_and_amortization") 
   private Double depreciationAndAmortization;

   @JsonProperty("effect_of_exchange_rate_changes") 
   private Double effectOfExchangeRateChanges;

   @JsonProperty("end_cash_position") 
   private Double endCashPosition;

   @JsonProperty("file_date") 
   private String fileDate;

   @JsonProperty("financing_cash_flow") 
   private Double financingCashFlow;

   @JsonProperty("fiscal_year_end") 
   private String fiscalYearEnd;

   @JsonProperty("fiscal_year_end_change") 
   boolean fiscalYearEndChange;

   @JsonProperty("form_type")
   private String formType;

   @JsonProperty("free_cash_flow") 
   private Double freeCashFlow;

   @JsonProperty("gain_loss_on_sale_of_p_p_e") 
   private Double gainLossOnSaleOfPPE;

   @JsonProperty("income_tax_paid_supplemental_data") 
   private Double incomeTaxPaidSupplementalData;

   @JsonProperty("interest_paid_supplemental_data") 
   private Double interestPaidSupplementalData;

   @JsonProperty("investing_cash_flow") 
   private Double investingCashFlow;

   @JsonProperty("issuance_of_debt") 
   private Double issuanceOfDebt;

   @JsonProperty("long_term_debt_issuance") 
   private Double longTermDebtIssuance;

   @JsonProperty("long_term_debt_payments") 
   private Double longTermDebtPayments;

   @JsonProperty("net_common_stock_issuance") 
   private Double netCommonStockIssuance;

   @JsonProperty("net_income_from_continuing_operations") 
   private Double netIncomeFromContinuingOperations;

   @JsonProperty("net_intangibles_purchase_and_sale") 
   private Double netIntangiblesPurchaseAndSale;

   @JsonProperty("net_investment_purchase_and_sale") 
   private Double netInvestmentPurchaseAndSale;

   @JsonProperty("net_issuance_payments_of_debt") 
   private Double netIssuancePaymentsOfDebt;

   @JsonProperty("net_long_term_debt_issuance") 
   private Double netLongTermDebtIssuance;

   @JsonProperty("net_other_financing_charges") 
   private Double netOtherFinancingCharges;

   @JsonProperty("net_short_term_debt_issuance") 
   private Double netShortTermDebtIssuance;

   @JsonProperty("number_of_share_holders")
   private Integer numberOfShareHolders;

   @JsonProperty("operating_cash_flow") 
   private Double operatingCashFlow;

   @JsonProperty("operating_gains_losses") 
   private Double operatingGainsLosses;

   @JsonProperty("other_non_cash_items") 
   private Double otherNonCashItems;

   @JsonProperty("pension_and_employee_benefit_expense")
   private Double pensionAndEmployeeBenefitExpense;
   
   @JsonProperty("period") 
   private String period;
   
   @JsonProperty("period_ending_date")
   private String periodEndingDate;
   
   @JsonProperty("proceeds_from_stock_option_exercised") 
   private Double proceedsFromStockOptionExercised;
   
   @JsonProperty("purchase_of_intangibles") 
   private Double purchaseOfIntangibles;
   
   @JsonProperty("purchase_of_investment") 
   private Double purchaseOfInvestment;
   
   @JsonProperty("repayment_of_debt")
   private Double repaymentOfDebt;
   
   @JsonProperty("report_type") 
   private String reportType;

   @JsonProperty("repurchase_of_capital_stock") 
   private Double repurchaseOfCapitalStock;

   @JsonProperty("short_term_debt_payments") 
   private Double shortTermDebtPayments;

   @JsonProperty("stock_based_compensation")
   private Double stockBasedCompensation;
}