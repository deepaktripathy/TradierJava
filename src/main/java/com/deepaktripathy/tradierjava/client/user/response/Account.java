package com.deepaktripathy.tradierjava.client.user.response;

import java.time.ZonedDateTime;

import com.deepaktripathy.tradierjava.client.model.AccountType;
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
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
public class Account extends UnrecognizedFieldsCollector {
   
   @JsonProperty("account_number")
   private String accountNumber;
   
   @JsonProperty("classification")
   private Classification classification;
   
   @JsonProperty("date_created")
   private ZonedDateTime createDate;
   
   @JsonProperty("day_trader")
   private Boolean dayTrader;
   
   @JsonProperty("last_update_date")
   private ZonedDateTime lastUpdateDate;
   
   @JsonProperty("option_level")
   private Integer optionLevel;
   
   @JsonProperty("status")
   private AccountStatus status;
   
   @JsonProperty("type")
   private AccountType type;
}
