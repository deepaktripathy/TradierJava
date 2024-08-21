package com.deepaktripathy.tradierjava.client.fundamental.response.financials.balancesheet;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Period3m extends UnrecognizedFieldsCollector {

   @JsonProperty("accession_number")
   private String accessionNumber;

   @JsonProperty("accounts_payable") 
   private Double accountsPayable;

   @JsonProperty("accounts_receivable") 
   private Double accountsReceivable;

   @JsonProperty("accumulated_depreciation") 
   private Double accumulatedDepreciation;

   @JsonProperty("additional_paid_in_capital") 
   private Double additionalPaidInCapital;

   @JsonProperty("allowance_for_doubtful_accounts_receivable") 
   private Double allowanceForDoubtfulAccountsReceivable;

   @JsonProperty("assets_held_for_sale_current") 
   private Double assetsHeldForSaleCurrent;

   @JsonProperty("available_for_sale_securities") 
   private Double availableForSaleSecurities;

   @JsonProperty("b_s_file_date") 
   private String bsFileDate;

   @JsonProperty("buildings_and_improvements") 
   private Double buildingsAndImprovements;

   @JsonProperty("capital_lease_obligations") 
   private Double capitalLeaseObligations;

   @JsonProperty("capital_stock") 
   private Double capitalStock;

   @JsonProperty("cash") 
   private Double cash;

   @JsonProperty("cash_and_cash_equivalents") 
   private Double cashAndCashEquivalents;

   @JsonProperty("cash_cash_equivalents_and_marketable_securities") 
   private Double cashCashEquivalentsAndMarketableSecurities;

   @JsonProperty("cash_equivalents") 
   private Double cashEquivalents;

   @JsonProperty("common_stock_equity")
   private Double common_stock_equity;

   @JsonProperty("common_stock")
   private Double commonStock;

   @JsonProperty("com_tre_sha_num") 
   private Double comTreShaNum;

   @JsonProperty("construction_in_progress") 
   private Double constructionInProgress;

   @JsonProperty("currency_id") 
   private String currencyId;

   @JsonProperty("current_accrued_expenses") 
   private Double currentAccruedExpenses;

   @JsonProperty("current_assets") 
   private Double currentAssets;

   @JsonProperty("current_capital_lease_obligation") 
   private Double currentCapitalLeaseObligation;

   @JsonProperty("current_debt") 
   private Double currentDebt;

   @JsonProperty("current_debt_and_capital_lease_obligation") 
   private Double currentDebtAndCapitalLeaseObligation;

   @JsonProperty("current_deferred_assets")
   private Double currentDeferredAssets;

   @JsonProperty("current_deferred_liabilities") 
   private Double currentDeferredLiabilities;

   @JsonProperty("current_deferred_revenue") 
   private Double currentDeferredRevenue;

   @JsonProperty("current_liabilities") 
   private Double currentLiabilities;

   @JsonProperty("current_notes_payable")
   private Double currentNotesPayable;

   @JsonProperty("current_provisions") 
   private Double currentProvisions;

   @JsonProperty("defined_pension_benefit")
   private Double definedPensionBenefit;

   @JsonProperty("dividends_payable") 
   private Double dividendsPayable;

   @JsonProperty("duefrom_related_parties_current")
   private Double duefrom_related_parties_current;

   @JsonProperty("dueto_related_parties_current")
   private Double dueto_related_parties_current;

   @JsonProperty("employee_benefits") 
   private Double employeeBenefits;

   @JsonProperty("file_date") 
   private String fileDate;

   @JsonProperty("finished_goods") 
   private Double finishedGoods;

   @JsonProperty("fiscal_year_end") 
   private String fiscalYearEnd;

   @JsonProperty("fiscal_year_end_change") 
   boolean fiscalYearEndChange;

   @JsonProperty("form_type")
   private String formType;

   @JsonProperty("gains_losses_not_affecting_retained_earnings") 
   private Double gainsLossesNotAffectingRetainedEarnings;

   @JsonProperty("goodwill") 
   private Double goodwill;

   @JsonProperty("goodwill_and_other_intangible_assets") 
   private Double goodwillAndOtherIntangibleAssets;

   @JsonProperty("gross_accounts_receivable") 
   private Double grossAccountsReceivable;

   @JsonProperty("gross_p_p_e") 
   private Double grossPPE;

   @JsonProperty("income_tax_payable") 
   private Double incomeTaxPayable;

   @JsonProperty("interest_payable") 
   private Double interestPayable;

   @JsonProperty("inventory") 
   private Double inventory;

   @JsonProperty("invested_capital") 
   private Double investedCapital;

   @JsonProperty("investmentin_financial_assets")
   private Double investmentinFinancialAssets;

   @JsonProperty("investments_and_advances") 
   private Double investmentsAndAdvances;

   @JsonProperty("land_and_improvements") 
   private Double landAndImprovements;

   @JsonProperty("leases") 
   private Double leases;

   @JsonProperty("liabilities_heldfor_sale_non_current")
   private Double liabilitiesHeldforSaleNonCurrent;

   @JsonProperty("line_of_credit") 
   private Double lineOfCredit;

   @JsonProperty("loans_receivable") 
   private Double loansReceivable;

   @JsonProperty("long_term_capital_lease_obligation") 
   private Double longTermCapitalLeaseObligation;

   @JsonProperty("long_term_debt") 
   private Double longTermDebt;

   @JsonProperty("long_term_debt_and_capital_lease_obligation") 
   private Double longTermDebtAndCapitalLeaseObligation;

   @JsonProperty("long_term_investments") 
   private Double longTermInvestments;

   @JsonProperty("long_term_provisions")
   private Double longTermProvisions;

   @JsonProperty("machinery_furniture_equipment")
   private Double machinery_furniture_equipment;

   @JsonProperty("minority_interest")
   private Double minorityInterest;

   @JsonProperty("net_debt") 
   private Double netDebt;

   @JsonProperty("net_p_p_e") 
   private Double netPPE;

   @JsonProperty("net_tangible_assets") 
   private Double netTangibleAssets;

   @JsonProperty("non_current_accounts_receivable")
   private Double nonCurrentAccountsReceivable;

   @JsonProperty("non_current_deferred_assets")
   private Double nonCurrentDeferredAssets;

   @JsonProperty("non_current_deferred_liabilities")
   private Double nonCurrentDeferredLiabilities;

   @JsonProperty("non_current_deferred_revenue")
   private Double nonCurrentDeferredRevenue;

   @JsonProperty("non_current_deferred_taxes_assets")
   private Double nonCurrentDeferredTaxesAssets;

   @JsonProperty("non_current_deferred_taxes_liabilities")
   private Double nonCurrentDeferredTaxesLiabilities;

   @JsonProperty("non_current_pension_and_other_postretirement_benefit_plans")
   private Double nonCurrentPensionAndOtherPostretirementBenefitPlans;

   @JsonProperty("number_of_share_holders")
   private Integer numberOfShareHolders;

   @JsonProperty("ordinary_shares_number")
   private Double ordinarySharesNumber;

   @JsonProperty("other_equity_interest")
   private Double other_equity_interest;

   @JsonProperty("other_inventories")
   private Double other_inventories;

   @JsonProperty("other_payable")
   private Double other_payable;

   @JsonProperty("other_current_assets")
   private Double otherCurrentAssets;

   @JsonProperty("other_current_borrowings") 
   private Double otherCurrentBorrowings;

   @JsonProperty("other_current_liabilities") 
   private Double otherCurrentLiabilities;

   @JsonProperty("other_equity_adjustments")
   private Double otherEquityAdjustments;

   @JsonProperty("other_intangible_assets")
   private Double otherIntangibleAssets;

   @JsonProperty("other_investments") 
   private Double otherInvestments;

   @JsonProperty("other_non_current_assets")
   private Double otherNonCurrentAssets;

   @JsonProperty("other_non_current_liabilities")
   private Double otherNonCurrentLiabilities;

   @JsonProperty("other_properties")
   private Double otherProperties;

   @JsonProperty("other_receivables")
   private Double otherReceivables;

   @JsonProperty("other_short_term_investments") 
   private Double otherShortTermInvestments;

   @JsonProperty("payables")
   private Double payables;

   @JsonProperty("payables_and_accrued_expenses")
   private Double payablesAndAccruedExpenses;

   @JsonProperty("pensionand_other_post_retirement_benefit_plans_current")
   private Double pensionandOtherPostRetirementBenefitPlansCurrent;

   @JsonProperty("period") 
   private String period;

   @JsonProperty("period_ending_date")
   private String periodEndingDate;

   @JsonProperty("preferred_stock")
   private Double preferred_stock;

   @JsonProperty("preferred_securities_outside_stock_equity") 
   private Double preferredSecuritiesOutsideStockEquity;

   @JsonProperty("prepaid_assets") 
   private Double prepaidAssets;

   @JsonProperty("properties") 
   private Double properties;

   @JsonProperty("raw_materials") 
   private Double rawMaterials;

   @JsonProperty("receivables")
   private Double receivables;

   @JsonProperty("report_type") 
   private String reportType;

   @JsonProperty("restricted_cash")
   private Double restrictedCash;

   @JsonProperty("retained_earnings")
   private Double retainedEarnings;
   
   @JsonProperty("share_issued")
   private Double shareIssued;
   
   @JsonProperty("stockholders_equity")
   private Double stockholdersEquity;
   
   @JsonProperty("tangible_book_value")
   private Double tangibleBookValue;
   
   @JsonProperty("total_assets") 
   private Double totalAssets;
   
   @JsonProperty("total_capitalization")
   private Double totalCapitalization;
   
   @JsonProperty("total_debt")
   private Double totalDebt;
   
   @JsonProperty("total_equity")
   private Double totalEquity;
   
   @JsonProperty("total_equity_gross_minority_interest")
   private Double totalEquityGrossMinorityInterest;
   
   @JsonProperty("total_liabilities_net_minority_interest")
   private Double totalLiabilitiesNetMinorityInterest;
   
   @JsonProperty("total_non_current_assets") 
   private Double totalNonCurrentAssets;

   @JsonProperty("total_non_current_liabilities_net_minority_interest")
   private Double totalNonCurrentLiabilitiesNetMinorityInterest;

   @JsonProperty("total_tax_payable") 
   private Double totalTaxPayable;

   @JsonProperty("tradeand_other_payables_non_current")
   private Double tradeandOtherPayablesNonCurrent;

   @JsonProperty("treasury_shares_number")
   private Double treasurySharesNumber;
   
   @JsonProperty("treasury_stock")
   private Double treasuryStock;
   
   @JsonProperty("working_capital")
   private Double workingCapital;
   
   @JsonProperty("work_in_process") 
   private Double workInProcess;
}