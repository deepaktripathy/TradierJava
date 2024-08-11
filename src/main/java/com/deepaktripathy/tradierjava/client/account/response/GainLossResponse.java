package com.deepaktripathy.tradierjava.client.account.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author deepak tripathy created on 06/26/2024
 *
 */
public class GainLossResponse {
   
   @JsonProperty("closed_position")
   private List<ClosedPosition> closedPositions;

   public GainLossResponse() {
   }

   public List<ClosedPosition> getClosedPositions() {
      return this.closedPositions;
   }

   protected boolean canEqual(Object other) {
      return other instanceof GainLossResponse;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;

      GainLossResponse positions1 = (GainLossResponse) o;

      return closedPositions != null ? closedPositions.equals(positions1.closedPositions)
            : positions1.closedPositions == null;
   }

   @Override
   public int hashCode() {
      return closedPositions != null ? closedPositions.hashCode() : 0;
   }

   public String toString() {
      return "ClosedPositions(positions=" + this.getClosedPositions() + ")";
   }

}
