package com.tradierapi.tradierjava.model.response;

public enum OrderClass {
	/**
	 * Stock order
	 */
	equity,
	
	/**
	 * Option order
	 */
	option, 
	
	combo, 
	
	multileg
}
