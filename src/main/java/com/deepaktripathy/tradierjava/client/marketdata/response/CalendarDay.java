package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.time.LocalDate;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

/**
 * 
 * @author deepak tripathy created on 06/26/2024
 *
 */

@Getter
@ToString
public class CalendarDay extends UnrecognizedFieldsCollector {
   
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
   @JsonProperty("date")
   private LocalDate date;

   @JsonProperty("status")
   private MarketStatus status;

   @JsonProperty("description")
   private String description;

   @JsonProperty("premarket")
   private TimeRange premarket;

   @JsonProperty("open")
   private TimeRange open;

   @JsonProperty("postmarket")
   private TimeRange postmarket;
}
