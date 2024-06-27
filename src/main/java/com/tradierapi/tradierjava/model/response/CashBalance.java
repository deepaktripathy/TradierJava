package com.tradierapi.tradierjava.model.response;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is part of Balances and is populated if the account_type is margin.
 * 
 * @author deepak
 *
 */
public class CashBalance {

    @JsonProperty("cash_available")
    private Double cashAvailable;

    @JsonProperty("sweep")
    private Double sweep;
    
    @JsonProperty("unsettled_funds")
    private Double unsettledFunds;
    
    @JsonProperty("fed_call")
    private Double fedCall;

    public Double getCashAvailable() {
		return cashAvailable;
	}

	public void setCashAvailable(Double cashAvailable) {
		this.cashAvailable = cashAvailable;
	}

	public Double getSweep() {
		return sweep;
	}

	public void setSweep(Double sweep) {
		this.sweep = sweep;
	}

	public Double getUnsettledFunds() {
		return unsettledFunds;
	}

	public void setUnsettledFunds(Double unsettledFunds) {
		this.unsettledFunds = unsettledFunds;
	}

	public Double getFedCall() {
		return fedCall;
	}

	public void setFedCall(Double fedCall) {
		this.fedCall = fedCall;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cashAvailable, fedCall, sweep, unsettledFunds);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CashBalance other = (CashBalance) obj;
		return Objects.equals(cashAvailable, other.cashAvailable) && Objects.equals(fedCall, other.fedCall)
				&& Objects.equals(sweep, other.sweep) && Objects.equals(unsettledFunds, other.unsettledFunds);
	}

	@Override
	public String toString() {
		return "CashBalance [cashAvailable=" + cashAvailable + ", sweep=" + sweep + ", unsettledFunds=" + unsettledFunds
				+ ", fedCall=" + fedCall + "]";
	}

}
