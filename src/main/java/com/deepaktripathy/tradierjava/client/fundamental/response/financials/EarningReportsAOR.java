package com.deepaktripathy.tradierjava.client.fundamental.response.financials;


import com.deepaktripathy.tradierjava.client.fundamental.response.financials.earningreports.Period12m;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.earningreports.Period3m;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.earningreports.Period6m;
import com.deepaktripathy.tradierjava.client.fundamental.response.financials.earningreports.Period9m;
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

/**
 * AOR stands for Annual Operating and Performance Reporting
 * This is similar to Earning reports.
 * 
 * @author deepak
 *
 */
@Getter
@ToString
public class EarningReportsAOR extends UnrecognizedFieldsCollector {

   @JsonProperty("period_12m") 
   private Period12m period12Mo;
   
   @JsonProperty("period_3m") 
   private Period3m period3Mo;
   
   @JsonProperty("period_6m") 
   private Period6m period6Mo;
   
   @JsonProperty("period_9m") 
   private Period9m period9Mo;
}