package com.deepaktripathy.tradierjava.client.fundamental.response.companystats;

import java.util.List;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;

public class CompanyStatisticsResponse extends UnrecognizedFieldsCollector{

   //private Root[] companyStatistics;
   private List<CompanyStatisticsRoot> companyStatistics;

   public List<CompanyStatisticsRoot> getCompanyStatistics() {
      return companyStatistics;
   }

   public void setCompanyStatistics(List<CompanyStatisticsRoot> companyStatistics) {
      this.companyStatistics = companyStatistics;
   }

   @Override
   public String toString() {
      //return "CompanyStatisticsResponse [companyStatisitcs=" + Arrays.toString(companyStatistics) + "]";
      return "CompanyStatisticsResponse [companyStatisitcs=" + companyStatistics + "]";
   }

}
