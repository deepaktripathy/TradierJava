package com.deepaktripathy.tradierjava.client.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnmatchedSymbols {
   
   @JsonProperty("symbol")
   private List<String> symbols;

}