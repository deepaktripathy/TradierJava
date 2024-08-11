package com.tradierapi.tradierjava.client.marketdata.response;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tradierapi.tradierjava.model.response.UnrecognizedFieldsCollector;

/**
 * Defines a calendar of makret days
 * 
 * @author deepak tripathy created on 06/26/2024
 *
 */
public class MarketCalendar extends UnrecognizedFieldsCollector {

   @JsonProperty("month")
   private Integer month;

   @JsonProperty("year")
   private Integer year;

   @JsonProperty("days")
   private CalendarDays days;

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

   public CalendarDays getDays() {
      return days;
   }

   public void setDays(CalendarDays days) {
      this.days = days;
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
      return "Calendar [month=" + month + ", year=" + year + ", days=" + days + "]";
   }

}
