package com.deepaktripathy.tradierjava.client.account.response;

import com.deepaktripathy.tradierjava.client.account.response.history.HistoryContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Deepak Tripathy
 *
 */
public class HistoryResponse {

   @JsonProperty("history")
   private HistoryContainer history;

   public HistoryContainer getHistory() { return history; }
   public void setHistory(HistoryContainer history) { this.history = history; }

}
