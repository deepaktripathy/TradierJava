package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisteredAddress extends UnrecognizedFieldsCollector {

   @JsonProperty("line1")
   private String line1;

   @JsonProperty("line2")
   private String line2;
   
   @JsonProperty("phone")
   private String phone;
   
   @JsonProperty("city")
   private String city;
   
   @JsonProperty("postal_code")
   private String postalCode;
   
   @JsonProperty("province")
   private String province;
   
   @JsonProperty("country")
   private String country;

}
