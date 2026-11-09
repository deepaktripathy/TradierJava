package com.deepaktripathy.tradierjava.client.account.response.history;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Deepak Tripathy
 *
 */
// history container
public class HistoryContainer {
    @JsonProperty("event")
    private List<HistoryEvent> events;

    public List<HistoryEvent> getEvents() { return events; }
    public void setEvents(List<HistoryEvent> events) { this.events = events; }
}