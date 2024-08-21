package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.deepaktripathy.tradierjava.client.model.SecurityType;
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

/**
 * @author deepak tripathy created on 05/24/2024
 */

@Getter
@ToString
public class Quote extends UnrecognizedFieldsCollector {
   
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
   
   @JsonProperty("last")
   private Double lastPrice;
   
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

   @JsonProperty("root_symbols")
   private String rootSymbols;

   @JsonProperty("greeks")
   private Greeks greeks;

   public Long getEpochMillisExpirationDate() throws ParseException {
      if (expirationDate != null) {
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         return df.parse(this.expirationDate).getTime();
      }
      return 0L;
   }
}
