package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import java.util.List;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CompanyStatisticsResponse extends UnrecognizedFieldsCollector{

   private List<CompanyStatisticsRoot> companyStatistics;
}
