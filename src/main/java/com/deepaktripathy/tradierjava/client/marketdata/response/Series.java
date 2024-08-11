package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Series {
   @JsonProperty("data") 
   ArrayList<TimeSalesData> data;

   public ArrayList<TimeSalesData> getData() { 
      return this.data; 
   } 
   public void setData(ArrayList<TimeSalesData> data) { 
      this.data = data; 
   }

   @Override
   public int hashCode() {
      return Objects.hash(data);
   }
   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Series other = (Series) obj;
      return Objects.equals(data, other.data);
   }
   
   @Override
   public String toString() {
      return "Series [data=" + data + "]";
   } 
}
