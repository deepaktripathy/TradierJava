package com.tradierapi.tradierjava.client.account.response;

import java.time.ZonedDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tradierapi.tradierjava.client.trader.request.OrderType;
import com.tradierapi.tradierjava.model.Duration;
import com.tradierapi.tradierjava.model.response.UnrecognizedFieldsCollector;

/**
 *
 * @author deepak tripathy created on 05/24/2024
 *
 */
public class Order extends UnrecognizedFieldsCollector {

   @JsonProperty("id")
   private Long id;
   @JsonProperty("type")
   private OrderType orderType;

   @JsonProperty("symbol")
   private String symbol;

   @JsonProperty("side")
   private Side side;

   @JsonProperty("quantity")
   private Double quantity;

   @JsonProperty("status")
   private OrderStatus status;

   @JsonProperty("duration")
   private Duration duration;

   @JsonProperty("price")
   private Double price;
   @JsonProperty("avg_fill_price")
   private Double avgFillPrice;

   @JsonProperty("exec_quantity")
   private Double execQuantity;
   @JsonProperty("last_fill_price")
   private Double lastFillPrice;
   @JsonProperty("last_fill_quantity")
   private Double lastFillQuantity;
   @JsonProperty("remaining_quantity")
   private Double remainingQuantity;

   // can also be this format: yyyy-mm-ddTHH:mm:ss.SSSZ
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
   @JsonProperty("create_date")
   private ZonedDateTime createDate;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
   @JsonProperty("transaction_date")
   private ZonedDateTime transactionDate;

   @JsonProperty("class")
   private OrderClass orderClass;

   @JsonProperty("strategy")
   private OrderStrategy orderStrategy;

   // optional
   @JsonProperty("option_symbol")
   private String optionSymbol;

   @JsonProperty("stop_price")
   private Double stopPrice;

   // This is NOT documented, but this comes back via 200 response.
   @JsonProperty("reason_description")
   private String reasonDescription;

   @JsonProperty("tag")
   private String orderTag;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public OrderType getOrderType() {
      return orderType;
   }

   public void setOrderType(OrderType orderType) {
      this.orderType = orderType;
   }

   public String getSymbol() {
      return symbol;
   }

   public void setSymbol(String symbol) {
      this.symbol = symbol;
   }

   public Side getSide() {
      return side;
   }

   public void setSide(Side side) {
      this.side = side;
   }

   public Double getQuantity() {
      return quantity;
   }

   public void setQuantity(Double quantity) {
      this.quantity = quantity;
   }

   public OrderStatus getStatus() {
      return status;
   }

   public void setStatus(OrderStatus status) {
      this.status = status;
   }

   public Duration getDuration() {
      return duration;
   }

   public void setDuration(Duration duration) {
      this.duration = duration;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

   public Double getAvgFillPrice() {
      return avgFillPrice;
   }

   public void setAvgFillPrice(Double avgFillPrice) {
      this.avgFillPrice = avgFillPrice;
   }

   public Double getExecQuantity() {
      return execQuantity;
   }

   public void setExecQuantity(Double execQuantity) {
      this.execQuantity = execQuantity;
   }

   public Double getLastFillPrice() {
      return lastFillPrice;
   }

   public void setLastFillPrice(Double lastFillPrice) {
      this.lastFillPrice = lastFillPrice;
   }

   public Double getLastFillQuantity() {
      return lastFillQuantity;
   }

   public void setLastFillQuantity(Double lastFillQuantity) {
      this.lastFillQuantity = lastFillQuantity;
   }

   public Double getRemainingQuantity() {
      return remainingQuantity;
   }

   public void setRemainingQuantity(Double remainingQuantity) {
      this.remainingQuantity = remainingQuantity;
   }

   public ZonedDateTime getCreateDate() {
      return createDate;
   }

   public void setCreateDate(ZonedDateTime createDate) {
      this.createDate = createDate;
   }

   public ZonedDateTime getTransactionDate() {
      return transactionDate;
   }

   public void setTransactionDate(ZonedDateTime transactionDate) {
      this.transactionDate = transactionDate;
   }

   public OrderClass getOrderClass() {
      return orderClass;
   }

   public void setOrderClass(OrderClass orderClass) {
      this.orderClass = orderClass;
   }

   public OrderStrategy getOrderStrategy() {
      return orderStrategy;
   }

   public void setOrderStrategy(OrderStrategy orderStrategy) {
      this.orderStrategy = orderStrategy;
   }

   public String getOptionSymbol() {
      return optionSymbol;
   }

   public void setOptionSymbol(String optionSymbol) {
      this.optionSymbol = optionSymbol;
   }

   public Double getStopPrice() {
      return stopPrice;
   }

   public void setStopPrice(Double stopPrice) {
      this.stopPrice = stopPrice;
   }

   public String getReasonDescription() {
      return reasonDescription;
   }

   public void setReasonDescription(String reasonDescription) {
      this.reasonDescription = reasonDescription;
   }

   public String getOrderTag() {
      return orderTag;
   }

   public void setOrderTag(String orderTag) {
      this.orderTag = orderTag;
   }

   @Override
   public int hashCode() {
      return Objects.hash(avgFillPrice, createDate, duration, execQuantity, id, lastFillPrice, lastFillQuantity,
            optionSymbol, orderClass, orderStrategy, orderTag, orderType, price, quantity, reasonDescription,
            remainingQuantity, side, status, stopPrice, symbol, transactionDate);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if ((obj == null) || (getClass() != obj.getClass()))
         return false;
      Order other = (Order) obj;
      return Objects.equals(avgFillPrice, other.avgFillPrice) && Objects.equals(createDate, other.createDate)
            && duration == other.duration && Objects.equals(execQuantity, other.execQuantity)
            && Objects.equals(id, other.id) && Objects.equals(lastFillPrice, other.lastFillPrice)
            && Objects.equals(lastFillQuantity, other.lastFillQuantity)
            && Objects.equals(optionSymbol, other.optionSymbol) && orderClass == other.orderClass
            && orderStrategy == other.orderStrategy && Objects.equals(orderTag, other.orderTag)
            && orderType == other.orderType && Objects.equals(price, other.price)
            && Objects.equals(quantity, other.quantity) && Objects.equals(reasonDescription, other.reasonDescription)
            && Objects.equals(remainingQuantity, other.remainingQuantity) && side == other.side
            && status == other.status && Objects.equals(stopPrice, other.stopPrice)
            && Objects.equals(symbol, other.symbol) && Objects.equals(transactionDate, other.transactionDate);
   }

   @Override
   public String toString() {
      return "Order [id=" + id + ", orderType=" + orderType + ", symbol=" + symbol + ", side=" + side + ", quantity="
            + quantity + ", status=" + status + ", duration=" + duration + ", price=" + price + ", avgFillPrice="
            + avgFillPrice + ", execQuantity=" + execQuantity + ", lastFillPrice=" + lastFillPrice
            + ", lastFillQuantity=" + lastFillQuantity + ", remainingQuantity=" + remainingQuantity + ", createDate="
            + createDate + ", transactionDate=" + transactionDate + ", orderClass=" + orderClass + ", orderStrategy="
            + orderStrategy + ", optionSymbol=" + optionSymbol + ", stopPrice=" + stopPrice + ", reasonDescription="
            + reasonDescription + ", orderTag=" + orderTag + "]";
   }

}
