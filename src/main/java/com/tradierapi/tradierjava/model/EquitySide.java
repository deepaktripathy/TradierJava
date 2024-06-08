package com.tradierapi.tradierjava.model;

public enum EquitySide {
	/**
	 * Buy stock/ETF
	 */
	buy, 
	
	/**
	 * Sell stock/ETF
	 */
	sell, 
	
	/**
	 * Short sell stock/ETF (if shorting is allowed)
	 */
	sell_short,
	
	/**
	 * Cover a Shorted stock/ETF (if shorting is allowed)
	 */
	buy_to_cover 
}
