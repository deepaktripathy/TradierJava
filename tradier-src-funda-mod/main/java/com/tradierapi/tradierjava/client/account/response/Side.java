package com.tradierapi.tradierjava.client.account.response;

/**
 * Represents the side for an order. This is generic, that this contains all the
 * types of sides for equity & option both.
 *
 * The reason why this is there, even though there are EquitySide & optionSide,
 * is these relationships can not be subclasses/inherited. Also, we can create 2
 * types of orders each containing one of these sides, but json wont be able to
 * identify the difference to correctly deserialize.
 *
 * This is a stopgap measure till we get hold of Tradier request/response
 * schema.
 *
 */
public enum Side {
   /**
    * Buy stock/ETF
    */
   buy,

   /**
    * Sell stock/ETF
    */
   sell,

   /**
    * Short sell stock/ETF (if shorting is allowed)
    */
   sell_short,

   /**
    * Cover a Shorted stock/ETF (if shorting is allowed)
    */
   buy_to_cover,

   /**
    * Buy to open a option
    */
   buy_to_open,

   /**
    * Sell to close option
    */
   sell_to_close,

   /**
    * Buy to close a option
    */
   buy_to_close,

   /**
    * Sell to open a option
    */
   sell_to_open
}
