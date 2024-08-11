package com.tradierapi.tradierjava.client.trader.request;

/**
 * Multi-leg is included, but is not implemented in the code.
 * 
 * @author deepak
 *
 */
public enum OrderType {
   /**
    * Market order
    */
   market,

   /**
    * Limit order
    */
   limit,

   /**
    * Stop order
    */
   stop,

   /**
    * Limit with Stop
    */
   stop_limit,

   /**
    * multi-leg type, included, but NOT supported by order request yet.
    */
   debit,

   /**
    * multi-leg type, included, but NOT supported by order request yet.
    */
   credit,

   /**
    * multi-leg type, included, but NOT supported by order request yet.
    */
   even
}
