package com.deepaktripathy.tradierjava.client.fundamental;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

/**
 * Deserializes the stock splits data structured with a key which is a local date formatted to ISO_DATE. 
 * */
public class DateKeyDeserializer extends KeyDeserializer {
   @Override
   public LocalDate deserializeKey(String key, DeserializationContext ctxt) throws IOException, JsonProcessingException {
       //Use the string key here to return a real map key object
       return LocalDate.parse(key, DateTimeFormatter.ISO_DATE);
   }
}