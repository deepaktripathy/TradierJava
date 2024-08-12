package com.deepaktripathy.tradierjava.client.fundamental.response.corpaction; 
import java.util.Objects;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty; 

public class Result extends UnrecognizedFieldsCollector {
   @JsonProperty("type")
   private String type;

   @JsonProperty("id")
   private String id;

   @JsonProperty("tables")
   private Tables tables;

   public String getType() {
      return this.type;
   }
   public void setType(String type) {
      this.type = type;
   }

   public String getId() {
      return this.id;
   }
   public void setId(String id) {
      this.id = id;
   }

   public Tables getTables() {
      return this.tables; 
   }
   public void setTables(Tables tables) {
      this.tables = tables; 
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, tables, type);
   }
   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Result other = (Result) obj;
      return Objects.equals(id, other.id) && Objects.equals(tables, other.tables) && Objects.equals(type, other.type);
   }

   @Override
   public String toString() {
      return "Result [type=" + type + ", id=" + id + ", tables=" + tables + "]";
   }

}
