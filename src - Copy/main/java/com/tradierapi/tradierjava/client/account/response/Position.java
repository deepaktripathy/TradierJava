package com.tradierapi.tradierjava.client.account.response;

import java.time.ZonedDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */
public class Position {

   @JsonProperty("cost_basis")
   private Double costBasis;
   @JsonProperty("date_acquired")
   private ZonedDateTime dateAcquired;
   @JsonProperty("id")
   private Long id;
   @JsonProperty("quantity")
   private Double quantity;
   @JsonProperty("symbol")
   private String symbol;

   public Long getId() {
      return id;
   }

   public String getSymbol() {
      return symbol;
   }

   public Double getQuantity() {
      return quantity;
   }

   public ZonedDateTime getDateAcquired() {
      return dateAcquired;
   }

   public Double getCostBasis() {
      return costBasis;
   }

   @Override
   public int hashCode() {
      return Objects.hash(costBasis, dateAcquired, id, quantity, symbol);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Position other = (Position) obj;
      return Double.doubleToLongBits(costBasis) == Double.doubleToLongBits(other.costBasis)
            && Objects.equals(dateAcquired, other.dateAcquired) && id == other.id
            && Double.doubleToLongBits(quantity) == Double.doubleToLongBits(other.quantity) && symbol == other.symbol;
   }

   @Override
   public String toString() {
      return "Position [id=" + id + ", symbol=" + symbol + ", quantity=" + quantity + ", dateAcquired=" + dateAcquired
            + ", costBasis=" + costBasis + "]";
   }
}
