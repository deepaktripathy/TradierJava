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
   
   @JsonProperty("delta")
   private Double delta;
   
   @JsonProperty("gamma")
   private Double gamma;
   
   @JsonProperty("theta")
   private Double theta;
   
   @JsonProperty("vega")
   private Double vega;
   
   @JsonProperty("rho")
   private Double rho;
   
   @JsonProperty("phi")
   private Double phi;

   @JsonProperty("bid_iv")
   private Double bidIv;
   
   @JsonProperty("mid_iv")
   private Double midIv;
   
   @JsonProperty("ask_iv")
   private Double askIv;
   
   @JsonProperty("smv_vol")
   private Double smvVol;
   
   @JsonProperty("updated_at")
   private String updatedAt;// TODO: convert it to a LocalDate?
}
