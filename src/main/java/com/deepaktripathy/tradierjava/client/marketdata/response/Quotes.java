package com.deepaktripathy.tradierjava.client.marketdata.response;

import java.util.List;

import com.deepaktripathy.tradierjava.client.model.response.UnmatchedSymbols;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

/**
 * 
 * @author deepak tripathy created on 05/24/2024
 *
 */

@Getter
@ToString
public class Quotes {
   
   @JsonProperty("quote")
   private List<Quote> quotes;

   @JsonProperty("unmatched_symbols")
   private UnmatchedSymbols unmatchedSymbols;
}