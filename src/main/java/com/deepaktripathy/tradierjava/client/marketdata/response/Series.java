package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Series {
   
   @JsonProperty("data") 
   private List<TimeSalesData> data;
}
