package com.deepaktripathy.tradierjava.client.trader.request;

import java.util.Map;

import com.deepaktripathy.tradierjava.client.model.Duration;
import com.deepaktripathy.tradierjava.utils.Utils;

/**
 * Fields from:
 * https://documentation.tradier.com/brokerage-api/trading/place-equity-order
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */
public class EquityOrderRequest extends OrderRequest {
   private EquitySide side;

   public static EquityOrderRequest buildMarketOrder(EquitySide side, String symbol, Double quantity,
         OrderType orderType, Duration duration, Double stopPrice, String orderTag) {
      return buildLimitOrder(side, symbol, quantity, null, orderType, duration, stopPrice, orderTag);
   }

   public static EquityOrderRequest buildLimitOrder(EquitySide side, String symbol, Double quantity, Double price,
         OrderType orderType, Duration duration, Double stopPrice, String orderTag) {

      EquityOrderRequest request = new EquityOrderRequest(side, symbol, quantity, price, orderType, duration, stopPrice,
            orderTag);

      return request;
   }

   private EquityOrderRequest() {
      equityClass = EquityClass.equity;
   }

   public EquityOrderRequest(EquitySide side, String symbol, Double quantity, Double price, OrderType orderType,
         Duration duration, Double stopPrice, String orderTag) {
      this.equityClass = EquityClass.equity;
      this.side = side;
      this.orderType = orderType;
      this.symbol = symbol;
      this.quantity = quantity;
      this.price = price;
      this.orderType = orderType;
      this.duration = duration;
      this.stopPrice = stopPrice;
      this.orderTag = orderTag;
   }

   public EquitySide getSide() {
      return side;
   }

   public EquityClass getEquityClass() {
      return equityClass;
   }

   @Override
   public String toString() {
      return "EquityOrderRequest [side=" + side + ", equityClass=" + equityClass + "]";
   }

   /**
    * Returns all non-empty/null parameters as key-value pairs where each key is a
    * valid API request key
    */
   @Override
   public Map<String, String> getRequestParams() {
      Map<String, String> paramMap = super.getRequestParams();
      Utils.addIfValid(paramMap, "side", side);

      return paramMap;
   }

}
