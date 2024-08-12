package com.deepaktripathy.tradierjava.client.fundamental.response.dividend;

import java.util.List;

public class DividendsResponse {

   private List<DividendRoot> dividends;

   public List<DividendRoot> getDividends() {
      return dividends;
   }

   public void setDividends(List<DividendRoot> dividends) {
      this.dividends = dividends;
   }

   @Override
   public String toString() {
      return "DividendsResponse [dividends=" + dividends + "]";
   }
   
   
}
