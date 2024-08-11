package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

import com.deepaktripathy.tradierjava.client.model.SecurityType;
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
   private SecurityType securityType;
   @JsonProperty("change")
   private Double change;
   @JsonProperty("change_percentage")
   private Double percentChange;
   /**
    * Current day's volume till now
    */
   @JsonProperty("volume")
   private Long dayVolume;
   /**
    * 90 day (3-months) average volume of the security
    */
   @JsonProperty("average_volume")
   private Long averageVolume;
   /**
    * Volume of the last price (instant)
    */
   @JsonProperty("last_volume")
   private Long lastVolume;
   @JsonProperty("trade_date")
   private Long tradeDate;
   @JsonProperty("open")
   private Double openPrice;
   @JsonProperty("high")
   private Double highPrice;
   @JsonProperty("low")
   private Double lowPrice;
   @JsonProperty("close")
   private Double closePrice;
   @JsonProperty("prevclose")
   private Double previousClosePrice;
   @JsonProperty("week_52_high")
   private Double fiscalYearHigh;
   @JsonProperty("week_52_low")
   private Double fiscalYearLow;
   @JsonProperty("bid")
   private Double bid;
   @JsonProperty("bidsize")
   private Integer bidSize;
   @JsonProperty("bidexch")
   private String bidExchange;
   @JsonProperty("bid_date")
   private Long bidDate;
   @JsonProperty("ask")
   private Double ask;
   @JsonProperty("asksize")
   private Integer askSize;
   @JsonProperty("askexch")
   private String askExchange;
   @JsonProperty("ask_date")
   private Long askDate;
   @JsonProperty("open_interest")
   private Integer openInterest;
   @JsonProperty("underlying")
   private String underlying;
   @JsonProperty("strike")
   private Double strike;
   @JsonProperty("contract_size")
   private Integer contractSize;
   @JsonProperty("expiration_date")
   private String expirationDate;
   @JsonProperty("expiration_type")
   private String expirationType;
   @JsonProperty("option_type")
   private OptionType optionType;

   @JsonProperty("root_symbol")
   private String rootSymbol;

   @JsonProperty("greeks")
   private Greeks greeks;

   public Long getEpochMillisExpirationDate() throws ParseException {
      if (expirationDate != null) {
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         return df.parse(this.expirationDate).getTime();
      }
      return 0L;
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

   public SecurityType getSecurityType() {
      return this.securityType;
   }

   public Double getChange() {
      return this.change;
   }

   public Double getPercentChange() {
      return this.percentChange;
   }

   /**
    * Current day's volume till now
    */
   public Long getDayVolume() {
      return this.dayVolume;
   }

   /**
    * 90 day (3-months) average volume of the security
    */
   public Long getAverageVolume() {
      return this.averageVolume;
   }

   /**
    * Volume of the last price (instant)
    */
   public Long getLastVolume() {
      return this.lastVolume;
   }

   /** Milliseconds since Epoch */
   public Long getTradeDate() {
      return this.tradeDate;
   }

   public Double getOpenPrice() {
      return this.openPrice;
   }

   public Double getHighPrice() {
      return this.highPrice;
   }

   public Double getLowPrice() {
      return this.lowPrice;
   }

   public Double getClosePrice() {
      return this.closePrice;
   }

   public Double getPreviousClosePrice() {
      return this.previousClosePrice;
   }

   public Double getFiscalYearHigh() {
      return this.fiscalYearHigh;
   }

   public Double getFiscalYearLow() {
      return this.fiscalYearLow;
   }

   public Double getBid() {
      return this.bid;
   }

   public Integer getBidSize() {
      return this.bidSize;
   }

   public String getBidExchange() {
      return this.bidExchange;
   }

   /** Milliseconds since Epoch */
   public Long getBidDate() {
      return this.bidDate;
   }

   public Double getAsk() {
      return this.ask;
   }

   public Integer getAskSize() {
      return this.askSize;
   }

   public String getAskExchange() {
      return this.askExchange;
   }

   /** Milliseconds since Epoch */
   public Long getAskDate() {
      return this.askDate;
   }

   public Integer getOpenInterest() {
      return this.openInterest;
   }

   public String getUnderlying() {
      return this.underlying;
   }

   public Double getStrike() {
      return this.strike;
   }

   public Integer getContractSize() {
      return this.contractSize;
   }

   public String getExpirationDate() {
      return this.expirationDate;
   }

   public String getExpirationType() {
      return this.expirationType;
   }

   public OptionType getOptionType() {
      return this.optionType;
   }

   public Greeks getGreeks() {
      return greeks;
   }

   @Override
   public int hashCode() {
      return Objects.hash(ask, askDate, askExchange, askSize, averageVolume, bid, bidDate, bidExchange, bidSize, change,
            closePrice, contractSize, dayVolume, description, exchange, expirationDate, expirationType, fiscalYearHigh,
            fiscalYearLow, greeks, highPrice, lastVolume, lowPrice, openInterest, openPrice, optionType, percentChange,
            previousClosePrice, rootSymbol, securityType, strike, symbol, tradeDate, underlying);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Quote other = (Quote) obj;
      return Objects.equals(ask, other.ask) && Objects.equals(askDate, other.askDate)
            && Objects.equals(askExchange, other.askExchange) && Objects.equals(askSize, other.askSize)
            && Objects.equals(averageVolume, other.averageVolume) && Objects.equals(bid, other.bid)
            && Objects.equals(bidDate, other.bidDate) && Objects.equals(bidExchange, other.bidExchange)
            && Objects.equals(bidSize, other.bidSize) && Objects.equals(change, other.change)
            && Objects.equals(closePrice, other.closePrice) && Objects.equals(contractSize, other.contractSize)
            && Objects.equals(dayVolume, other.dayVolume) && Objects.equals(description, other.description)
            && Objects.equals(exchange, other.exchange) && Objects.equals(expirationDate, other.expirationDate)
            && Objects.equals(expirationType, other.expirationType)
            && Objects.equals(fiscalYearHigh, other.fiscalYearHigh)
            && Objects.equals(fiscalYearLow, other.fiscalYearLow) && Objects.equals(greeks, other.greeks)
            && Objects.equals(highPrice, other.highPrice) && Objects.equals(lastVolume, other.lastVolume)
            && Objects.equals(lowPrice, other.lowPrice) && Objects.equals(openInterest, other.openInterest)
            && Objects.equals(openPrice, other.openPrice) && Objects.equals(optionType, other.optionType)
            && Objects.equals(percentChange, other.percentChange)
            && Objects.equals(previousClosePrice, other.previousClosePrice)
            && Objects.equals(rootSymbol, other.rootSymbol) && securityType == other.securityType
            && Objects.equals(strike, other.strike) && Objects.equals(symbol, other.symbol)
            && Objects.equals(tradeDate, other.tradeDate) && Objects.equals(underlying, other.underlying);
   }

   @Override
   public String toString() {
      return "Quote [symbol=" + symbol + ", description=" + description + ", exchange=" + exchange + ", securityType="
            + securityType + ", change=" + change + ", percentChange=" + percentChange + ", dayVolume=" + dayVolume
            + ", averageVolume=" + averageVolume + ", lastVolume=" + lastVolume + ", tradeDate=" + tradeDate
            + ", openPrice=" + openPrice + ", highPrice=" + highPrice + ", lowPrice=" + lowPrice + ", closePrice="
            + closePrice + ", previousClosePrice=" + previousClosePrice + ", fiscalYearHigh=" + fiscalYearHigh
            + ", fiscalYearLow=" + fiscalYearLow + ", bid=" + bid + ", bidSize=" + bidSize + ", bidExchange="
            + bidExchange + ", bidDate=" + bidDate + ", ask=" + ask + ", askSize=" + askSize + ", askExchange="
            + askExchange + ", askDate=" + askDate + ", openInterest=" + openInterest + ", underlying=" + underlying
            + ", strike=" + strike + ", contractSize=" + contractSize + ", expirationDate=" + expirationDate
            + ", expirationType=" + expirationType + ", optionType=" + optionType + ", rootSymbol=" + rootSymbol
            + ", greeks=" + greeks + "]";
   }

}
