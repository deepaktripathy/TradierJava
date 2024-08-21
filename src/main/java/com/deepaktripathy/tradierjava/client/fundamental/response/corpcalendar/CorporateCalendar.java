package com.deepaktripathy.tradierjava.client.fundamental.response.corpcalendar;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CorporateCalendar extends UnrecognizedFieldsCollector {

   @JsonProperty("begin_date_time") 
   private String beginDateTime;
   
   @JsonProperty("company_id") 
   private String companyId;
   
   @JsonProperty("end_date_time") 
   private String endDateTime;
   
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
   
   @JsonProperty("event_type") 
   private Integer eventType;
   
   @JsonProperty("time_zone") 
   private String timeZone;
}