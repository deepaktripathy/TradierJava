package com.deepaktripathy.tradierjava.client.fundamental.response;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deepaktripathy.tradierjava.client.fundamental.response.corpaction.SplitStat;
import com.deepaktripathy.tradierjava.client.marketdata.MarketDataAPI;
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
   private static final Logger LOGGER = LoggerFactory.getLogger(DateKeyMapDeserializer.class);

   private TypeReference<HashMap<LocalDate, SplitStat>> typeRef = new TypeReference<HashMap<LocalDate, SplitStat>>() {};

   @Override
   public Map<String, Object> deserialize(JsonParser p, DeserializationContext ctxt, Map<String, Object> target) throws IOException, JsonProcessingException {

       Map<LocalDate, SplitStat> map = new ObjectMapper().readValue(p, typeRef);

       for(Entry<LocalDate, SplitStat> e : map.entrySet()){
          LOGGER.debug("key: " + e.getKey());
          LOGGER.debug("value: " + e.getValue());
       }

       return target;
   }

   @Override
   public Map<String, Object> deserialize(JsonParser paramJsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
       return this.deserialize(paramJsonParser, ctxt, new HashMap<>());
   }

}