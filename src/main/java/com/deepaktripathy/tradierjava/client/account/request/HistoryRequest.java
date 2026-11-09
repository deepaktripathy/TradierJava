package com.deepaktripathy.tradierjava.client.account.request;

/**
 * @author Deepak Tripathy
 *
 */
public class HistoryRequest {

    private Integer page = 0;
    private Integer limit;
    // Options: trade, option, ach, wire, dividend, fee, tax, journal, check, transfer, adjustment
    private EventType historyType; 

    public HistoryRequest() {}

    public HistoryRequest(Integer page, Integer limit, EventType historyType) {
        this.page = page;
        this.limit = limit;
        this.historyType = historyType;
    }

    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }

    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }

    public EventType getHistoryType() { return historyType; }
    public void setHistoryType(EventType historyType) { this.historyType = historyType; }
}