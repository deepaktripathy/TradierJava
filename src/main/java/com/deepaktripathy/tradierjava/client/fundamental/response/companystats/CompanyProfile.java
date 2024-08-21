package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CompanyProfile extends UnrecognizedFieldsCollector {
   
   @JsonProperty("company_id")
   private String companyId;

   @JsonProperty("average_employee_number")
   private Integer averageEmployeeNumber;

   @JsonProperty("contact_email")
   private String contactEmail;

   @JsonProperty("headquarter")
   Headquarter headquarter;

   @JsonProperty("is_head_office_same_with_registered_office_flag")
   boolean isHeadOfficeSameWithRegisteredOfficeFlag;

   @JsonProperty("total_employee_number")
   private Integer totalEmployeeNumber;

   @JsonProperty("TotalEmployeeNumber.asOfDate")
   private String totalEmployeeNumberAsOfDate;
   
   @JsonProperty("registered_address")
   RegisteredAddress registeredAddress;
}