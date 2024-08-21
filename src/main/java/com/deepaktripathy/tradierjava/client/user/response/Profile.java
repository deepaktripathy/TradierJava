package com.deepaktripathy.tradierjava.client.user.response;

import java.util.List;

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
public class Profile extends UnrecognizedFieldsCollector {
   
   @JsonProperty("account")
   private List<Account> accounts;
   
   @JsonProperty("id")
   private String id;

   @JsonProperty("name")
   private String name;
}