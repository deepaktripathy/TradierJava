package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OwnershipDetail extends UnrecognizedFieldsCollector {
   @JsonProperty("share_class_id")
   private String shareClassId;

   @JsonProperty("as_of_date")
   private String asOfDate;

   @JsonProperty("owner_id")
   private String ownerId;

   @JsonProperty("owner_type")
   private String ownerType;

   @JsonProperty("currencyof_market_value")
   private String currencyofMarketValue;

   @JsonProperty("market_value")
   private Long marketValue;

   @JsonProperty("number_of_shares")
   private Integer numberOfShares;

   @JsonProperty("owner_c_i_k")
   private Integer ownerCIK;

   @JsonProperty("owner_name")
   private String ownerName;

   @JsonProperty("percentage_in_portfolio")
   private Double percentageInPortfolio;

   @JsonProperty("percentage_ownership")
   private Double percentageOwnership;

   @JsonProperty("share_change")
   private Integer shareChange;

   @JsonProperty("share_class_level_percentage_ownership")
   private Double shareClassLevelPercentageOwnership;
      
   @JsonProperty("status")
   private String status;
   
}