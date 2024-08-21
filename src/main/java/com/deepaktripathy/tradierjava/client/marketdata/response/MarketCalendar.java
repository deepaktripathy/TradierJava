package com.deepaktripathy.tradierjava.client.marketdata.response;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

/**
 * Defines a calendar of matket days
 * 
 * @author deepak tripathy created on 06/26/2024
 *
 */

@Getter
@ToString
public class MarketCalendar extends UnrecognizedFieldsCollector {

   @JsonProperty("days")
   private CalendarDays days;

   @JsonProperty("month")
   private Integer month;

   @JsonProperty("year")
   private Integer year;
}
