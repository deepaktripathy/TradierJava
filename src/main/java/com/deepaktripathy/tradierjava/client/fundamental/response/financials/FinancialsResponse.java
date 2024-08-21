package com.deepaktripathy.tradierjava.client.fundamental.response.financials;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FinancialsResponse {

   private List<FinancialsRoot> financials;
}
