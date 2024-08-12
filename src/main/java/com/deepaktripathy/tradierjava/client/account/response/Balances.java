package com.deepaktripathy.tradierjava.client.account.response;

import java.util.Objects;

import com.deepaktripathy.tradierjava.client.model.AccountType;
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Balances extends UnrecognizedFieldsCollector {

   @JsonProperty("option_short_value")
   private Double optionShortValue;

   @JsonProperty("total_equity")
   private Double totalEquity;

   @JsonProperty("account_number")
   private String accountNumber;

   @JsonProperty("account_type")
   private AccountType accountType;

   @JsonProperty("close_pl")
   private Double closePl;

   @JsonProperty("current_requirement")
   private Double currentRequirement;

   @JsonProperty("equity")
   private Double equity;

   @JsonProperty("long_market_value")
   private Double longMarketValue;

   @JsonProperty("market_value")
   private Double marketValue;

   @JsonProperty("open_pl")
   private Double openPl;

   @JsonProperty("option_long_value")
   private Double optionLongValue;

   @JsonProperty("option_requirement")
   private Double optionRequirement;

   @JsonProperty("pending_orders_count")
   private Double pendingOrdersCount;

   @JsonProperty("short_market_value")
   private Double shortMarketValue;

   @JsonProperty("stock_long_value")
   private Double stockLongValue;

   @JsonProperty("total_cash")
   private Double totalCash;

   @JsonProperty("uncleared_funds")
   private Double unclearFunds;

   @JsonProperty("pending_cash")
   private Double pendingCash;

   @JsonProperty("cash")
   private CashBalance cash;

   @JsonProperty("margin")
   private MarginBalance margin;

   @JsonProperty("pdt")
   private PdtBalance pdt;

   public Double getOptionShortValue() {
      return optionShortValue;
   }

   public void setOptionShortValue(Double optionShortValue) {
      this.optionShortValue = optionShortValue;
   }

   public Double getTotalEquity() {
      return totalEquity;
   }

   public void setTotalEquity(Double totalEquity) {
      this.totalEquity = totalEquity;
   }

   public String getAccountNumber() {
      return accountNumber;
   }

   public void setAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
   }

   public AccountType getAccountType() {
      return accountType;
   }

   public void setAccountType(AccountType accountType) {
      this.accountType = accountType;
   }

   public Double getClosePl() {
      return closePl;
   }

   public void setClosePl(Double closePl) {
      this.closePl = closePl;
   }

   public Double getCurrentRequirement() {
      return currentRequirement;
   }

   public void setCurrentRequirement(Double currentRequirement) {
      this.currentRequirement = currentRequirement;
   }

   public Double getEquity() {
      return equity;
   }

   public void setEquity(Double equity) {
      this.equity = equity;
   }

   public Double getLongMarketValue() {
      return longMarketValue;
   }

   public void setLongMarketValue(Double longMarketValue) {
      this.longMarketValue = longMarketValue;
   }

   public Double getMarketValue() {
      return marketValue;
   }

   public void setMarketValue(Double marketValue) {
      this.marketValue = marketValue;
   }

   public Double getOpenPl() {
      return openPl;
   }

   public void setOpenPl(Double openPl) {
      this.openPl = openPl;
   }

   public Double getOptionLongValue() {
      return optionLongValue;
   }

   public void setOptionLongValue(Double optionLongValue) {
      this.optionLongValue = optionLongValue;
   }

   public Double getOptionRequirement() {
      return optionRequirement;
   }

   public void setOptionRequirement(Double optionRequirement) {
      this.optionRequirement = optionRequirement;
   }

   public Double getPendingOrdersCount() {
      return pendingOrdersCount;
   }

   public void setPendingOrdersCount(Double pendingOrdersCount) {
      this.pendingOrdersCount = pendingOrdersCount;
   }

   public Double getShortMarketValue() {
      return shortMarketValue;
   }

   public void setShortMarketValue(Double shortMarketValue) {
      this.shortMarketValue = shortMarketValue;
   }

   public Double getStockLongValue() {
      return stockLongValue;
   }

   public void setStockLongValue(Double stockLongValue) {
      this.stockLongValue = stockLongValue;
   }

   public Double getTotalCash() {
      return totalCash;
   }

   public void setTotalCash(Double totalCash) {
      this.totalCash = totalCash;
   }

   public Double getUnclearFunds() {
      return unclearFunds;
   }

   public void setUnclearFunds(Double unclearFunds) {
      this.unclearFunds = unclearFunds;
   }

   public Double getPendingCash() {
      return pendingCash;
   }

   public void setPendingCash(Double pendingCash) {
      this.pendingCash = pendingCash;
   }

   public CashBalance getCash() {
      return cash;
   }

   public void setCash(CashBalance cash) {
      this.cash = cash;
   }

   public MarginBalance getMargin() {
      return margin;
   }

   public void setMargin(MarginBalance margin) {
      this.margin = margin;
   }

   public PdtBalance getPdt() {
      return pdt;
   }

   public void setPdt(PdtBalance pdt) {
      this.pdt = pdt;
   }

   @Override
   public int hashCode() {
      return Objects.hash(accountNumber, accountType, cash, closePl, currentRequirement, equity, longMarketValue,
            margin, marketValue, openPl, optionLongValue, optionRequirement, optionShortValue, pdt, pendingCash,
            pendingOrdersCount, shortMarketValue, stockLongValue, totalCash, totalEquity, unclearFunds);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Balances other = (Balances) obj;
      return Objects.equals(accountNumber, other.accountNumber) && accountType == other.accountType
            && Objects.equals(cash, other.cash) && Objects.equals(closePl, other.closePl)
            && Objects.equals(currentRequirement, other.currentRequirement) && Objects.equals(equity, other.equity)
            && Objects.equals(longMarketValue, other.longMarketValue) && Objects.equals(margin, other.margin)
            && Objects.equals(marketValue, other.marketValue) && Objects.equals(openPl, other.openPl)
            && Objects.equals(optionLongValue, other.optionLongValue)
            && Objects.equals(optionRequirement, other.optionRequirement)
            && Objects.equals(optionShortValue, other.optionShortValue) && Objects.equals(pdt, other.pdt)
            && Objects.equals(pendingCash, other.pendingCash)
            && Objects.equals(pendingOrdersCount, other.pendingOrdersCount)
            && Objects.equals(shortMarketValue, other.shortMarketValue)
            && Objects.equals(stockLongValue, other.stockLongValue) && Objects.equals(totalCash, other.totalCash)
            && Objects.equals(totalEquity, other.totalEquity) && Objects.equals(unclearFunds, other.unclearFunds);
   }

   @Override
   public String toString() {
      return "Balances [optionShortValue=" + optionShortValue + ", totalEquity=" + totalEquity + ", accountNumber="
            + accountNumber + ", accountType=" + accountType + ", closePl=" + closePl + ", currentRequirement="
            + currentRequirement + ", equity=" + equity + ", longMarketValue=" + longMarketValue + ", marketValue="
            + marketValue + ", openPl=" + openPl + ", optionLongValue=" + optionLongValue + ", optionRequirement="
            + optionRequirement + ", pendingOrdersCount=" + pendingOrdersCount + ", shortMarketValue="
            + shortMarketValue + ", stockLongValue=" + stockLongValue + ", totalCash=" + totalCash + ", unclearFunds="
            + unclearFunds + ", pendingCash=" + pendingCash + ", cash=" + cash + ", margin=" + margin + ", pdt=" + pdt
            + "]";
   }

}
