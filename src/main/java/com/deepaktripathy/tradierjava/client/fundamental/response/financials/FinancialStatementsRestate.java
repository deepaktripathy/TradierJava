package com.deepaktripathy.tradierjava.client.fundamental.response.financials;

import java.util.List;

import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FinancialStatementsRestate extends UnrecognizedFieldsCollector {
 
   @JsonProperty("company_id") 
   private String companyId;
 
   @JsonProperty("as_of_date") 
   private String asOfDate;
 
   @JsonProperty("balance_sheet") 
   private List<BalanceSheet> balanceSheet;
  
   @JsonProperty("cash_flow_statement") 
   private List<CashFlowStatement> cashFlowStatement;
   
   @JsonProperty("income_statement") 
   private List<IncomeStatement> incomeStatement;
}