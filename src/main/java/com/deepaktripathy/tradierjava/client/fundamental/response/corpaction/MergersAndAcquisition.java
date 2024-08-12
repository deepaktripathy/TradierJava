package com.deepaktripathy.tradierjava.client.fundamental.response.corpaction; 
import java.util.Objects;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty; 

public class MergersAndAcquisition extends UnrecognizedFieldsCollector {
   @JsonProperty("acquired_company_id")
   private String acquiredCompanyId;

   @JsonProperty("parent_company_id")
   private String parentCompanyId;

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
   
   public String getAcquiredCompanyId() {
      return acquiredCompanyId;
   }

   public void setAcquiredCompanyId(String acquiredCompanyId) {
      this.acquiredCompanyId = acquiredCompanyId;
   }

   public String getParentCompanyId() {
      return parentCompanyId;
   }

   public void setParentCompanyId(String parentCompanyId) {
      this.parentCompanyId = parentCompanyId;
   }

   public Double getCashAmount() {
      return cashAmount;
   }

   public void setCashAmount(Double cashAmount) {
      this.cashAmount = cashAmount;
   }

   public String getCurrencyId() {
      return currencyId;
   }

   public void setCurrencyId(String currencyId) {
      this.currencyId = currencyId;
   }

   public String getEffectiveDate() {
      return effectiveDate;
   }

   public void setEffectiveDate(String effectiveDate) {
      this.effectiveDate = effectiveDate;
   }

   public String getNotes() {
      return notes;
   }

   public void setNotes(String notes) {
      this.notes = notes;
   }
   
   public String getNumberOrShares() {
      return numberOrShares;
   }

   public void setNumberOrShares(String numberOrShares) {
      this.numberOrShares = numberOrShares;
   }

   @Override
   public int hashCode() {
      return Objects.hash(acquiredCompanyId, cashAmount, currencyId, effectiveDate, notes, numberOrShares,
            parentCompanyId);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      MergersAndAcquisition other = (MergersAndAcquisition) obj;
      return Objects.equals(acquiredCompanyId, other.acquiredCompanyId) && Objects.equals(cashAmount, other.cashAmount)
            && Objects.equals(currencyId, other.currencyId) && Objects.equals(effectiveDate, other.effectiveDate)
            && Objects.equals(notes, other.notes) && Objects.equals(numberOrShares, other.numberOrShares)
            && Objects.equals(parentCompanyId, other.parentCompanyId);
   }

   @Override
   public String toString() {
      return "MergersAndAcquisition [acquiredCompanyId=" + acquiredCompanyId + ", parentCompanyId=" + parentCompanyId
            + ", cashAmount=" + cashAmount + ", currencyId=" + currencyId + ", effectiveDate=" + effectiveDate
            + ", notes=" + notes + ", numberOrShares=" + numberOrShares + "]";
   }

}
