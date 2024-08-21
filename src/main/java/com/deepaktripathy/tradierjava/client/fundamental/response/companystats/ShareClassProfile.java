package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ShareClassProfile extends UnrecognizedFieldsCollector {
   
   @JsonProperty("enterprise_value")
   private Object enterpriseValue;

   @JsonProperty("EnterpriseValue.asOfDate")
   private String enterpriseValueAsOfDate;

   @JsonProperty("market_cap")
   private Long marketCap;

   @JsonProperty("MarketCap.asOfDate")
   private String marketCapAsOfDate;

   @JsonProperty("reasonof_shares_change")
   private String reasonofSharesChange;

   @JsonProperty("ReasonofSharesChange.asOfDate")
   private String reasonofSharesChangeAsOfDate;

   @JsonProperty("share_class_id")
   private String shareClassId;

   @JsonProperty("share_class_level_shares_outstanding")
   private Long shareClassLevelSharesOutstanding;

   @JsonProperty("ShareClassLevelSharesOutstanding.asOfDate")
   private String shareClassLevelSharesOutstandingAsOfDate;

   @JsonProperty("shares_outstanding")
   private Long sharesOutstanding;

   @JsonProperty("SharesOutstanding.asOfDate")
   private String sharesOutstandingAsOfDate;

   @JsonProperty("shares_outstanding_with_balance_sheet_ending_date")
   private String sharesOutstandingWithBalanceSheetEndingDate;

   @JsonProperty("SharesOutstandingWithBalanceSheetEndingDate.asOfDate")
   private String sharesOutstandingWithBalanceSheetEndingDateAsOfDate;
}