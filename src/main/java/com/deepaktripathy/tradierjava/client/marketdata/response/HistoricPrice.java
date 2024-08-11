package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author deepak tripathy created on 05/24/2024
 */
public class HistoricPrice {
   
   @JsonProperty("date")
   private LocalDate date;
   
   @JsonProperty("open")
   private Double open;
   
   @JsonProperty("high")
   private Double high;
   
   @JsonProperty("low")
   private Double low;
   
   @JsonProperty("close")
   private Double close;
   
   @JsonProperty("volume")
   private Long volume;

   public LocalDate getDate() {
      return date;
   }

   public Double getOpen() {
      return open;
   }

   public Double getHigh() {
      return high;
   }

   public Double getLow() {
      return low;
   }

   public Double getClose() {
      return close;
   }

   public Long getVolume() {
      return volume;
   }

   @Override
   public int hashCode() {
      return Objects.hash(close, date, high, low, open, volume);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      HistoricPrice other = (HistoricPrice) obj;
      return Objects.equals(close, other.close) && Objects.equals(date, other.date) && Objects.equals(high, other.high)
            && Objects.equals(low, other.low) && Objects.equals(open, other.open)
            && Objects.equals(volume, other.volume);
   }

   @Override
   public String toString() {
      return "HistoricPrice [date=" + date + ", open=" + open + ", high=" + high + ", low=" + low + ", close=" + close
            + ", volume=" + volume + "]";
   }

}
