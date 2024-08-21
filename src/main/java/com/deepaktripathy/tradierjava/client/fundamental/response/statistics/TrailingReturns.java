package com.deepaktripathy.tradierjava.client.fundamental.response.statistics;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TrailingReturns extends UnrecognizedFieldsCollector {
   @JsonProperty("period_1d") 
   private Period1d period1d;
   
   @JsonProperty("period_5d") 
   private Period5d period5d;
   
   @JsonProperty("period_1m") 
   private Period1m period1m;
   
   @JsonProperty("period_3m") 
   private Period3m period3m;
   
   @JsonProperty("period_6m") 
   private Period6m period6m;
   
   @JsonProperty("period_1y") 
   private Period1y period1y;
   
   @JsonProperty("period_3y") 
   private Period3y period3y;
   
   @JsonProperty("period_5y") 
   private Period5y period5y;
   
   @JsonProperty("period_10y") 
   private Period10y period10y;
   
   @JsonProperty("period_15y") 
   private Period15y period15y;
   
   @JsonProperty("m_t_d") 
   private MTD mTD;
   
   @JsonProperty("q_t_d") 
   private QTD qTD;
   
   @JsonProperty("y_t_d") 
   private YTD yTD;

   @Override
   public String toString() {
      return "TrailingReturns [period1d=" + period1d + ", period5d=" + period5d + ", period1m=" + period1m
            + ", period3m=" + period3m + ", period6m=" + period6m + ", period1y=" + period1y + ", period3y=" + period3y
            + ", period5y=" + period5y + ", period10y=" + period10y + ", period15y=" + period15y + ", mTD=" + mTD
            + ", qTD=" + qTD + ", yTD=" + yTD + "]";
   }
   
}