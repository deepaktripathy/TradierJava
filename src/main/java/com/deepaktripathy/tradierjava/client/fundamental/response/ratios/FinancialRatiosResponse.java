package com.deepaktripathy.tradierjava.client.fundamental.response.ratios;

import java.util.List;

public class FinancialRatiosResponse {
   private List<RatiosRoot> ratios;

   public List<RatiosRoot> getRatios() {
      return ratios;
   }

   public void setRatios(List<RatiosRoot> ratios) {
      this.ratios = ratios;
   }

   @Override
   public String toString() {
      return "FinancialRatiosResponse [ratios=" + ratios + "]";
   }

}
