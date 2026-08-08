package com.deepaktripathy.tradierjava.client.marketdata;

/**
 * @author Deepak Tripathy
 *
 */
public enum TickInterval {
   TICK("tick"),
   ONE("1min"),
   FIVE("5min"),
   FIFTEEN("15min");
   
   //store the actual interval
   private final String intervalText;

   //private constructor
   private TickInterval(String intervalText) {
       this.intervalText = intervalText;
   }

   //Override default toString()
   @Override
   public String toString() {
       return this.intervalText;
   }
}
