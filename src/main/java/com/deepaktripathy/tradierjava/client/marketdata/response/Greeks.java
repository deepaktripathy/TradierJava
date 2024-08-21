package com.deepaktripathy.tradierjava.client.marketdata.response;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

/**
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */

@Getter
@ToString
public class Greeks extends UnrecognizedFieldsCollector {
   
   @JsonProperty("ask_iv")
   private Double askIv;
   
   @JsonProperty("bid_iv")
   private Double bidIv;
   
   @JsonProperty("delta")
   private Double delta;
   
   @JsonProperty("gamma")
   private Double gamma;
   
   @JsonProperty("mid_iv")
   private Double midIv;
   
   @JsonProperty("phi")
   private Double phi;

   @JsonProperty("rho")
   private Double rho;
   
   @JsonProperty("smv_vol")
   private Double smvVol;
   
   @JsonProperty("theta")
   private Double theta;
   
   @JsonProperty("updated_at")
   private String updatedAt;
   
   @JsonProperty("vega")
   private Double vega;
}
