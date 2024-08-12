package com.deepaktripathy.tradierjava.client.fundamental.response.corpaction; 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.deepaktripathy.tradierjava.client.fundamental.DateKeyDeserializer;
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize; 

public class Tables extends UnrecognizedFieldsCollector {
   
   @JsonProperty("mergers_and_acquisitions")
   private List<MergersAndAcquisition> mergersAndAcquisitions;

   @JsonProperty("stock_splits")
   @JsonDeserialize(keyUsing = DateKeyDeserializer.class)
   private Map<LocalDate, SplitStat> stockSplitStatMap;

   public List<MergersAndAcquisition> getMergersAndAcquisitions() { 
      return this.mergersAndAcquisitions; 
   }
   public void setMergersAndAcquisitions(ArrayList<MergersAndAcquisition> mergersAndAcquisitions) { 
      this.mergersAndAcquisitions = mergersAndAcquisitions; 
   }

   public Map<LocalDate, SplitStat> getStockSplitsStatMap() { 
      return this.stockSplitStatMap; 
   }
   public void setStockSplitsStatMap(Map<LocalDate, SplitStat> stockSplitStatMap) { 
      this.stockSplitStatMap = stockSplitStatMap; 
   }

   @Override
   public int hashCode() {
      return Objects.hash(mergersAndAcquisitions, stockSplitStatMap);
   }
   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Tables other = (Tables) obj;
      return Objects.equals(mergersAndAcquisitions, other.mergersAndAcquisitions)
            && Objects.equals(stockSplitStatMap, other.stockSplitStatMap);
   }
   
   @Override
   public String toString() {
      return "Tables [mergers_and_acquisitions=" + mergersAndAcquisitions + ", stockSplitStatMap=" + stockSplitStatMap + "]";
   }
}
