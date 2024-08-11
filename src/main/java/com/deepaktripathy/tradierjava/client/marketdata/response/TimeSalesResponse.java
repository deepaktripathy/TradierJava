package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeSalesResponse {
   @JsonProperty("series") 
   Series series;

   public Series getSeries() { 
      return this.series; 
   } 
   public void setSeries(Series series) { 
      this.series = series; 
   } 

   @Override
   public int hashCode() {
      return Objects.hash(series);
   }
   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      TimeSalesResponse other = (TimeSalesResponse) obj;
      return Objects.equals(series, other.series);
   }

   @Override
   public String toString() {
      return "TimeSalesResponse [series=" + series + "]";
   }
}
