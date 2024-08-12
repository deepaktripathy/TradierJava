package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.util.List;

import com.deepaktripathy.tradierjava.client.model.response.UnmatchedSymbols;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */
public class Quotes {
   
   @JsonProperty("quote")
   private List<Quote> quotes;

   @JsonProperty("unmatched_symbols")
   private UnmatchedSymbols unmatchedSymbols;

   public Quotes() {
   }

   public List<Quote> getQuotes() {
      return this.quotes;
   }

   protected boolean canEqual(Object other) {
      return other instanceof Quotes;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;

      Quotes quotes1 = (Quotes) o;

      return quotes != null ? quotes.equals(quotes1.quotes) : quotes1.quotes == null;
   }

   @Override
   public int hashCode() {
      return quotes != null ? quotes.hashCode() : 0;
   }

   public String toString() {
      return "Quotes(quotes=" + this.getQuotes() + ")";
   }
}