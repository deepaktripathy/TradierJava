package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */

/*
 * result contains a 'unmatched_symbols' block if symbols are NOT valid.
 * Temporarily skip the unmatched_symbols. Later on get them back.
 */
@JsonIgnoreProperties({ "unmatched_symbols" })
public class Quotes {
   @JsonProperty("quote")
   private List<Quote> quotes;

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