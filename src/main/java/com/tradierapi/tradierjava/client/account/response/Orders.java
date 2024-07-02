package com.tradierapi.tradierjava.client.account.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */
public class Orders {
   @JsonProperty("order")
   private List<Order> orders;

   public Orders() {
   }

   public List<Order> getOrders() {
      return this.orders;
   }

   protected boolean canEqual(Object other) {
      return other instanceof Orders;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;

      Orders orders1 = (Orders) o;

      return orders != null ? orders.equals(orders1.orders) : orders1.orders == null;
   }

   @Override
   public int hashCode() {
      return orders != null ? orders.hashCode() : 0;
   }

   public String toString() {
      return "Orders(orders=" + this.getOrders() + ")";
   }
}