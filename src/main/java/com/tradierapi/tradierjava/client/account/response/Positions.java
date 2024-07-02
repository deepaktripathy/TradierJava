package com.tradierapi.tradierjava.client.account.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */
public class Positions {
   @JsonProperty("position")
   private List<Position> positions;

   public Positions() {
   }

   public List<Position> getPositions() {
      return this.positions;
   }

   protected boolean canEqual(Object other) {
      return other instanceof Positions;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;

      Positions positions1 = (Positions) o;

      return positions != null ? positions.equals(positions1.positions) : positions1.positions == null;
   }

   @Override
   public int hashCode() {
      return positions != null ? positions.hashCode() : 0;
   }

   public String toString() {
      return "Positions(positions=" + this.getPositions() + ")";
   }
}