package com.deepaktripathy.tradierjava.client.fundamental.response.corpaction; 
import java.util.Objects;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty; 

public class SplitStat extends UnrecognizedFieldsCollector {
    @JsonProperty("share_class_id")
    private String shareClassId;
    
    @JsonProperty("ex_date")
    private String exDate;

    @JsonProperty("adjustment_factor")
    double adjustmentFactor;

    @JsonProperty("split_from")
    double splitFrom;
    
    @JsonProperty("split_to")
    double splitTo;

    @JsonProperty("split_type")
    private String splitType;

   public String getShareClassId() {
      return shareClassId;
   }

   public void setShareClassId(String shareClassId) {
      this.shareClassId = shareClassId;
   }

   public String getExDate() {
      return exDate;
   }

   public void setExDate(String exDate) {
      this.exDate = exDate;
   }

   public double getAdjustmentFactor() {
      return adjustmentFactor;
   }

   public void setAdjustmentFactor(double adjustmentFactor) {
      this.adjustmentFactor = adjustmentFactor;
   }

   public double getSplitFrom() {
      return splitFrom;
   }

   public void setSplitFrom(double splitFrom) {
      this.splitFrom = splitFrom;
   }

   public double getSplitTo() {
      return splitTo;
   }

   public void setSplitTo(double splitTo) {
      this.splitTo = splitTo;
   }

   public String getSplitType() {
      return splitType;
   }

   public void setSplitType(String splitType) {
      this.splitType = splitType;
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
      SplitStat other = (SplitStat) obj;
      return Double.doubleToLongBits(adjustmentFactor) == Double.doubleToLongBits(other.adjustmentFactor)
            && Objects.equals(exDate, other.exDate) && Objects.equals(shareClassId, other.shareClassId)
            && Double.doubleToLongBits(splitFrom) == Double.doubleToLongBits(other.splitFrom)
            && Double.doubleToLongBits(splitTo) == Double.doubleToLongBits(other.splitTo)
            && Objects.equals(splitType, other.splitType);
   }

   @Override
   public String toString() {
      return "SplitStat [shareClassId=" + shareClassId + ", exDate=" + exDate + ", adjustmentFactor=" + adjustmentFactor
            + ", splitFrom=" + splitFrom + ", splitTo=" + splitTo + ", splitType=" + splitType + "]";
   }

}
