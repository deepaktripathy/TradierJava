package com.deepaktripathy.tradierjava.client.account.response.history;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Deepak Tripathy
 *
 */
public class TradeDetails {
    @JsonProperty("commission")
    private Double commission;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("quantity")
    private Double quantity;

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("trade_type")
    private String tradeType;

    public Double getCommission() { return commission; }
    public void setCommission(Double commission) { this.commission = commission; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public String getTradeType() { return tradeType; }
    public void setTradeType(String tradeType) { this.tradeType = tradeType; }
}
