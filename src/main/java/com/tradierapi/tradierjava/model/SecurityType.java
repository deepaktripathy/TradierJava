package com.tradierapi.tradierjava.model;

/**
 * Security Type
 * Kept same name+case similar to what Tradier expects since we may be passing the text value.
 */
public enum SecurityType {
	/** 
	 * Stock type
	 */
	stock,
	
	/** 
	 * ETF type
	 */
	etf,
	
	/** 
	 * option type
	 */
	option,
	
	/** 
	 * index type
	 */
	index 
}
