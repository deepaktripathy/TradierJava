package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.util.Objects;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */
public class Greeks extends UnrecognizedFieldsCollector {
   
   @JsonProperty("delta")
   private Double delta;
   
   @JsonProperty("gamma")
   private Double gamma;
   
   @JsonProperty("theta")
   private Double theta;
   
   @JsonProperty("vega")
   private Double vega;
   
   @JsonProperty("rho")
   private Double rho;
   
   @JsonProperty("phi")
   private Double phi;

   @JsonProperty("bid_iv")
   private Double bidIv;
   
   @JsonProperty("mid_iv")
   private Double midIv;
   
   @JsonProperty("ask_iv")
   private Double askIv;
   
   @JsonProperty("smv_vol")
   private Double smvVol;
   
   @JsonProperty("updated_at")
   private String updatedAt;// TODO: convert it to a date?

   public Double getDelta() {
      return delta;
   }

   public Double getGamma() {
      return gamma;
   }

   public Double getTheta() {
      return theta;
   }

   public Double getVega() {
      return vega;
   }

   public Double getRho() {
      return rho;
   }

   public Double getPhi() {
      return phi;
   }

   public Double getBidIv() {
      return bidIv;
   }

   public Double getMidIv() {
      return midIv;
   }

   public Double getAskIv() {
      return askIv;
   }

   public Double getSmvVol() {
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
