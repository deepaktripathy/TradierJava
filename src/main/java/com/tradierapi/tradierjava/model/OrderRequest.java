package com.tradierapi.tradierjava.model;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;
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
public abstract class OrderRequest {
    protected OrderType orderType;
    protected String symbol;    
    
    protected Double quantity;
    protected Duration duration;
    
    protected Double price;
    
    protected EquityClass equityClass;
    
    protected Double stopPrice;
    protected String orderTag;
    
    //can also be this format: yyyy-mm-ddTHH:mm:ss.SSSZ 
    protected LocalDateTime createDate;
    
    public OrderRequest() {}
    
	public OrderType getOrderType() {
		return orderType;
	}

	public String getSymbol() {
		return symbol;
	}

	public double getQuantity() {
		return quantity;
	}

	public Duration getDuration() {
		return duration;
	}

	public double getPrice() {
		return price;
	}

	public EquityClass getEquityClass() {
		return equityClass;
	}

	public double getStopPrice() {
		return stopPrice;
	}

	public String getOrderTag() {
		return orderTag;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	@Override
	public String toString() {
		return "OrderRequest [orderType=" + orderType + ", symbol=" + symbol + ", quantity="
				+ quantity + ", duration=" + duration + ", price=" + price + ", createDate=" + createDate
				+ ", equityClass=" + equityClass + ", stopPrice=" + stopPrice + ", orderTag=" + orderTag
				+ "]";
	}    
}
