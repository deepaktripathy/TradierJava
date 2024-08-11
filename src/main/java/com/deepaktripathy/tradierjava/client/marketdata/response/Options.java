package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */
public class Options {
   @JsonProperty("option")
   private List<Option> options;

   public Options() {
   }

   public List<Option> getOptions() {
      return this.options;
   }

   protected boolean canEqual(Object other) {
      return other instanceof Options;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;

      Options options1 = (Options) o;

      return options != null ? options.equals(options1.options) : options1.options == null;
   }

   @Override
   public int hashCode() {
      return options != null ? options.hashCode() : 0;
   }

   public String toString() {
      return "Options(options=" + this.getOptions() + ")";
   }
}