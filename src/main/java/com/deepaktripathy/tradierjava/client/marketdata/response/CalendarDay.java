package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author deepak tripathy created on 06/26/2024
 *
 */
public class CalendarDay {
   
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
   @JsonProperty("date")
   private LocalDate date;

   @JsonProperty("status")
   private MarketStatus status;

   @JsonProperty("description")
   private String description;

   @JsonProperty("premarket")
   private TimeRange premarket;

   @JsonProperty("open")
   private TimeRange open;

   @JsonProperty("postmarket")
   private TimeRange postmarket;

   public LocalDate getDate() {
      return date;
   }

   public void setDate(LocalDate date) {
      this.date = date;
   }

   public MarketStatus getStatus() {
      return status;
   }

   public void setStatus(MarketStatus status) {
      this.status = status;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public TimeRange getPremarket() {
      return premarket;
   }

   public void setPremarket(TimeRange premarket) {
      this.premarket = premarket;
   }

   public TimeRange getOpen() {
      return open;
   }

   public void setOpen(TimeRange open) {
      this.open = open;
   }

   public TimeRange getPostmarket() {
      return postmarket;
   }

   public void setPostmarket(TimeRange postmarket) {
      this.postmarket = postmarket;
   }

   @Override
   public int hashCode() {
      return Objects.hash(date, description, open, postmarket, premarket, status);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      CalendarDay other = (CalendarDay) obj;
      return Objects.equals(date, other.date) && Objects.equals(description, other.description)
            && Objects.equals(open, other.open) && Objects.equals(postmarket, other.postmarket)
            && Objects.equals(premarket, other.premarket) && status == other.status;
   }

   @Override
   public String toString() {
      return "CalendarDay [date=" + date + ", status=" + status + ", description=" + description + ", premarket="
            + premarket + ", open=" + open + ", postmarket=" + postmarket + "]";
   }

}
