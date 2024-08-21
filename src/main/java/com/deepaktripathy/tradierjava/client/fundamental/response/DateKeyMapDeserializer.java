package com.deepaktripathy.tradierjava.client.fundamental.response;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.deepaktripathy.tradierjava.client.fundamental.response.corpaction.SplitStat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Deserializes corpAction split results from <iso-date-string:split-ratio>
 * 
 * @author deepak
 *
 */
public class DateKeyMapDeserializer extends JsonDeserializer<Map<String, Object>> {

   private TypeReference<HashMap<LocalDate, SplitStat>> typeRef = new TypeReference<HashMap<LocalDate, SplitStat>>() {};

   @Override
   public Map<String, Object> deserialize(JsonParser p, DeserializationContext ctxt, Map<String, Object> target) throws IOException, JsonProcessingException {

       Map<LocalDate, SplitStat> map = new ObjectMapper().readValue(p, typeRef);

       for(Entry<LocalDate, SplitStat> e : map.entrySet()){
          System.out.println("key: " + e.getKey());
          System.out.println("value: " + e.getValue());
       }

       return target;
   }

   @Override
   public Map<String, Object> deserialize(JsonParser paramJsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
       return this.deserialize(paramJsonParser, ctxt, new HashMap<>());
   }

}