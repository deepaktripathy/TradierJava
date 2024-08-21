package com.deepaktripathy.tradierjava.client.fundamental.response.statistics;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StatisticsResponse {

   private List<StatisticsRoot> statistics;

}
