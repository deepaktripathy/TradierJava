package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OwnershipSummary extends UnrecognizedFieldsCollector {
   
   @JsonProperty("13_f_holder_number")
   private Integer _13fHolderNumber;

   @JsonProperty("13_f_number_of_existing_owner_buying")
   private Integer _13fNumberOfExistingOwnerBuying;

   @JsonProperty("13_f_number_of_existing_owner_selling")
   private Integer _13fNumberOfExistingOwnerSelling;

   @JsonProperty("13_f_number_of_new_owners")
   private Integer _13fNumberOfNewOwners;

   @JsonProperty("13_f_number_of_sold_out_owners")
   private Integer _13fNumberOfSoldOutOwners;

   @JsonProperty("13_f_percent_held")
   private Double _13fPercentHeld;

   @JsonProperty("13_f_shares_bought")
   private Integer _13fSharesBought;

   @JsonProperty("13_f_shares_held")
   private Long _13fSharesHeld;

   @JsonProperty("13_f_shares_sold")
   private Integer _13fSharesSold;

   @JsonProperty("13_f_total_shares_bought_by_new_owners")
   private Integer _13fTotalSharesBoughtByNewOwners;

   @JsonProperty("13_f_total_shares_sold_out")
   private Integer _13fTotalSharesSoldOut;

   @JsonProperty("13_f_total_market_value")
   private Object _13fTtalMarketValue;

   @JsonProperty("as_of_date")
   private String asOfDate;

   @JsonProperty("fund_company_number_of_existing_owner_buying")
   private Integer fundCompanyNumberOfExistingOwnerBuying;

   @JsonProperty("fund_company_number_of_existing_owner_selling")
   private Integer fundCompanyNumberOfExistingWwnerSelling;

   @JsonProperty("fund_company_number_of_new_owners")
   private Integer fundCompanyNumberOfNewOwners;

   @JsonProperty("fund_company_number_of_sold_out_owners")
   private Integer fundCompanyNumberOfSoldOutOwners;

   @JsonProperty("fund_company_total_market_value")
   private Object fundCompanyTotalMrketValue;

   @JsonProperty("fund_company_total_shares_bought_by_new_owners")
   private Integer fundCompanyTotalSharesBoughtByNewOwners;

   @JsonProperty("fund_company_total_shares_sold_out")
   private Integer fundCompanyTotalSharesSoldOut;

   @JsonProperty("insider_percent_owned")
   private Integer insiderPercentOwned;

   @JsonProperty("insider_shares_bought")
   private Integer insiderSharesBought;

   @JsonProperty("insider_shares_owned")
   private Integer insiderSharesOwned;

   @JsonProperty("insider_shares_sold")
   private Integer insiderSharesSold;

   @JsonProperty("institution_holder_number")
   private Integer institutionHolderNumber;
   
   @JsonProperty("institution_percent_held")
   private Double institutionPercentHeld;

   @JsonProperty("institution_shares_bought")
   private Integer institutionSharesBought;

   @JsonProperty("institution_shares_held")
   private Long institutionSharesHeld;

   @JsonProperty("institution_shares_sold")
   private Integer institutionSharesSold;

   @JsonProperty("float")
   private Integer myfloat;

   @JsonProperty("number_of_insider_buys")
   private Integer numberOfInsiderBuys;

   @JsonProperty("number_of_insider_sellers")
   private Integer numberOfInsiderSellers;

   @JsonProperty("quoted_shares_outstanding")
   private Integer quotedSharesOutstanding;

   @JsonProperty("reasonof_shares_change")
   private String reasonofSharesChange;

   @JsonProperty("share_class_id")
   private String shareClassId;

   @JsonProperty("share_class_level_shares_outstanding_balance_sheet")
   private Integer shareClassLevelSharesOutstandingBalanceSheet;

   @JsonProperty("share_class_level_shares_outstanding_interim")
   private Integer shareClassLevelSharesOutstandingInterim;

   @JsonProperty("share_class_level_treasury_share_outstanding")
   private Integer shareClassLevelTreasuryShareOutstanding;

   @JsonProperty("shares_outstanding")
   private Long sharesOutstanding;

   @JsonProperty("shares_outstanding_with_balance_sheet_ending_date")
   private String sharesOutstandingWithBalanceSheetEndingDate;

   @JsonProperty("un_quoted_shares_outstanding")
   private Integer unQuotedSharesOutstanding;
}
