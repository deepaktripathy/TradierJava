package com.deepaktripathy.tradierjava.client.fundamental.response.ratios.alphabeta; 
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Period48m extends UnrecognizedFieldsCollector {
   
   @JsonProperty("alpha") 
   private Double alpha;

   @JsonProperty("as_of_date") 
   private String asOfDate;
   
   @JsonProperty("beta") 
   private Double beta;
   
   @JsonProperty("non_div_alpha") 
   private Double nonDivAlpha;
   
   @JsonProperty("non_div_beta") 
   private Double nonDivBeta;
   
   @JsonProperty("non_div_r_square") 
   private Double nonDivRSquare;
   
   @JsonProperty("period") 
   private String period;
   
   @JsonProperty("r_square") 
   private Double rSquare;
   
   @JsonProperty("share_class_id") 
   private String shareClassID;
}
