package com.deepaktripathy.tradierjava.client.fundamental.response.statistics;

import java.util.List;

public class StatisticsResponse {
   private List<StatisticsRoot> statistics;

   public List<StatisticsRoot> getStatistics() {
      return statistics;
   }

   public void setStatistics(List<StatisticsRoot> statistics) {
      this.statistics = statistics;
   }

   @Override
   public String toString() {
      return "StatisticsResponse [statistics=" + statistics + "]";
   }


}
