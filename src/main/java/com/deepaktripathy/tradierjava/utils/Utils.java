package com.deepaktripathy.tradierjava.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Created by Deepak Tripathy on 5/17/2024.
 */
public class Utils {

   public static ZoneId etZone = ZoneId.of("America/New_York");

   /** Returns a local date from milliseconds since epoch */
   public static LocalDate localDate(long millisecondsSinceEpoch) {
      final long millisPerDay = 1000 * 60 * 60 * 24;
      return java.time.LocalDate.ofEpochDay(millisecondsSinceEpoch / millisPerDay);
   }

   /**
    * Returns the String representation in DateTimeFormatter.ISO_LOCAL_DATE format
    */
   public static String isoDate(long millisecondsSinceEpoch) {
      final long millisPerDay = 1000 * 60 * 60 * 24;
      return java.time.LocalDate.ofEpochDay(millisecondsSinceEpoch / millisPerDay)
            .format(DateTimeFormatter.ISO_LOCAL_DATE);
   }

   /**
    * Returns the String representation in DateTimeFormatter.ISO_LOCAL_DATE format
    */
   public static String isoDate(LocalDate date) {
      // final long millisPerDay = 1000 * 60 * 60 * 24;
      return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
   }

   /**
    * Returns the String representation in DateTimeFormatter.ISO_LOCAL_DATE_TIME format
    */
   public static String isoDateTime(LocalDateTime dateTime) {
      // final long millisPerDay = 1000 * 60 * 60 * 24;
      return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
   }

   /** Returns time since epoch to UTC time */
   public static long epochMilliseconds(LocalDate date) {
      return date.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
   }

   /** Returns time at ET zone */
   public static ZonedDateTime zonedDateTime(long millisecondsSinceEpoch) {
      return ZonedDateTime.ofInstant(Instant.ofEpochMilli(millisecondsSinceEpoch), etZone);
   }

   public static String stripEndQuotes(final String quotedStr) {
      if (quotedStr != null) {
         String truncateStr = quotedStr;
         if (truncateStr.startsWith("\""))
            truncateStr = truncateStr.substring(1);
         if (truncateStr.endsWith("\""))
            truncateStr = truncateStr.substring(0, truncateStr.length() - 2);

         return truncateStr;
      }

      return quotedStr;
   }

   /**
    * Returns an ObjectMapper configured to handle new java.time & single list
    * element.
    */
   public static ObjectMapper objectMapper() {
      ObjectMapper mapper = new ObjectMapper();
      mapper.registerModule(new JavaTimeModule());// may be needed to de/serialize ZonedDateTime
      // the json creator should NOT create single entry array content as objects!
      mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
      return mapper;
   }

   /** Adds the key:value pair to the supplied map if the value is non-null */
   public static void addIfValid(Map map, String key, Object value) {
      if (value != null) {
         if (value instanceof String) {
            if (!((String) value).isEmpty())
               map.put(key, value);
         } else
            map.put(key, "" + value);
      }
   }

}
