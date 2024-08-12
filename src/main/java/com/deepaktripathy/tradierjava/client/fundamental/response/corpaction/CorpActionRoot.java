package com.deepaktripathy.tradierjava.client.fundamental.response.corpaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CorpActionRoot extends UnrecognizedFieldsCollector {
   @JsonProperty("request")
   private String request;

   @JsonProperty("type")
   private String type;

   @JsonProperty("results")
   private List<Result> results;

   @JsonProperty("error") 
   private String error;
   
   public String getRequest() {
      return this.request; 
   }
   public void setRequest(String request) {
      this.request = request; 
   }

   public String getType() {
      return this.type; 
   }
   public void setType(String type) {
      this.type = type; 
   }

   public List<Result> getResults() {
      return this.results; 
   }
   public void setResults(ArrayList<Result> results) {
      this.results = results; 
   }
   
   public String getError() {
      return error;
   }
   public void setError(String error) {
      this.error = error;
   }
   
   @Override
   public int hashCode() {
      return Objects.hash(error, request, results, type);
   }
   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      CorpActionRoot other = (CorpActionRoot) obj;
      return Objects.equals(error, other.error) && Objects.equals(request, other.request)
            && Objects.equals(results, other.results) && Objects.equals(type, other.type);
   }
   @Override
   public String toString() {
      return "CorpActionRoot [request=" + request + ", type=" + type + ", results=" + results + ", error=" + error
            + "]";
   } 
   
}
