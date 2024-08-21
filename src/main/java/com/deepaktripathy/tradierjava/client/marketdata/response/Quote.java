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
   
   @JsonProperty("ask")
   private Double ask;
   
   @JsonProperty("ask_date")
   private Long askDate;
   
   @JsonProperty("askexch")
   private String askExchange;
   
   @JsonProperty("asksize")
   private Integer askSize;
   
   /**
    * 90 day (3-months) average volume of the security
    */
   @JsonProperty("average_volume")
   private Long averageVolume;
   
   @JsonProperty("bid")
   private Double bid;
   
   @JsonProperty("bid_date")
   private Long bidDate;
   
   @JsonProperty("bidexch")
   private String bidExchange;
   
   @JsonProperty("bidsize")
   private Integer bidSize;
   
   @JsonProperty("change")
   private Double change;
   
   @JsonProperty("close")
   private Double closePrice;
   
   @JsonProperty("contract_size")
   private Integer contractSize;
   
   /**
    * Current day's volume till now
    */
   @JsonProperty("volume")
   private Long dayVolume;
   
   @JsonProperty("description")
   private String description;
   
   @JsonProperty("exch")
   private String exchange;
   
   @JsonProperty("expiration_date")
   private String expirationDate;
   
   @JsonProperty("expiration_type")
   private String expirationType;
   
   @JsonProperty("week_52_high")
   private Double fiscalYearHigh;
   
   @JsonProperty("week_52_low")
   private Double fiscalYearLow;
   
   @JsonProperty("greeks")
   private Greeks greeks;
   
   @JsonProperty("high")
   private Double highPrice;
   
   @JsonProperty("last")
   private Double lastPrice;
   
   /**
    * Volume of the last price (instant)
    */
   @JsonProperty("last_volume")
   private Long lastVolume;
   
   @JsonProperty("low")
   private Double lowPrice;
   
   @JsonProperty("open_interest")
   private Integer openInterest;
   
   @JsonProperty("open")
   private Double openPrice;
   
   @JsonProperty("option_type")
   private OptionType optionType;
   
   @JsonProperty("change_percentage")
   private Double percentChange;
   
   @JsonProperty("prevclose")
   private Double previousClosePrice;
   
   @JsonProperty("root_symbol")
   private String rootSymbol;
   
   @JsonProperty("root_symbols")
   private String rootSymbols;
   
   @JsonProperty("type")
   private SecurityType securityType;
   
   @JsonProperty("strike")
   private Double strike;

   @JsonProperty("symbol")
   private String symbol;

   @JsonProperty("trade_date")
   private Long tradeDate;

   @JsonProperty("underlying")
   private String underlying;

   public Long getEpochMillisExpirationDate() throws ParseException {
      if (expirationDate != null) {
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         return df.parse(this.expirationDate).getTime();
      }
      return 0L;
   }
}
