package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import java.util.List;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tables extends UnrecognizedFieldsCollector {
   @JsonProperty("company_profile")
   private CompanyProfile companyProfile;

   @JsonProperty("asset_classification")
   private AssetClassification assetClassification;

   @JsonProperty("historical_asset_classification")
   private HistoricalAssetClassification historicalAssetClassification;

   @JsonProperty("long_descriptions")
   private String longDescriptions;

   @JsonProperty("ownership_summary")
   private OwnershipSummary ownershipSummary;

   @JsonProperty("share_class_profile")
   private ShareClassProfile shareClassProfile;

   @JsonProperty("ownership_details")
   private List<OwnershipDetail> ownershipDetails;

   @JsonProperty("share_class")
   private ShareClass shareClass;



}