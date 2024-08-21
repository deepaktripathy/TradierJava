package com.deepaktripathy.tradierjava.client.marketdata.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExpirationsResponse {
   
   @JsonProperty("expirations") 
   Expirations expirations;
}
