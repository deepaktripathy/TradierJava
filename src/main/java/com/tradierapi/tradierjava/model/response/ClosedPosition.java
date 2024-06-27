package com.tradierapi.tradierjava.model.response;

import java.time.ZonedDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author deepak tripathy created on 06/26/2024
 *
 */
public class ClosedPosition {
    //can only be this format: yyyy-mm-ddTHH:mm:ss.SSSZ 
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-ddTHH:mm:ss.SSSZ")
    @JsonProperty("close_date")
    private ZonedDateTime closeDate;

    @JsonProperty("cost")
    private Double cost;

    @JsonProperty("gain_loss")
    private Double gainLoss;

    @JsonProperty("gain_loss_percent")
    private Double gainLossPercent;

    //uses default zonedDateTime format (ISO) 
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-ddTHH:mm:ss.SSSZ")
    @JsonProperty("open_date")
    private ZonedDateTime openDate;

    @JsonProperty("proceeds")
    private Double proceeds;

    @JsonProperty("quantity")
    private Long quantity;

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("term")
    private Integer term;

	@Override
	public int hashCode() {
		return Objects.hash(closeDate, cost, gainLoss, gainLossPercent, openDate, proceeds, quantity, symbol, term);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClosedPosition other = (ClosedPosition) obj;
		return Objects.equals(closeDate, other.closeDate) && Objects.equals(cost, other.cost)
				&& Objects.equals(gainLoss, other.gainLoss) && Objects.equals(gainLossPercent, other.gainLossPercent)
				&& Objects.equals(openDate, other.openDate) && Objects.equals(proceeds, other.proceeds)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(symbol, other.symbol)
				&& Objects.equals(term, other.term);
	}

	@Override
	public String toString() {
		return "ClosedPosition [closeDate=" + closeDate + ", cost=" + cost + ", gainLoss=" + gainLoss
				+ ", gainLossPercent=" + gainLossPercent + ", openDate=" + openDate + ", proceeds=" + proceeds
				+ ", quantity=" + quantity + ", symbol=" + symbol + ", term=" + term + "]";
	}
  
}
