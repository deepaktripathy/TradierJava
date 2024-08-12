package com.deepaktripathy.tradierjava.client.fundamental.response.ratios; 
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty; 

public class AlphaBeta extends UnrecognizedFieldsCollector {
   @JsonProperty("period_36m") 
   private Period36m period36Mo;

   @JsonProperty("period_48m") 
   private Period48m period48Mo;

   @JsonProperty("period_60m") 
   private Period60m period60Mo;

   @JsonProperty("period_120m") 
   private Period120m period120Mo;

   @Override
   public String toString() {
      return "AlphaBeta [period120Mo=" + period120Mo + ", period36Mo=" + period36Mo + ", period48Mo=" + period48Mo
            + ", period60Mo=" + period60Mo + "]";
   }
}
