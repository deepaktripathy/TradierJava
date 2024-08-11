package com.tradierapi.tradierjava.client.marketdata.request;

/*
 * One of: tick, 1min, 5min, 15min
 * 
 * Used for Time and Sales tick data
 */
public enum MinuteInterval {
   tick("tick"), 
   
   oneMinute("1min"),
   
   fiveMinutes("5min"),
   
   fifteenMinutes("15min");
   
   public final String label;//textual value

   private MinuteInterval(String label) {
       this.label = label;
   }
   
   public String toString() {
      return label;
  }
}
