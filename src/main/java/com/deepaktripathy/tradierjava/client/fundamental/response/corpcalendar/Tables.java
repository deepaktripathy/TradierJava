package com.deepaktripathy.tradierjava.client.fundamental.response.corpcalendar;

import java.util.List;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tables extends UnrecognizedFieldsCollector {
   @JsonProperty("corporate_calendars") 
   private List<CorporateCalendar> corporateCalendars;

   @Override
   public String toString() {
      return "Tables [corporateCalendars=" + corporateCalendars + "]";
   }
   
}