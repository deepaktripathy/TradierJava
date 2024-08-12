package com.deepaktripathy.tradierjava.client.fundamental.response.corpaction;

import java.util.List;
import java.util.Objects;

public class CorpActionResponse {

   private List<CorpActionRoot> corpActions;

   public List<CorpActionRoot> getCorpActions() {
      return corpActions;
   }

   public void setCorpActions(List<CorpActionRoot> corpActions) {
      this.corpActions = corpActions;
   }

   @Override
   public int hashCode() {
      return Objects.hash(corpActions);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      CorpActionResponse other = (CorpActionResponse) obj;
      return Objects.equals(corpActions, other.corpActions);
   }

   @Override
   public String toString() {
      //return "CompanyStatisticsResponse [companyStatisitcs=" + Arrays.toString(companyStatistics) + "]";
      return "CorpActionResponse [corpActions=" + corpActions + "]";
   }  
}
