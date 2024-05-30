package com.tradierapi.tradierjava.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */
public class Greeks {
    @JsonProperty("delta")
    private double delta;
    @JsonProperty("gamma")
    private double gamma;
    @JsonProperty("theta")
    private double theta;
    @JsonProperty("vega")
    private double vega;
    @JsonProperty("rho")
    private double rho;
    @JsonProperty("phi")
    private double phi;
    
    @JsonProperty("bid_iv")
    private double bidIv;
    @JsonProperty("mid_iv")
    private double midIv;
    @JsonProperty("ask_iv")
    private double askIv;
    @JsonProperty("smv_vol")
    private double smvVol;
    @JsonProperty("updated_at")
    private String updatedAt;//TODO: convert it to a date?
    
	public double getDelta() {
		return delta;
	}
	public double getGamma() {
		return gamma;
	}
	public double getTheta() {
		return theta;
	}
	public double getVega() {
		return vega;
	}
	public double getRho() {
		return rho;
	}
	public double getPhi() {
		return phi;
	}
	public double getBidIv() {
		return bidIv;
	}
	public double getMidIv() {
		return midIv;
	}
	public double getAskIv() {
		return askIv;
	}
	public double getSmvVol() {
		return smvVol;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(askIv, bidIv, delta, gamma, midIv, phi, rho, smvVol, theta, updatedAt, vega);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Greeks other = (Greeks) obj;
		return Double.doubleToLongBits(askIv) == Double.doubleToLongBits(other.askIv)
				&& Double.doubleToLongBits(bidIv) == Double.doubleToLongBits(other.bidIv)
				&& Double.doubleToLongBits(delta) == Double.doubleToLongBits(other.delta)
				&& Double.doubleToLongBits(gamma) == Double.doubleToLongBits(other.gamma)
				&& Double.doubleToLongBits(midIv) == Double.doubleToLongBits(other.midIv)
				&& Double.doubleToLongBits(phi) == Double.doubleToLongBits(other.phi)
				&& Double.doubleToLongBits(rho) == Double.doubleToLongBits(other.rho)
				&& Double.doubleToLongBits(smvVol) == Double.doubleToLongBits(other.smvVol)
				&& Double.doubleToLongBits(theta) == Double.doubleToLongBits(other.theta)
				&& Objects.equals(updatedAt, other.updatedAt)
				&& Double.doubleToLongBits(vega) == Double.doubleToLongBits(other.vega);
	}
	
	@Override
	public String toString() {
		return "Greeks [delta=" + delta + ", gamma=" + gamma + ", theta=" + theta + ", vega=" + vega + ", rho=" + rho
				+ ", phi=" + phi + ", bidIv=" + bidIv + ", midIv=" + midIv + ", askIv=" + askIv + ", smvVol=" + smvVol
				+ ", updatedAt=" + updatedAt + "]";
	}   
}
