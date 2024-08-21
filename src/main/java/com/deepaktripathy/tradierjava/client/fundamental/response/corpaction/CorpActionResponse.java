package com.deepaktripathy.tradierjava.client.fundamental.response.corpaction;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CorpActionResponse {

   private List<CorpActionRoot> corpActions;
}
