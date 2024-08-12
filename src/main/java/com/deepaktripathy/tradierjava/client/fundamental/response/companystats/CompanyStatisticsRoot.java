package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyStatisticsRoot{
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
      return "CompanyStatisticsRoot [request=" + request + ", type=" + type + ", results=" + results + ", error="
            + error + "]";
   }

}

















