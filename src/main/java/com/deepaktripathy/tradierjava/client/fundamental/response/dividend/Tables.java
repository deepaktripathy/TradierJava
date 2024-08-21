package com.deepaktripathy.tradierjava.client.fundamental.response.dividend;

import java.util.List;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Tables extends UnrecognizedFieldsCollector {

   @JsonProperty("cash_dividends") 
   private List<CashDividend> cashDividends;
}