package com.tradierapi.tradierjava.model.request;

import java.util.Map;

import com.tradierapi.tradierjava.model.Duration;
import com.tradierapi.tradierjava.model.EquityClass;
import com.tradierapi.tradierjava.model.OptionSide;
import com.tradierapi.tradierjava.model.OrderType;
import com.tradierapi.tradierjava.utils.Utils;

/**
 * Fields from: https://documentation.tradier.com/brokerage-api/trading/place-option-order
 * 
 * @author deepak tripathy created on 06/96/2024
 *
 */
public class OptionOrderRequest extends OrderRequest {
    private OptionSide side;
    
    private String optionSymbol;
    
    public static OptionOrderRequest buildMarketOrder(OptionSide side, String symbol, 
    		Double quantity, OrderType orderType, Duration duration, Double stopPrice, 
    		String orderTag, String optionSymbol) {
    	return buildLimitOrder(side, symbol, quantity,
        		null, orderType, duration, stopPrice, orderTag, optionSymbol);
    }
    
    /**
     * The price should be actual option price. This should not be a multiple of 100.
     */
    public static OptionOrderRequest buildLimitOrder(OptionSide side, String symbol, 
    		Double quantity, Double price, 
    		OrderType orderType, Duration duration, Double stopPrice, String orderTag, String optionSymbol) {
    	
    	OptionOrderRequest request = new OptionOrderRequest(side, symbol, quantity, price, 
    			orderType, duration, stopPrice, orderTag, optionSymbol);
    	
    	return request;
    }
    
    private OptionOrderRequest() {
    	equityClass = EquityClass.option;
    }
    
    public OptionOrderRequest(OptionSide side, String symbol, Double quantity, Double price,
    		OrderType orderType, Duration duration, Double stopPrice, String orderTag, String optionSymbol) {
    	this.equityClass = EquityClass.option;
    	this.side = side;
    	this.orderType = orderType;
    	this.symbol = symbol;
    	this.quantity = quantity;
    	this.price = price;
    	this.orderType = orderType;
    	this.duration = duration;
    	this.stopPrice = stopPrice;
    	this.orderTag = orderTag;
    	
    	this.optionSymbol = optionSymbol;
    }

	public OptionSide getSide() {
		return side;
	}

	public EquityClass getEquityClass() {
		return equityClass;
	}

	public String getOptionSymbol() {
		return optionSymbol;
	}

	@Override
	public String toString() {
		return "OptionOrderRequest [side=" + side   
				+ ", equityClass=" + equityClass 
				+ ", optionSymbol=" + optionSymbol + "]";
	}    

	/** Returns all non-empty/null parameters as key-value pairs where each key is a valid API request key*/
	@Override
    public Map<String, String> getRequestParams() {
        Map<String, String> paramMap = super.getRequestParams();
        Utils.addIfValid(paramMap, "side", side);
        Utils.addIfValid(paramMap, "option_symbol", optionSymbol);

        return paramMap;
    }
}
