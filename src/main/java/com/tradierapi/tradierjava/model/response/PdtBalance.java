package com.tradierapi.tradierjava.model.response;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is part of Balances and is populated if the account_type is marked as PDT.
 * 
 * @author deepak
 *
 */
public class PdtBalance {

    @JsonProperty("fed_call")
    private Double fedCall;

    @JsonProperty("maintenance_call")
    private Double maintenanceCall;
    
    @JsonProperty("option_buying_power")
    private Double optionBuyingPower;
    
    @JsonProperty("stock_buying_power")
    private Double stockBuyingPower;

    @JsonProperty("stock_short_value")
    private Double stockShortValue;

    
	public Double getFedCall() {
		return fedCall;
	}

	public void setFedCall(Double fedCall) {
		this.fedCall = fedCall;
	}

	public Double getMaintenanceCall() {
		return maintenanceCall;
	}

	public void setMaintenanceCall(Double maintenanceCall) {
		this.maintenanceCall = maintenanceCall;
	}

	public Double getOptionBuyingPower() {
		return optionBuyingPower;
	}

	public void setOptionBuyingPower(Double optionBuyingPower) {
		this.optionBuyingPower = optionBuyingPower;
	}

	public Double getStockBuyingPower() {
		return stockBuyingPower;
	}

	public void setStockBuyingPower(Double stockBuyingPower) {
		this.stockBuyingPower = stockBuyingPower;
	}

	public Double getStockShortValue() {
		return stockShortValue;
	}

	public void setStockShortValue(Double stockShortValue) {
		this.stockShortValue = stockShortValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fedCall, maintenanceCall, optionBuyingPower, stockBuyingPower, stockShortValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PdtBalance other = (PdtBalance) obj;
		return Objects.equals(fedCall, other.fedCall) && Objects.equals(maintenanceCall, other.maintenanceCall)
				&& Objects.equals(optionBuyingPower, other.optionBuyingPower)
				&& Objects.equals(stockBuyingPower, other.stockBuyingPower)
				&& Objects.equals(stockShortValue, other.stockShortValue);
	}

	@Override
	public String toString() {
		return "PdtBalance [fedCall=" + fedCall + ", maintenanceCall=" + maintenanceCall + ", optionBuyingPower="
				+ optionBuyingPower + ", stockBuyingPower=" + stockBuyingPower + ", stockShortValue=" + stockShortValue
				+ "]";
	}
    
}
