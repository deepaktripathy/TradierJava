package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Result extends UnrecognizedFieldsCollector {
   
   @JsonProperty("type")
   private String type;

   @JsonProperty("id")
   private String id;

   @JsonProperty("tables")
   Tables tables;
}