package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Headquarter extends UnrecognizedFieldsCollector {
   @JsonProperty("address_line1")
   private String addressLine1;

   @JsonProperty("address_line2")
   private String addressLine2;

   @JsonProperty("city")
   private String city;

   @JsonProperty("country")
   private String country;

   @JsonProperty("homepage")
   private String homepage;

   @JsonProperty("phone")
   private String phone;

   @JsonProperty("postal_code")
   private String postalCode;

   @JsonProperty("province")
   private String province;

   @JsonProperty("fax")
   private String fax;


}
