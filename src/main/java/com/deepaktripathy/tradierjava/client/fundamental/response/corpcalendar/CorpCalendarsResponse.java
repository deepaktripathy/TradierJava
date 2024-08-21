package com.deepaktripathy.tradierjava.client.fundamental.response.corpcalendar;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CorpCalendarsResponse {

   private List<CalendarRoot> calendars;
}
