package com.deepaktripathy.tradierjava.client.fundamental.response.corpcalendar;

import java.util.List;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CalendarRoot extends UnrecognizedFieldsCollector {

   @JsonProperty("request") 
   private String request;
   
   @JsonProperty("type") 
   private String type;

   @JsonProperty("results") 
   private List<Result> results;
   
   @JsonProperty("error") 
   private String error;
}