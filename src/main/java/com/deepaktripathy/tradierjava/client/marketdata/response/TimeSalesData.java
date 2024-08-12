package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.util.Date;
import java.util.Objects;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeSalesData extends UnrecognizedFieldsCollector {
   
   @JsonProperty("time") 
   private Date time;
   
   @JsonProperty("timestamp") 
   private Integer timestamp;
   
   @JsonProperty("price") 
   private Double price;
   
   @JsonProperty("open") 
   private Double open;
   
   @JsonProperty("high") 
   private Double high;
   
   @JsonProperty("low") 
   private Double low;
   
   @JsonProperty("close") 
   private Double close;
   
   @JsonProperty("volume") 
   private Integer volume;
   
   @JsonProperty("vwap") 
   private Double vwap;

   public Date getTime() { 
      return this.time; 
   } 
   public void setTime(Date time) { 
      this.time = time; 
   } 

   public Integer getTimestamp() { 
      return this.timestamp; 
   } 
   public void setTimestamp(Integer timestamp) { 
      this.timestamp = timestamp; 
   } 

   public Double getPrice() 
   { 
      return this.price; 
   } 
   public void setPrice(Double price) { 
      this.price = price; 
   } 

   public Double getOpen() { 
      return this.open; 
   } 
   public void setOpen(Double open) { 
      this.open = open; 
   } 

   public Double getHigh() { 
      return this.high; 
   } 
   public void setHigh(Double high) { 
      this.high = high; 
   } 

   public Double getLow() { 
      return this.low; 
   } 
   public void setLow(Double low) { 
      this.low = low; 
   } 

   public Double getClose() { 
      return this.close; 
   } 
   public void setClose(Double close) { 
      this.close = close; 
   } 

   public Integer getVolume() { 
      return this.volume; 
   } 
   public void setVolume(Integer volume) { 
      this.volume = volume; 
   } 

   public Double getVwap() { 
      return this.vwap; 
   } 
   public void setVwap(Double vwap) { 
      this.vwap = vwap; 
   }
   
   @Override
   public int hashCode() {
      return Objects.hash(close, high, low, open, price, time, timestamp, volume, vwap);
   }
   
   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      TimeSalesData other = (TimeSalesData) obj;
      return Objects.equals(close, other.close) && Objects.equals(high, other.high) && Objects.equals(low, other.low)
            && Objects.equals(open, other.open) && Objects.equals(price, other.price)
            && Objects.equals(time, other.time) && Objects.equals(timestamp, other.timestamp)
            && Objects.equals(volume, other.volume) && Objects.equals(vwap, other.vwap);
   }
   
   @Override
   public String toString() {
      return "TimeSalesData [time=" + time + ", timestamp=" + timestamp + ", price=" + price + ", open=" + open
            + ", high=" + high + ", low=" + low + ", close=" + close + ", volume=" + volume + ", vwap=" + vwap + "]";
   } 

   
}
