package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.time.LocalDate;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

/**
 * @author deepak tripathy created on 05/24/2024
 */

@Getter
@ToString
public class HistoricPrice extends UnrecognizedFieldsCollector {
   
   @JsonProperty("date")
   private LocalDate date;
   
   @JsonProperty("open")
   private Double open;
   
   @JsonProperty("high")
   private Double high;
   
   @JsonProperty("low")
   private Double low;
   
   @JsonProperty("close")
   private Double close;
   
   @JsonProperty("volume")
   private Long volume;
}
