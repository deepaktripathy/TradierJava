package com.deepaktripathy.tradierjava.client.fundamental.response.ratios;

import java.util.List;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString; 

@Getter
@ToString
public class Tables extends UnrecognizedFieldsCollector {

   @JsonProperty("operation_ratios_restate") 
   private List<OperationRatiosRestate> operationRatiosRestate;

   @JsonProperty("operation_ratios_a_o_r") 
   private List<OperationRatiosAOR> operationRatiosAOR;

   @JsonProperty("earning_ratios_restate") 
   private List<EarningRatiosRestate> earningRatiosRestate;

   @JsonProperty("valuation_ratios") 
   private ValuationRatios valuationRatios;

   @JsonProperty("alpha_beta") 
   private AlphaBeta alphaBeta;
}
