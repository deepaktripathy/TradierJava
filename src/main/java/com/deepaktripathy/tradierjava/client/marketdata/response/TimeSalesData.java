package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.time.LocalDateTime;

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
   private LocalDateTime time;
   
   @JsonProperty("timestamp") 
   private Long timestamp;
   
   @JsonProperty("volume") 
   private Integer volume;
   
   @JsonProperty("vwap") 
   private Double vwap;
}
