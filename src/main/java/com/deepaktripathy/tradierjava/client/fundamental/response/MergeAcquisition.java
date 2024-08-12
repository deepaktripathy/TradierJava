package com.deepaktripathy.tradierjava.client.fundamental.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MergeAcquisition {

   @JsonProperty("acquired_company_id")
   private String acquiredCompanyId;

   @JsonProperty("parent_company_id")
   private String parentCompanyId;

   @JsonProperty("cash_amount")
   private String cashAmount;

   @JsonProperty("currency_id")
   private String currencyId;

   @JsonProperty("effective_date")
   private LocalDate effectiveDate;

   @JsonProperty("notes")
   private String notes;

   @Override
   public String toString() {
      return "MergeAcquisition [acquiredCompanyId=" + acquiredCompanyId + ", parentCompanyId=" + parentCompanyId
            + ", cashAmount=" + cashAmount + ", currencyId=" + currencyId + ", effectiveDate=" + effectiveDate
            + ", notes=" + notes + "]";
   }


}
