package com.deepaktripathy.tradierjava.client.model.response;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public abstract class UnrecognizedFieldsCollector {
   private static final Logger LOGGER = LoggerFactory.getLogger(UnrecognizedFieldsCollector.class);
   
   private Map<String, Object> unrecognizedFields = new HashMap<>();

   @JsonAnySetter
   private void setUnrecognizedFields(String key, Object value) {
       this.unrecognizedFields.put(key, value);
       String valueClass = (value == null) ?"null" :value.getClass().getSimpleName();
       LOGGER.debug("Unrecognized field found under class: " + this.getClass().getName() 
             + ", field: " + key + ", type: " + valueClass);
   }
   
   /** 
   Returns all the unrecognized fields and associated values 
   */
   public Map<String, Object> getUnrecognizedFields() {
      return unrecognizedFields;
   }

   @Override
   public int hashCode() {
      return Objects.hash(unrecognizedFields);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      UnrecognizedFieldsCollector other = (UnrecognizedFieldsCollector) obj;
      return Objects.equals(unrecognizedFields, other.unrecognizedFields);
   }

   
}
