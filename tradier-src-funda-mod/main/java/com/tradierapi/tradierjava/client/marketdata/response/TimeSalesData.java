package com.tradierapi.tradierjava.client.marketdata.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tradierapi.tradierjava.model.response.UnrecognizedFieldsCollector;

public class TimeSalesData extends UnrecognizedFieldsCollector {
   @JsonProperty("time") 
   public Date getTime() { 
      return this.time; } 
   public void setTime(Date time) { 
      this.time = time; } 
   Date time;
   @JsonProperty("timestamp") 
   public int getTimestamp() { 
      return this.timestamp; } 
   public void setTimestamp(int timestamp) { 
      this.timestamp = timestamp; } 
   int timestamp;
   @JsonProperty("price") 
   public double getPrice() { 
      return this.price; } 
   public void setPrice(double price) { 
      this.price = price; } 
   double price;
   @JsonProperty("open") 
   public double getMyopen() { 
      return this.myopen; } 
   public void setMyopen(double myopen) { 
      this.myopen = myopen; } 
   double myopen;
   @JsonProperty("high") 
   public double getHigh() { 
      return this.high; } 
   public void setHigh(double high) { 
      this.high = high; } 
   double high;
   @JsonProperty("low") 
   public double getLow() { 
      return this.low; } 
   public void setLow(double low) { 
      this.low = low; } 
   double low;
   @JsonProperty("close") 
   public double getClose() { 
      return this.close; } 
   public void setClose(double close) { 
      this.close = close; } 
   double close;
   @JsonProperty("volume") 
   public int getVolume() { 
      return this.volume; } 
   public void setVolume(int volume) { 
      this.volume = volume; } 
   int volume;
   @JsonProperty("vwap") 
   public double getVwap() { 
      return this.vwap; } 
   public void setVwap(double vwap) { 
      this.vwap = vwap; } 
   double vwap;
   
   @Override
   public String toString() {
      return "TimeSalesData [time=" + time + ", timestamp=" + timestamp + ", price=" + price + ", myopen=" + myopen
            + ", high=" + high + ", low=" + low + ", close=" + close + ", volume=" + volume + ", vwap=" + vwap + "]";
   }

   
}
