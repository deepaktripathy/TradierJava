package com.tradierapi.tradierjava.model;

import java.time.ZonedDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */
public class Order {

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
    
    //can also be this format: yyyy-mm-ddTHH:mm:ss.SSSZ 
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @JsonProperty("create_date")
    private ZonedDateTime createDate;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @JsonProperty("transaction_date")
    private ZonedDateTime transactionDate;
    
    @JsonProperty("class")
    private EquityClass equityClass;
    
    //strategy field: SKIPPED
    
    //optional
    @JsonProperty("option_symbol")
    private String optionSymbol;
    
    @JsonProperty("stop_price")
    private Double stopPrice;
    
    //This is NOT documented, but this comes back via 200 response.
    @JsonProperty("reason_description")
    private String reasonDescription;
    
    @JsonProperty("tag")
    private String orderTag;
	
	public Long getId() {
		return id;
	}
	public OrderType getType() {
		return orderType;
	}
	public String getSymbol() {
		return symbol;
	}
	public Side getSide() {
		return side;
	}
	public Double getQuantity() {
		return quantity;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public Duration getDuration() {
		return duration;
	}
	public Double getPrice() {
		return price;
	}
	public Double getAvgFillPrice() {
		return avgFillPrice;
	}
	public Double getExecQuantity() {
		return execQuantity;
	}
	public Double getLastFillPrice() {
		return lastFillPrice;
	}
	public Double getLastFillQuantity() {
		return lastFillQuantity;
	}
	public Double getRemainingQuantity() {
		return remainingQuantity;
	}
	public ZonedDateTime getCreateDate() {
		return createDate;
	}
	public ZonedDateTime getTransactionDate() {
		return transactionDate;
	}
	public EquityClass getEquityClass() {
		return equityClass;
	}
	public String getOptionSymbol() {
		return optionSymbol;
	}
	
	public Double getStopPrice() {
		return stopPrice;
	}
	public String getReasonDescription() {
		return reasonDescription;
	}
	public String getOrderTag() {
		return orderTag;
	}
	@Override
	public int hashCode() {
		return Objects.hash(avgFillPrice, createDate, duration, equityClass, execQuantity, id, lastFillPrice,
				lastFillQuantity, optionSymbol, orderTag, price, quantity, reasonDescription, remainingQuantity, side,
				status, stopPrice, symbol, transactionDate, orderType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Double.doubleToLongBits(avgFillPrice) == Double.doubleToLongBits(other.avgFillPrice)
				&& Objects.equals(createDate, other.createDate) && Objects.equals(duration, other.duration)
				&& Objects.equals(equityClass, other.equityClass)
				&& Double.doubleToLongBits(execQuantity) == Double.doubleToLongBits(other.execQuantity)
				&& id == other.id
				&& Double.doubleToLongBits(lastFillPrice) == Double.doubleToLongBits(other.lastFillPrice)
				&& Double.doubleToLongBits(lastFillQuantity) == Double.doubleToLongBits(other.lastFillQuantity)
				&& Objects.equals(optionSymbol, other.optionSymbol) && Objects.equals(orderTag, other.orderTag)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Double.doubleToLongBits(quantity) == Double.doubleToLongBits(other.quantity)
				&& Objects.equals(reasonDescription, other.reasonDescription)
				&& Double.doubleToLongBits(remainingQuantity) == Double.doubleToLongBits(other.remainingQuantity)
				&& Objects.equals(side, other.side) && Objects.equals(status, other.status)
				&& Double.doubleToLongBits(stopPrice) == Double.doubleToLongBits(other.stopPrice)
				&& Objects.equals(symbol, other.symbol) && Objects.equals(transactionDate, other.transactionDate)
				&& Objects.equals(orderType, other.orderType);
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", type=" + orderType + ", symbol=" + symbol + ", side=" + side + ", quantity=" + quantity
				+ ", status=" + status + ", duration=" + duration + ", price=" + price + ", avgFillPrice="
				+ avgFillPrice + ", execQuantity=" + execQuantity + ", lastFillPrice=" + lastFillPrice
				+ ", lastFillQuantity=" + lastFillQuantity + ", remainingQuantity=" + remainingQuantity
				+ ", createDate=" + createDate + ", transactionDate=" + transactionDate 
				+ ", equityClass=" + equityClass + ", stopPrice=" + stopPrice 
				+ ", reasonDescription=" + reasonDescription 
				+ ", orderTag=" + orderTag + ", optionSymbol=" + optionSymbol + "]";
	}
	

}
