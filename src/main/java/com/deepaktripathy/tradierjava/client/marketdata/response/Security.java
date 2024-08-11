package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */
public class Security {

   @JsonProperty("symbol")
   private String symbol;

   @JsonProperty("exchange")
   private String exchange;

   @JsonProperty("type")
   private String type;

   @JsonProperty("description")
   private String description;

   public String getSymbol() {
      return symbol;
   }

   public String getExchange() {
      return exchange;
   }

   public String getType() {
      return type;
   }

   public String getDescription() {
      return description;
   }

   @Override
   public int hashCode() {
      return Objects.hash(description, exchange, symbol, type);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Security other = (Security) obj;
      return Objects.equals(description, other.description) && Objects.equals(exchange, other.exchange)
            && Objects.equals(symbol, other.symbol) && Objects.equals(type, other.type);
   }

   @Override
   public String toString() {
      return "Security [symbol=" + symbol + ", exchange=" + exchange + ", type=" + type + ", description=" + description
            + "]";
   }

}
