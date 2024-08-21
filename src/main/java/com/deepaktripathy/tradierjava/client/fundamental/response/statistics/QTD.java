package com.deepaktripathy.tradierjava.client.fundamental.response.statistics;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class QTD extends UnrecognizedFieldsCollector {

   @JsonProperty("as_of_date") 
   private String asOfDate;
   
   @JsonProperty("period") 
   private String period;
   
   @JsonProperty("share_class_id") 
   private String shareClassId;
   
   @JsonProperty("total_return") 
   private Double totalReturn;
}
