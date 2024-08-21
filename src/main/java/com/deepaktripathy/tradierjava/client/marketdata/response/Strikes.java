package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Strikes {
   
   @JsonProperty("strike")
   private List<Double> strikes;

   public Strikes() {
   }

   public List<Double> getStrikes() {
      return this.strikes;
   }

   protected boolean canEqual(Object other) {
      return other instanceof Strikes;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;

      Strikes strikes1 = (Strikes) o;

      return strikes != null ? strikes.equals(strikes1.strikes) : strikes1.strikes == null;
   }

   @Override
   public int hashCode() {
      return strikes != null ? strikes.hashCode() : 0;
   }

   public String toString() {
      return "Strikes(strikes=" + this.getStrikes() + ")";
   }
}