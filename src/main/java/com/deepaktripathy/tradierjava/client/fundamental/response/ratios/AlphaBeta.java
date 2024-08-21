package com.deepaktripathy.tradierjava.client.fundamental.response.ratios; 

import com.deepaktripathy.tradierjava.client.fundamental.response.ratios.alphabeta.Period120m;
import com.deepaktripathy.tradierjava.client.fundamental.response.ratios.alphabeta.Period36m;
import com.deepaktripathy.tradierjava.client.fundamental.response.ratios.alphabeta.Period48m;
import com.deepaktripathy.tradierjava.client.fundamental.response.ratios.alphabeta.Period60m;
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AlphaBeta extends UnrecognizedFieldsCollector {
   
   @JsonProperty("period_36m") 
   private Period36m period36Mo;

   @JsonProperty("period_48m") 
   private Period48m period48Mo;

   @JsonProperty("period_60m") 
   private Period60m period60Mo;

   @JsonProperty("period_120m") 
   private Period120m period120Mo;
}
