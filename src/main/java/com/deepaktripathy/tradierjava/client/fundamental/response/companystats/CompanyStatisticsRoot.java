package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CompanyStatisticsRoot{
   
   @JsonProperty("error")
   private String error;

   @JsonProperty("request")
   private String request;

   @JsonProperty("results")
   private List<Result> results;

   @JsonProperty("type")
   private String type;
}

















