package com.deepaktripathy.tradierjava.client.fundamental.response.dividend;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DividendsResponse {

   private List<DividendRoot> dividends;
}
