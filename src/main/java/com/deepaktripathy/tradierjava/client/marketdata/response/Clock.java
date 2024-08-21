package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.time.LocalDate;
import java.time.LocalTime;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Clock extends UnrecognizedFieldsCollector {

   @JsonProperty("date")
   private LocalDate date;

   @JsonProperty("description")
   private String description;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
   @JsonProperty("next_change")
   private LocalTime nextChange;

   @JsonProperty("next_state")
   private State nextState;

   @JsonProperty("state")
   private State state;

   @JsonProperty("timestamp")
   private Long timestamp;
}
