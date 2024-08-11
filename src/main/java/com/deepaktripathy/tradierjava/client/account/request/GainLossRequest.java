package com.deepaktripathy.tradierjava.client.account.request;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.deepaktripathy.tradierjava.utils.Utils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GainLossRequest {

   @JsonProperty("page")
   Integer page;

   @JsonProperty("limit")
   Integer limit;

   @JsonProperty("sort_by")
   SortByColumn sortBy;

   @JsonProperty("sort")
   SortDirection sortDirection;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
   @JsonProperty("start_date")
   LocalDate startDate;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
   @JsonProperty("end_date")
   LocalDate endDate;

   @JsonProperty("symbol")
   String symbol;

   @javax.annotation.Nullable
   public Integer getPage() {
      return page;
   }

   public void setPage(Integer page) {
      this.page = page;
   }

   @javax.annotation.Nullable
   public Integer getLimit() {
      return limit;
   }

   public void setLimit(Integer limit) {
      this.limit = limit;
   }

   @javax.annotation.Nullable
   public SortByColumn getSortBy() {
      return sortBy;
   }

   public void setSortBy(SortByColumn sortBy) {
      this.sortBy = sortBy;
   }

   @javax.annotation.Nullable
   public SortDirection getSortDirection() {
      return sortDirection;
   }

   public void setSortDirection(SortDirection sortDirection) {
      this.sortDirection = sortDirection;
   }

   @javax.annotation.Nullable
   public LocalDate getStartDate() {
      return startDate;
   }

   public void setStartDate(LocalDate startDate) {
      this.startDate = startDate;
   }

   @javax.annotation.Nullable
   public LocalDate getEndDate() {
      return endDate;
   }

   public void setEndDate(LocalDate endDate) {
      this.endDate = endDate;
   }

   @javax.annotation.Nullable
   public String getSymbol() {
      return symbol;
   }

   public void setSymbol(String symbol) {
      this.symbol = symbol;
   }

   @Override
   public int hashCode() {
      return Objects.hash(endDate, limit, page, sortBy, sortDirection, startDate, symbol);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      GainLossRequest other = (GainLossRequest) obj;
      return Objects.equals(endDate, other.endDate) && Objects.equals(limit, other.limit)
            && Objects.equals(page, other.page) && sortBy == other.sortBy && sortDirection == other.sortDirection
            && Objects.equals(startDate, other.startDate) && Objects.equals(symbol, other.symbol);
   }

   @Override
   public String toString() {
      return "GainLossRequest [page=" + page + ", limit=" + limit + ", sortBy=" + sortBy + ", sortDirection="
            + sortDirection + ", startDate=" + startDate + ", endDate=" + endDate + ", symbol=" + symbol + "]";
   }

   /** Returns a map of keys and values */
   public Map<String, String> buildParametersMap() {
      Map<String, String> paramsMap = new HashMap<>();

      Utils.addIfValid(paramsMap, "page", page);
      Utils.addIfValid(paramsMap, "limit", limit);
      Utils.addIfValid(paramsMap, "sort_by", sortBy);
      Utils.addIfValid(paramsMap, "sort", sortDirection);
      Utils.addIfValid(paramsMap, "start_date", startDate);
      Utils.addIfValid(paramsMap, "end_date", endDate);
      Utils.addIfValid(paramsMap, "symbol", symbol);

      return paramsMap;
   }
}
