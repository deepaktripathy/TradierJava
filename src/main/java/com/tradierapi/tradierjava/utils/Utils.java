package com.tradierapi.tradierjava.utils;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Created by Deepak Tripathy on 5/17/2024.
 */
public class Utils {

    public static String isoDate(long millisecondsSinceEpoch) {
        final long millisPerDay = 1000 * 60 * 60 * 24;
        return java.time.LocalDate.ofEpochDay(millisecondsSinceEpoch / millisPerDay).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static String isoDate(LocalDate date) {
        final long millisPerDay = 1000 * 60 * 60 * 24;
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
    
    public static long epochMilliseconds(LocalDate date) {
        final long millisPerDay = 1000 * 60 * 60 * 24;
        return date.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
    }
    
    /**
     * Returns an ObjectMapper configured to handle new java.time & single list element. 
     * */
    public static ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());//may be needed to de/serialize ZonedDateTime
		//the json creator should NOT create single entry array content as objects!
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper;
    }
}
