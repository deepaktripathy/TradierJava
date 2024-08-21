package com.deepaktripathy.tradierjava.client.fundamental.response.statistics;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Tables extends UnrecognizedFieldsCollector {

   @JsonProperty("price_statistics") 
   private PriceStatistics priceStatistics;

   @JsonProperty("trailing_returns") 
   private TrailingReturns trailingReturns;
}