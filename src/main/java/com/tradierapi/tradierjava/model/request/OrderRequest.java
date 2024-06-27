package com.tradierapi.tradierjava.model.request;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.tradierapi.tradierjava.model.Duration;
import com.tradierapi.tradierjava.model.EquityClass;
import com.tradierapi.tradierjava.model.OrderType;
import com.tradierapi.tradierjava.utils.Utils;

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
	
	/** Returns all non-empty/null parameters as key-value pairs where each key is a valid API request key*/
    protected Map<String, String> getRequestParams() {
        Map<String, String> paramMap = new HashMap<>();
        Utils.addIfValid(paramMap, "class", equityClass);
        Utils.addIfValid(paramMap, "symbol", symbol);//stock/option symbol
        Utils.addIfValid(paramMap, "type", orderType);
        Utils.addIfValid(paramMap, "duration", duration);
        
        Utils.addIfValid(paramMap, "quantity", quantity);
        Utils.addIfValid(paramMap, "price", price);
        Utils.addIfValid(paramMap, "stop", stopPrice);
        Utils.addIfValid(paramMap, "tag", orderTag);
        
        return paramMap;
    }
    

}
