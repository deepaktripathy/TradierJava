package com.deepaktripathy.tradierjava.client.fundamental.response.corpcalendar;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CorporateCalendar extends UnrecognizedFieldsCollector {
   @JsonProperty("company_id") 
   private String companyId;
   
   @JsonProperty("begin_date_time") 
   private String beginDateTime;
   
   @JsonProperty("end_date_time") 
   private String endDateTime;
   
   @JsonProperty("event_type") 
   private Integer eventType;
   
   @JsonProperty("estimated_date_for_next_event") 
   private String estimatedDateForNextEvent;
   
   @JsonProperty("event") 
   private String event;
   
   @JsonProperty("event_address") 
   private String eventAddress;
   
   @JsonProperty("event_fiscal_year") 
   private Integer eventFiscalYear;
   
   @JsonProperty("event_status") 
   private String eventStatus;
   
   @JsonProperty("time_zone") 
   private String timeZone;

   
   
}