package com.tradierapi.tradierjava.client.account.response;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is part of Balances and is populated if the account_type is cash.
 *
 * @author deepak
 *
 */
public class MarginBalance {

   @JsonProperty("fed_call")
   private Double fedCall;

   @JsonProperty("maintenance_call")
   private Double maintenanceCall;

   @JsonProperty("option_buying_power")
   private Double optionBuyingPower;

   @JsonProperty("stock_buying_power")
   private Double stockBuyingPower;

   @JsonProperty("stock_short_value")
   private Double stockShortValue;

   @JsonProperty("sweep")
   private Double sweep;

   public Double getFedCall() {
      return fedCall;
   }

   public void setFedCall(Double fedCall) {
      this.fedCall = fedCall;
   }

   public Double getMaintenanceCall() {
      return maintenanceCall;
   }

   public void setMaintenanceCall(Double maintenanceCall) {
      this.maintenanceCall = maintenanceCall;
   }

   public Double getOptionBuyingPower() {
      return optionBuyingPower;
   }

   public void setOptionBuyingPower(Double optionBuyingPower) {
      this.optionBuyingPower = optionBuyingPower;
   }

   public Double getStockBuyingPower() {
      return stockBuyingPower;
   }

   public void setStockBuyingPower(Double stockBuyingPower) {
      this.stockBuyingPower = stockBuyingPower;
   }

   public Double getStockShortValue() {
      return stockShortValue;
   }

   public void setStockShortValue(Double stockShortValue) {
      this.stockShortValue = stockShortValue;
   }

   public Double getSweep() {
      return sweep;
   }

   public void setSweep(Double sweep) {
      this.sweep = sweep;
   }

   @Override
   public int hashCode() {
      return Objects.hash(fedCall, maintenanceCall, optionBuyingPower, stockBuyingPower, stockShortValue, sweep);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if ((obj == null) || (getClass() != obj.getClass()))
         return false;
      MarginBalance other = (MarginBalance) obj;
      return Objects.equals(fedCall, other.fedCall) && Objects.equals(maintenanceCall, other.maintenanceCall)
            && Objects.equals(optionBuyingPower, other.optionBuyingPower)
            && Objects.equals(stockBuyingPower, other.stockBuyingPower)
            && Objects.equals(stockShortValue, other.stockShortValue) && Objects.equals(sweep, other.sweep);
   }

   @Override
   public String toString() {
      return "MarginBalance [fedCall=" + fedCall + ", maintenanceCall=" + maintenanceCall + ", optionBuyingPower="
            + optionBuyingPower + ", stockBuyingPower=" + stockBuyingPower + ", stockShortValue=" + stockShortValue
            + ", sweep=" + sweep + "]";
   }

}
