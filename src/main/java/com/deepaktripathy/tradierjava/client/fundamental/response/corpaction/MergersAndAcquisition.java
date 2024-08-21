package com.deepaktripathy.tradierjava.client.fundamental.response.corpaction; 
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString; 

@Getter
@ToString
public class MergersAndAcquisition extends UnrecognizedFieldsCollector {
   
   @JsonProperty("acquired_company_id")
   private String acquiredCompanyId;

   @JsonProperty("cash_amount")
   private Double cashAmount;

   @JsonProperty("currency_id")
   private String currencyId;

   @JsonProperty("effective_date")
   private String effectiveDate;

   @JsonProperty("notes")
   private String notes;

   @JsonProperty("number_of_shares")
   private String numberOrShares;
   
   @JsonProperty("parent_company_id")
   private String parentCompanyId;
}
