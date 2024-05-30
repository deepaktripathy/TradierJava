package com.tradierapi.tradierjava.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Each represents a split at one time
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */
public class StockSplitInfo {

    @JsonProperty("share_class_id")
    private String shareClassId;

    /** ISO date format, ex: 1987-09-21 */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("ex_date")    
    private LocalDate exDate;
    
    @JsonProperty("adjustment_factor")
    private double adjustmentFactor;
    
    @JsonProperty("split_from")
    private double splitFrom;
    
    @JsonProperty("split_to")
    private double splitTo;
    
    @JsonProperty("split_type")
    private String splitType;

	public String getShareClassId() {
		return shareClassId;
	}

	public LocalDate getExDate() {
		return exDate;
	}

	public double getAdjustmentFactor() {
		return adjustmentFactor;
	}

	public double getSplitFrom() {
		return splitFrom;
	}

	public double getSplitTo() {
		return splitTo;
	}

	public String getSplitType() {
		return splitType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adjustmentFactor, exDate, shareClassId, splitFrom, splitTo, splitType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockSplitInfo other = (StockSplitInfo) obj;
		return Double.doubleToLongBits(adjustmentFactor) == Double.doubleToLongBits(other.adjustmentFactor)
				&& Objects.equals(exDate, other.exDate) && Objects.equals(shareClassId, other.shareClassId)
				&& Double.doubleToLongBits(splitFrom) == Double.doubleToLongBits(other.splitFrom)
				&& Double.doubleToLongBits(splitTo) == Double.doubleToLongBits(other.splitTo)
				&& Objects.equals(splitType, other.splitType);
	}

	@Override
	public String toString() {
		return "StockSplitInfo [shareClassId=" + shareClassId + ", exDate=" + exDate + ", adjustmentFactor="
				+ adjustmentFactor + ", splitFrom=" + splitFrom + ", splitTo=" + splitTo + ", splitType=" + splitType
				+ "]";
	}    
}
