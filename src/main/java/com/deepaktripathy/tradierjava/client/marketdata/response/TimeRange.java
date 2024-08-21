package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.time.LocalTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines a time range without any ties to date/day. Associated with market
 * hours:minute.
 * 
 * @author deepak tripathy created on 06/26/2024
 *
 */
public class TimeRange {
   
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
   @JsonProperty("end")
   private LocalTime end;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
   @JsonProperty("start")
   private LocalTime start;

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      TimeRange other = (TimeRange) obj;
      return Objects.equals(end, other.end) && Objects.equals(start, other.start);
   }

   public LocalTime getEnd() {
      return end;
   }

   public LocalTime getStart() {
      return start;
   }

   @Override
   public int hashCode() {
      return Objects.hash(end, start);
   }

   public void setEnd(LocalTime end) {
      this.end = end;
   }

   public void setStart(LocalTime start) {
      this.start = start;
   }

   @Override
   public String toString() {
      return "TimeRange [start=" + start + ", end=" + end + "]";
   }

}
