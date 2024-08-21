package com.deepaktripathy.tradierjava.client.fundamental.response.dividend;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CashDividend extends UnrecognizedFieldsCollector {
   @JsonProperty("share_class_id") 
   private String shareClassId;
   
   @JsonProperty("dividend_type") 
   private String dividendType;
   
   @JsonProperty("ex_date") 
   private String exDate;
   
   @JsonProperty("cash_amount") 
   private Double cashAmount;
   
   @JsonProperty("currency_i_d") 
   private String currencyId;
   
   @JsonProperty("declaration_date") 
   private String declarationDate;
   
   @JsonProperty("frequency") 
   private Integer frequency;
   
   @JsonProperty("pay_date") 
   private String payDate;
   
   @JsonProperty("record_date") 
   private String recordDate;

   @Override
   public String toString() {
      return "CashDividend [shareClassId=" + shareClassId + ", dividendType=" + dividendType + ", exDate=" + exDate
            + ", cashAmount=" + cashAmount + ", currencyId=" + currencyId + ", declarationDate=" + declarationDate
            + ", frequency=" + frequency + ", payDate=" + payDate + ", recordDate=" + recordDate + "]";
   }
   
}