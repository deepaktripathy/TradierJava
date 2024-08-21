package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.util.Date;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TimeSalesData extends UnrecognizedFieldsCollector {
   
   @JsonProperty("close") 
   private Double close;
   
   @JsonProperty("high") 
   private Double high;
   
   @JsonProperty("low") 
   private Double low;
   
   @JsonProperty("open") 
   private Double open;
   
   @JsonProperty("price") 
   private Double price;
   
   @JsonProperty("time") 
   private Date time;
   
   @JsonProperty("timestamp") 
   private Integer timestamp;
   
   @JsonProperty("volume") 
   private Integer volume;
   
   @JsonProperty("vwap") 
   private Double vwap;
}
