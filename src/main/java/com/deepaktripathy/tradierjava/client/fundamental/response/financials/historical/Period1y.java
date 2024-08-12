package com.deepaktripathy.tradierjava.client.fundamental.response.financials.historical;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Period1y extends UnrecognizedFieldsCollector {
   @JsonProperty("as_of_date") 
   private String asOfDate;

   @JsonProperty("period") 
   private String period;
   
   @JsonProperty("total_return")
   private Double totalReturn;
   
   @JsonProperty("share_class_id")
   private String shareClassId;
}