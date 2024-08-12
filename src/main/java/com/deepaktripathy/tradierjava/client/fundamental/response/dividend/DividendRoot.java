package com.deepaktripathy.tradierjava.client.fundamental.response.dividend;

import java.util.List;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DividendRoot extends UnrecognizedFieldsCollector {
   @JsonProperty("request") 
   private String request;
   
   @JsonProperty("type") 
   private String type;
   
   @JsonProperty("results") 
   private List<Result> results;

   @JsonProperty("error") 
   private String error;

   @Override
   public String toString() {
      return "DividendRoot [request=" + request + ", type=" + type + ", results=" + results + ", error=" + error + "]";
   }
   
}
