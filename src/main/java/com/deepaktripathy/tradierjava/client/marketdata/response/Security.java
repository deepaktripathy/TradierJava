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
public class Security extends UnrecognizedFieldsCollector {

   @JsonProperty("symbol")
   private String symbol;

   @JsonProperty("exchange")
   private String exchange;

   @JsonProperty("type")
   private String type;

   @JsonProperty("description")
   private String description;
}
