package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RegisteredAddress extends UnrecognizedFieldsCollector {

   @JsonProperty("city")
   private String city;

   @JsonProperty("country")
   private String country;
   
   @JsonProperty("line1")
   private String line1;
   
   @JsonProperty("line2")
   private String line2;
   
   @JsonProperty("phone")
   private String phone;
   
   @JsonProperty("postal_code")
   private String postalCode;
   
   @JsonProperty("province")
   private String province;
}
