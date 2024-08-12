package com.deepaktripathy.tradierjava.client.fundamental.response.ratios; 
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty; 

public class Period36m extends UnrecognizedFieldsCollector {
   @JsonProperty("share_class_id") 
   private String shareClassID;

   @JsonProperty("as_of_date") 
   private String asOfDate;

   @JsonProperty("period") 
   private String period;

   @JsonProperty("alpha") 
   private Double alpha;

   @JsonProperty("beta") 
   private Double beta;

   @JsonProperty("non_div_alpha") 
   private Double nonDivAlpha;

   @JsonProperty("non_div_beta") 
   private Double nonDivBeta;

   @JsonProperty("non_div_r_square") 
   private Double nonDivRSquare;

   @JsonProperty("r_square") 
   private Double rSquare;

   @Override
   public String toString() {
      return "Period36m [shareClassID=" + shareClassID + ", asOfDate=" + asOfDate + ", period=" + period + ", alpha="
            + alpha + ", beta=" + beta + ", nonDivAlpha=" + nonDivAlpha + ", nonDivBeta=" + nonDivBeta
            + ", nonDivRSquare=" + nonDivRSquare + ", rSquare=" + rSquare + "]";
   }
}
