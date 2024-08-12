package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.util.Objects;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines a calendar of matket days
 * 
 * @author deepak tripathy created on 06/26/2024
 *
 */
public class MarketCalendar extends UnrecognizedFieldsCollector {

   @JsonProperty("days")
   private CalendarDays days;

   @JsonProperty("month")
   private Integer month;

   @JsonProperty("year")
   private Integer year;

   public CalendarDays getDays() {
      return days;
   }

   public void setDays(CalendarDays days) {
      this.days = days;
   }

   public Integer getMonth() {
      return month;
   }

   public void setMonth(Integer month) {
      this.month = month;
   }

   public Integer getYear() {
      return year;
   }

   public void setYear(Integer year) {
      this.year = year;
   }

   @Override
   public int hashCode() {
      return Objects.hash(days, month, year);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      MarketCalendar other = (MarketCalendar) obj;
      return Objects.equals(days, other.days) && Objects.equals(month, other.month) && Objects.equals(year, other.year);
   }

   @Override
   public String toString() {
      return "MarketCalendar [days=" + days + ", month=" + month + ", year=" + year + "]";
   }

}
