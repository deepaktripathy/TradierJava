package com.tradierapi.tradierjava.model;

import java.beans.ConstructorProperties;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author deepak tripathy created on 05/24/2024
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("exch")
    private String exchange;
    
    @JsonProperty("type")
    private String securityType;
    @JsonProperty("change")
    private double change;
    @JsonProperty("change_percentage")
    private double percentChange;
    @JsonProperty("volume")
    private int volume;
    @JsonProperty("average_volume")
    private int averageVolume;
    @JsonProperty("last_volume")
    private int lastVolume;
    @JsonProperty("trade_date")
    private long tradeDate;
    @JsonProperty("open")
    private double openPrice;
    @JsonProperty("high")
    private double highPrice;
    @JsonProperty("low")
    private double lowPrice;
    @JsonProperty("close")
    private double closePrice;
    @JsonProperty("prevclose")
    private double previousClosePrice;
    @JsonProperty("week_52_high")
    private double fiscalYearHigh;
    @JsonProperty("week_52_low")
    private double fiscalYearLow;
    @JsonProperty("bid")
    private double bid;
    @JsonProperty("bidsize")
    private int bidSize;
    @JsonProperty("bidexch")
    private String bidExchange;
    @JsonProperty("bid_date")
    private long bidDate;
    @JsonProperty("ask")
    private double ask;
    @JsonProperty("asksize")
    private int askSize;
    @JsonProperty("askexch")
    private String askExchange;
    @JsonProperty("ask_date")
    private long askDate;
    @JsonProperty("open_interest")
    private int openInterest;
    @JsonProperty("underlying")
    private String underlying;
    @JsonProperty("strike")
    private double strike;
    @JsonProperty("contract_size")
    private int contractSize;
    @JsonProperty("expiration_date")
    private String expirationDate;
    @JsonProperty("expiration_type")
    private String expirationType;
    @JsonProperty("option_type")
    private String optionType;
    
    @JsonProperty("root_symbol")
    private String rootSymbol;

    @JsonProperty("greeks")
    private Greeks greeks;

    public long getEpochMillisExpirationDate() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.parse(this.expirationDate).getTime();
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getDescription() {
        return this.description;
    }

    public String getExchange() {
        return this.exchange;
    }

    public String getSecurityType() {
        return this.securityType;
    }

    public double getChange() {
        return this.change;
    }

    public double getPercentChange() {
        return this.percentChange;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getAverageVolume() {
        return this.averageVolume;
    }

    public int getLastVolume() {
        return this.lastVolume;
    }

    /** Milliseconds since Epoch */
    public long getTradeDate() {
        return this.tradeDate;
    }

    public double getOpenPrice() {
        return this.openPrice;
    }

    public double getHighPrice() {
        return this.highPrice;
    }

    public double getLowPrice() {
        return this.lowPrice;
    }

    public double getClosePrice() {
        return this.closePrice;
    }

    public double getPreviousClosePrice() {
        return this.previousClosePrice;
    }

    public double getFiscalYearHigh() {
        return this.fiscalYearHigh;
    }

    public double getFiscalYearLow() {
        return this.fiscalYearLow;
    }

    public double getBid() {
        return this.bid;
    }

    public int getBidSize() {
        return this.bidSize;
    }

    public String getBidExchange() {
        return this.bidExchange;
    }

    /** Milliseconds since Epoch */
    public long getBidDate() {
        return this.bidDate;
    }

    public double getAsk() {
        return this.ask;
    }

    public int getAskSize() {
        return this.askSize;
    }

    public String getAskExchange() {
        return this.askExchange;
    }

    /** Milliseconds since Epoch */
    public long getAskDate() {
        return this.askDate;
    }

    public int getOpenInterest() {
        return this.openInterest;
    }

    public String getUnderlying() {
        return this.underlying;
    }

    public double getStrike() {
        return this.strike;
    }

    public int getContractSize() {
        return this.contractSize;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public String getExpirationType() {
        return this.expirationType;
    }

    public String getOptionType() {
        return this.optionType;
    }

    public Greeks getGreeks() {
        return greeks;
    }


    protected boolean canEqual(Object other) {
        return other instanceof Quote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quote quote = (Quote) o;

        if (Double.compare(quote.change, change) != 0) return false;
        if (Double.compare(quote.percentChange, percentChange) != 0) return false;
        if (volume != quote.volume) return false;
        if (averageVolume != quote.averageVolume) return false;
        if (lastVolume != quote.lastVolume) return false;
        if (tradeDate != quote.tradeDate) return false;
        if (Double.compare(quote.openPrice, openPrice) != 0) return false;
        if (Double.compare(quote.highPrice, highPrice) != 0) return false;
        if (Double.compare(quote.lowPrice, lowPrice) != 0) return false;
        if (Double.compare(quote.closePrice, closePrice) != 0) return false;
        if (Double.compare(quote.previousClosePrice, previousClosePrice) != 0) return false;
        if (Double.compare(quote.fiscalYearHigh, fiscalYearHigh) != 0) return false;
        if (Double.compare(quote.fiscalYearLow, fiscalYearLow) != 0) return false;
        if (Double.compare(quote.bid, bid) != 0) return false;
        if (bidSize != quote.bidSize) return false;
        if (bidDate != quote.bidDate) return false;
        if (Double.compare(quote.ask, ask) != 0) return false;
        if (askSize != quote.askSize) return false;
        if (askDate != quote.askDate) return false;
        if (openInterest != quote.openInterest) return false;
        if (Double.compare(quote.strike, strike) != 0) return false;
        if (contractSize != quote.contractSize) return false;
        if (symbol != null ? !symbol.equals(quote.symbol) : quote.symbol != null) return false;
        if (description != null ? !description.equals(quote.description) : quote.description != null) return false;
        if (exchange != null ? !exchange.equals(quote.exchange) : quote.exchange != null) return false;
        if (securityType != null ? !securityType.equals(quote.securityType) : quote.securityType != null) return false;
        if (bidExchange != null ? !bidExchange.equals(quote.bidExchange) : quote.bidExchange != null) return false;
        if (askExchange != null ? !askExchange.equals(quote.askExchange) : quote.askExchange != null) return false;
        if (underlying != null ? !underlying.equals(quote.underlying) : quote.underlying != null) return false;
        if (expirationDate != null ? !expirationDate.equals(quote.expirationDate) : quote.expirationDate != null)
            return false;
        if (expirationType != null ? !expirationType.equals(quote.expirationType) : quote.expirationType != null)
            return false;
        return optionType != null ? optionType.equals(quote.optionType) : quote.optionType == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = symbol != null ? symbol.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (exchange != null ? exchange.hashCode() : 0);
        result = 31 * result + (securityType != null ? securityType.hashCode() : 0);
        temp = Double.doubleToLongBits(change);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(percentChange);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + volume;
        result = 31 * result + averageVolume;
        result = 31 * result + lastVolume;
        result = 31 * result + (int) (tradeDate ^ (tradeDate >>> 32));
        temp = Double.doubleToLongBits(openPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(highPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lowPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(closePrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(previousClosePrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fiscalYearHigh);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fiscalYearLow);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(bid);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + bidSize;
        result = 31 * result + (bidExchange != null ? bidExchange.hashCode() : 0);
        result = 31 * result + (int) (bidDate ^ (bidDate >>> 32));
        temp = Double.doubleToLongBits(ask);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + askSize;
        result = 31 * result + (askExchange != null ? askExchange.hashCode() : 0);
        result = 31 * result + (int) (askDate ^ (askDate >>> 32));
        result = 31 * result + openInterest;
        result = 31 * result + (underlying != null ? underlying.hashCode() : 0);
        temp = Double.doubleToLongBits(strike);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + contractSize;
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        result = 31 * result + (expirationType != null ? expirationType.hashCode() : 0);
        result = 31 * result + (optionType != null ? optionType.hashCode() : 0);
        return result;
    }

    public String toString() {
        return "Quote(symbol=" + this.getSymbol() + ", description=" + this.getDescription() 
        + ", exchange=" + this.getExchange() + ", securityType=" + this.getSecurityType() 
        + ", change=" + this.getChange() + ", percentChange=" + this.getPercentChange() 
        + ", volume=" + this.getVolume() + ", averageVolume=" + this.getAverageVolume() 
        + ", lastVolume=" + this.getLastVolume() + ", tradeDate=" + this.getTradeDate() 
        + ", openPrice=" + this.getOpenPrice() + ", highPrice=" + this.getHighPrice() 
        + ", lowPrice=" + this.getLowPrice() + ", closePrice=" + this.getClosePrice() 
        + ", previousClosePrice=" + this.getPreviousClosePrice() + ", fiscalYearHigh=" + this.getFiscalYearHigh() 
        + ", fiscalYearLow=" + this.getFiscalYearLow() + ", bid=" + this.getBid() 
        + ", bidSize=" + this.getBidSize() + ", bidExchange=" + this.getBidExchange() 
        + ", bidDate=" + this.getBidDate() + ", ask=" + this.getAsk() + ", askSize=" + this.getAskSize() 
        + ", askExchange=" + this.getAskExchange() + ", askDate=" + this.getAskDate() 
        + ", openInterest=" + this.getOpenInterest() + ", underlying=" + this.getUnderlying() 
        + ", strike=" + this.getStrike() + ", contractSize=" + this.getContractSize() 
        + ", expirationDate=" + this.getExpirationDate() + ", expirationType=" + this.getExpirationType() 
        + ", optionType=" + this.getOptionType() + ", greeks=" + this.getGreeks() + ")";
    }
}
