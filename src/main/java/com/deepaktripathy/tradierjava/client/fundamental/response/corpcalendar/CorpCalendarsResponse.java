package com.deepaktripathy.tradierjava.client.fundamental.response.corpcalendar;

import java.util.List;

public class CorpCalendarsResponse {
   private List<CalendarRoot> calendars;

   public List<CalendarRoot> getCalendars() {
      return calendars;
   }

   public void setCalendars(List<CalendarRoot> calendars) {
      this.calendars = calendars;
   }

   @Override
   public String toString() {
      return "CorpCalendarsResponse [calendars=" + calendars + "]";
   }
   
}
