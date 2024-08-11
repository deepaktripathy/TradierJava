package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Clock {

   @JsonProperty("date")
   private LocalDate date;

   @JsonProperty("description")
   private String description;

   @JsonProperty("state")
   private State state;

   @JsonProperty("timestamp")
   private Long timestamp;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
   @JsonProperty("next_change")
   private LocalTime nextChange;

   @JsonProperty("next_state")
   private State nextState;

   public LocalDate getDate() {
      return date;
   }

   public void setDate(LocalDate date) {
      this.date = date;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public State getState() {
      return state;
   }

   public void setState(State state) {
      this.state = state;
   }

   public Long getTimestamp() {
      return timestamp;
   }

   public void setTimestamp(Long timestamp) {
      this.timestamp = timestamp;
   }

   public LocalTime getNextChange() {
      return nextChange;
   }

   public void setNextChange(LocalTime nextChange) {
      this.nextChange = nextChange;
   }

   public State getNextState() {
      return nextState;
   }

   public void setNextState(State nextState) {
      this.nextState = nextState;
   }

   @Override
   public int hashCode() {
      return Objects.hash(date, description, nextChange, nextState, state, timestamp);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Clock other = (Clock) obj;
      return Objects.equals(date, other.date) && Objects.equals(description, other.description)
            && Objects.equals(nextChange, other.nextChange) && nextState == other.nextState && state == other.state
            && Objects.equals(timestamp, other.timestamp);
   }

   @Override
   public String toString() {
      return "Clock [date=" + date + ", description=" + description + ", state=" + state + ", timestamp=" + timestamp
            + ", nextChange=" + nextChange + ", nextState=" + nextState + "]";
   }

}
