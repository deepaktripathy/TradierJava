package com.deepaktripathy.tradierjava.client.fundamental.response.corpcalendar;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Result extends UnrecognizedFieldsCollector {
   @JsonProperty("type") 
   private String type;

   @JsonProperty("id") 
   private String id;
   
   @JsonProperty("tables") 
   private Tables tables;

   @Override
   public String toString() {
      return "Result [type=" + type + ", id=" + id + ", tables=" + tables + "]";
   }

}