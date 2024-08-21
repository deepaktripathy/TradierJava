package com.deepaktripathy.tradierjava.client.fundamental.response.corpaction; 
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.deepaktripathy.tradierjava.client.fundamental.DateKeyDeserializer;
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;
import lombok.ToString; 

@Getter
@ToString
public class Tables extends UnrecognizedFieldsCollector {
   
   @JsonProperty("mergers_and_acquisitions")
   private List<MergersAndAcquisition> mergersAndAcquisitions;

   @JsonProperty("stock_splits")
   @JsonDeserialize(keyUsing = DateKeyDeserializer.class)
   private Map<LocalDate, SplitStat> stockSplitStatMap;
}
