package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeSalesData {
   @JsonProperty("time") 
   Date time;
   @JsonProperty("timestamp") 
   int timestamp;
   @JsonProperty("price") 
   double price;
   @JsonProperty("open") 
   double myopen;
   @JsonProperty("high") 
   double high;
   @JsonProperty("low") 
   double low;
   @JsonProperty("close") 
   double close;
   @JsonProperty("volume") 
   int volume;
   @JsonProperty("vwap") 
   double vwap;

   public Date getTime() { 
      return this.time; 
   } 
   public void setTime(Date time) { 
      this.time = time; 
   } 

   public int getTimestamp() { 
      return this.timestamp; 
   } 
   public void setTimestamp(int timestamp) { 
      this.timestamp = timestamp; 
   } 

   public double getPrice() 
   { 
      return this.price; 
   } 
   public void setPrice(double price) { 
      this.price = price; 
   } 

   public double getMyopen() { 
      return this.myopen; 
   } 
   public void setMyopen(double myopen) { 
      this.myopen = myopen; 
   } 

   public double getHigh() { 
      return this.high; 
   } 
   public void setHigh(double high) { 
      this.high = high; 
   } 

   public double getLow() { 
      return this.low; 
   } 
   public void setLow(double low) { 
      this.low = low; 
   } 

   public double getClose() { 
      return this.close; 
   } 
   public void setClose(double close) { 
      this.close = close; 
   } 

   public int getVolume() { 
      return this.volume; 
   } 
   public void setVolume(int volume) { 
      this.volume = volume; 
   } 

   public double getVwap() { 
      return this.vwap; 
   } 
   public void setVwap(double vwap) { 
      this.vwap = vwap; 
   } 

   @Override
   public int hashCode() {
      return Objects.hash(close, high, low, myopen, price, time, timestamp, volume, vwap);
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
      return Double.doubleToLongBits(close) == Double.doubleToLongBits(other.close)
            && Double.doubleToLongBits(high) == Double.doubleToLongBits(other.high)
            && Double.doubleToLongBits(low) == Double.doubleToLongBits(other.low)
            && Double.doubleToLongBits(myopen) == Double.doubleToLongBits(other.myopen)
            && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
            && Objects.equals(time, other.time) && timestamp == other.timestamp && volume == other.volume
            && Double.doubleToLongBits(vwap) == Double.doubleToLongBits(other.vwap);
   }
   
   @Override
   public String toString() {
      return "TimeSalesData [time=" + time + ", timestamp=" + timestamp + ", price=" + price + ", myopen=" + myopen
            + ", high=" + high + ", low=" + low + ", close=" + close + ", volume=" + volume + ", vwap=" + vwap + "]";
   }
}
