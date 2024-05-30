package com.tradierapi.tradierjava.model;

import java.beans.ConstructorProperties;
import java.time.ZonedDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Fields from: https://documentation.tradier.com/brokerage-api/reference/response/orders
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */
public class OrderRequest {
    private String orderType;
    private String symbol;    
    private String side;
    
    private double quantity;
    private String duration;
    
    private double price;
    
    //can also be this format: yyyy-mm-ddTHH:mm:ss.SSSZ 
    private ZonedDateTime createDate;
    private String equityClass;
    
    private String optionSymbol;
    
    private double stopPrice;
    private String orderTag;
    
    //basic stock/option order constructor
    //TODO: Have to create separate order classes, order & orderStatus
    public OrderRequest(String symbol, String type, String side, double quantity, String duration,
			double price, ZonedDateTime create_date, String equityClass, double stopPrice, String orderTag, String optionSymbol) {
    	
		this.orderType = type;
		this.symbol = symbol;
		this.side = side;
		this.quantity = quantity;
		this.duration = duration;
		this.price = price;
		this.createDate = create_date;
		this.equityClass = equityClass;
		
		//stop price parameter.
		this.stopPrice = stopPrice;
		this.orderTag = orderTag;
		
		this.optionSymbol = optionSymbol;
    }

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ZonedDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(ZonedDateTime createDate) {
		this.createDate = createDate;
	}

	public String getEquityClass() {
		return equityClass;
	}

	public void setEquityClass(String equityClass) {
		this.equityClass = equityClass;
	}

	public String getOptionSymbol() {
		return optionSymbol;
	}

	public void setOptionSymbol(String optionSymbol) {
		this.optionSymbol = optionSymbol;
	}

	public double getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(double stopPrice) {
		this.stopPrice = stopPrice;
	}

	public String getOrderTag() {
		return orderTag;
	}

	public void setOrderTag(String orderTag) {
		this.orderTag = orderTag;
	}

	@Override
	public String toString() {
		return "OrderRequest [orderType=" + orderType + ", symbol=" + symbol + ", side=" + side + ", quantity="
				+ quantity + ", duration=" + duration + ", price=" + price + ", createDate=" + createDate
				+ ", equityClass=" + equityClass + ", stopPrice=" + stopPrice + ", orderTag=" + orderTag
				+ ", optionSymbol=" + optionSymbol + "]";
	}    
}
