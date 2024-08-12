package com.deepaktripathy.tradierjava.client.fundamental.response.statistics;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Period90d extends UnrecognizedFieldsCollector {
   @JsonProperty("share_class_id") 
   private String shareClassId;
   
   @JsonProperty("as_of_date") 
   private String asOfDate;
   
   @JsonProperty("period") 
   private String period;
   
   @JsonProperty("average_volume") 
   private Double averageVolume;

   @Override
   public String toString() {
      return "Period90d [shareClassId=" + shareClassId + ", asOfDate=" + asOfDate + ", period=" + period
            + ", averageVolume=" + averageVolume + "]";
   }

}