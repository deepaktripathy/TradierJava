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
    private long id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("symbol")
    private String symbol;    
    @JsonProperty("side")
    private String side;
    
    @JsonProperty("quantity")
    private double quantity;
    @JsonProperty("status")
    private String status;
    @JsonProperty("duration")
    private String duration;
    
    @JsonProperty("price")
    private double price;
    @JsonProperty("avg_fill_price")
    private double avgFillPrice;
    
    @JsonProperty("exec_quantity")
    private double execQuantity;
    @JsonProperty("last_fill_price")
    private double lastFillPrice;
    @JsonProperty("last_fill_quantity")
    private double lastFillQuantity;    
    @JsonProperty("remaining_quantity")
    private double remainingQuantity;
    
    //can also be this format: yyyy-mm-ddTHH:mm:ss.SSSZ 
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @JsonProperty("create_date")
    private ZonedDateTime createDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @JsonProperty("transaction_date")
    private ZonedDateTime transactionDate;
    @JsonProperty("class")
    private String equityClass;
    
    //strategy field: SKIPPED
    
    //optional
    @JsonProperty("option_symbol")
    private String optionSymbol;
    
    @JsonProperty("stop_price")
    private double stopPrice;
    @JsonProperty("reason_description")
    private String reasonDescription;
    @JsonProperty("tag")
    private String orderTag;
	
	public long getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public String getSymbol() {
		return symbol;
	}
	public String getSide() {
		return side;
	}
	public double getQuantity() {
		return quantity;
	}
	public String getStatus() {
		return status;
	}
	public String getDuration() {
		return duration;
	}
	public double getPrice() {
		return price;
	}
	public double getAvgFillPrice() {
		return avgFillPrice;
	}
	public double getExecQuantity() {
		return execQuantity;
	}
	public double getLastFillPrice() {
		return lastFillPrice;
	}
	public double getLastFillQuantity() {
		return lastFillQuantity;
	}
	public double getRemainingQuantity() {
		return remainingQuantity;
	}
	public ZonedDateTime getCreateDate() {
		return createDate;
	}
	public ZonedDateTime getTransactionDate() {
		return transactionDate;
	}
	public String getEquityClass() {
		return equityClass;
	}
	public String getOptionSymbol() {
		return optionSymbol;
	}
	
	public double getStopPrice() {
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
				status, stopPrice, symbol, transactionDate, type);
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
				&& Objects.equals(type, other.type);
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", type=" + type + ", symbol=" + symbol + ", side=" + side + ", quantity=" + quantity
				+ ", status=" + status + ", duration=" + duration + ", price=" + price + ", avgFillPrice="
				+ avgFillPrice + ", execQuantity=" + execQuantity + ", lastFillPrice=" + lastFillPrice
				+ ", lastFillQuantity=" + lastFillQuantity + ", remainingQuantity=" + remainingQuantity
				+ ", createDate=" + createDate + ", transactionDate=" + transactionDate + ", equityClass=" + equityClass
				+ ", stopPrice=" + stopPrice + ", reasonDescription="
				+ reasonDescription + ", orderTag=" + orderTag + ", optionSymbol=" + optionSymbol + "]";
	}
	

}
