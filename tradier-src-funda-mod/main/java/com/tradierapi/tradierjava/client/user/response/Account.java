package com.tradierapi.tradierjava.client.user.response;

import java.time.ZonedDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tradierapi.tradierjava.model.AccountType;

/**
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */
public class Account {
   @JsonProperty("account_number")
   private String accountNumber;
   @JsonProperty("classification")
   private Classification classification;
   @JsonProperty("date_created")
   private ZonedDateTime createDate;
   @JsonProperty("day_trader")
   private Boolean dayTrader;
   @JsonProperty("option_level")
   private Integer optionLevel;
   @JsonProperty("status")
   private AccountStatus status;
   @JsonProperty("type")
   private AccountType type;
   @JsonProperty("last_update_date")
   private ZonedDateTime lastUpdateDate;

   public String getAccountNumber() {
      return accountNumber;
   }

   public Classification getClassification() {
      return classification;
   }

   public ZonedDateTime getCreateDate() {
      return createDate;
   }

   public Boolean getDayTrader() {
      return dayTrader;
   }

   public Integer getOptionLevel() {
      return optionLevel;
   }

   public AccountStatus getStatus() {
      return status;
   }

   public AccountType getType() {
      return type;
   }

   public ZonedDateTime getLastUpdateDate() {
      return lastUpdateDate;
   }

   @Override
   public int hashCode() {
      return Objects.hash(accountNumber, classification, createDate, dayTrader, lastUpdateDate, optionLevel, status,
            type);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Account other = (Account) obj;
      return Objects.equals(accountNumber, other.accountNumber) && classification == other.classification
            && Objects.equals(createDate, other.createDate) && Objects.equals(dayTrader, other.dayTrader)
            && Objects.equals(lastUpdateDate, other.lastUpdateDate) && Objects.equals(optionLevel, other.optionLevel)
            && status == other.status && type == other.type;
   }

   @Override
   public String toString() {
      return "Account [accountNumber=" + accountNumber + ", classification=" + classification + ", createDate="
            + createDate + ", dayTrader=" + dayTrader + ", optionLevel=" + optionLevel + ", status=" + status
            + ", type=" + type + ", lastUpdateDate=" + lastUpdateDate + "]";
   }

}
