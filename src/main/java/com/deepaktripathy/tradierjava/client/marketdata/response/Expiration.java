package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.time.LocalDate;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Expiration extends UnrecognizedFieldsCollector {

   @JsonProperty("date")
   private LocalDate date;
   
   @JsonProperty("contract_size")
   private int contractSize;
   
   @JsonProperty("expiration_type")
   private ExpirationType expirationType;

   @JsonProperty("strikes")
   private Strikes strikes;
}