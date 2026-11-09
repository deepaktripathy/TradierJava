package com.deepaktripathy.tradierjava.client.account.response.history;

import com.deepaktripathy.tradierjava.client.account.request.EventType;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This may contain one/more these types.
 * trade, option, ach, wire, dividend, fee, tax, journal, check, transfer, adjustment.
 * 
 * @author Deepak Tripathy
 *
 */
public class HistoryEvent {
    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("date")
    private String date;

    @JsonProperty("type")
    private EventType type;

    @JsonProperty("trade")
    private TradeDetails trade;

    @JsonProperty("adjustment")
    private AdjustmentDetails adjustment;

    @JsonProperty("option")
    private OptionDetails option;

    @JsonProperty("journal")
    private JournalDetails journal;

    @JsonProperty("transfer")
    private TransferDetails transfer;

    @JsonProperty("ach")
    private AchDetails ach;

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public EventType getType() { return type; }
    public void setType(EventType type) { this.type = type; }

    public TradeDetails getTrade() { return trade; }
    public void setTrade(TradeDetails trade) { this.trade = trade; }

    public AdjustmentDetails getAdjustment() { return adjustment; }
    public void setAdjustment(AdjustmentDetails adjustment) { this.adjustment = adjustment; }

    public OptionDetails getOption() { return option; }
    public void setOption(OptionDetails option) { this.option = option; }

    public JournalDetails getJournal() { return journal; }
    public void setJournal(JournalDetails journal) { this.journal = journal; }

    public TransferDetails getTransfer() { return transfer; }
    public void setTransfer(TransferDetails transfer) { this.transfer = transfer; }
    
    public AchDetails getAch() { return ach; }
    public void setAch(AchDetails ach) { this.ach = ach; }

    //missing these since json signature is not available from Tradier.
    //types: ach, wire, dividend, fee, tax, check 
}
