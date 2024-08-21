package com.deepaktripathy.tradierjava.client.fundamental.response.corpaction; 
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString; 

@Getter
@ToString
public class SplitStat extends UnrecognizedFieldsCollector {
   
    @JsonProperty("share_class_id")
    private String shareClassId;
    
    @JsonProperty("ex_date")
    private String exDate;

    @JsonProperty("adjustment_factor")
    double adjustmentFactor;

    @JsonProperty("split_from")
    double splitFrom;
    
    @JsonProperty("split_to")
    double splitTo;

    @JsonProperty("split_type")
    private String splitType;
}
