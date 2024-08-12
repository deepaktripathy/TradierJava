package com.deepaktripathy.tradierjava.client.fundamental.response.financials;

import java.util.List;

public class FinancialsResponse {
   private List<FinancialsRoot> financials;

   public List<FinancialsRoot> getFinancials() {
      return financials;
   }

   public void setFinancials(List<FinancialsRoot> financials) {
      this.financials = financials;
   }

   @Override
   public String toString() {
      return "FinancialsResponse [financials=" + financials + "]";
   }
}
