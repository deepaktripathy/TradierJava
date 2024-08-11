package com.tradierapi.tradierjava.client.marketdata.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeSalesResponse {
   @JsonProperty("series") 
   Series series;
   
   public Series getSeries() { 
      return this.series; } 
   public void setSeries(Series series) { 
      this.series = series; } 
   
   @Override
   public String toString() {
      return "TimeSalesResponse [series=" + series + "]";
   }
}
