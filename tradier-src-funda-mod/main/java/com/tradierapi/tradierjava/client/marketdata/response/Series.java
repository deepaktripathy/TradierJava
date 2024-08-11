package com.tradierapi.tradierjava.client.marketdata.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Series {
   @JsonProperty("data") 
   ArrayList<TimeSalesData> data;
   
   public ArrayList<TimeSalesData> getData() { 
      return this.data; } 
   public void setData(ArrayList<TimeSalesData> data) { 
      this.data = data; }

   @Override
   public String toString() {
      return "Series [data=" + data + "]";
   } 

   
}
