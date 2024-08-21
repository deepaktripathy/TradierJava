package com.deepaktripathy.tradierjava.client.fundamental.response.ratios;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FinancialRatiosResponse {

   private List<RatiosRoot> ratios;
}
