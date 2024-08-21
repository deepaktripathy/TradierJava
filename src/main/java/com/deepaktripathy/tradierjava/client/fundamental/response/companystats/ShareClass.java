package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ShareClass extends UnrecognizedFieldsCollector {
   
   @JsonProperty("company_id")
   private String companyId;

   @JsonProperty("share_class_id")
   private String shareClassId;

   @JsonProperty("share_class_description")
   private String shareClassDescription;
   
   @JsonProperty("conversion_ratio")
   private Integer conversionRatio;

   @JsonProperty("currency_id")
   private String currencyId;

   @JsonProperty("delisting_date")
   private String delistingDate;

   @JsonProperty("exchange_id")
   private String exchangeId;

   @JsonProperty("exchange_sub_market_global_id")
   private String exchangeSubMarketGlobalId;

   @JsonProperty("investment_id")
   private String investmentId;

   @JsonProperty("i_p_o_date")
   private String ipoDate;

   @JsonProperty("is_depositary_receipt")
   boolean isDepositaryReceipt;

   @JsonProperty("is_direct_invest")
   boolean isDirectInvest;

   @JsonProperty("is_dividend_reinvest")
   boolean isDividendReinvest;

   @JsonProperty("is_primary_share")
   boolean isPrimaryShare;

   @JsonProperty("m_i_c")
   private String mic;

   @JsonProperty("par_value")
   private Double parValue;

   @JsonProperty("security_type")
   private String securityType;

   @JsonProperty("share_class_status")
   private String shareClassStatus;

   @JsonProperty("symbol")
   private String symbol;

   @JsonProperty("c_u_s_i_p")
   private String cusip;
   
   @JsonProperty("trading_status")
   boolean tradingStatus;

   @JsonProperty("i_p_o_offer_price")
   private Integer ipoOfferPrice;

   @JsonProperty("i_p_o_offer_price_range")
   private String ipoOfferPriceRange;
}
