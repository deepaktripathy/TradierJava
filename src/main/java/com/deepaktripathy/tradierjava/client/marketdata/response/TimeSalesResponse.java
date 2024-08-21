package com.deepaktripathy.tradierjava.client.marketdata.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TimeSalesResponse {
   
   @JsonProperty("series") 
   private Series series;
}
