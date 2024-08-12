package com.deepaktripathy.tradierjava.client.fundamental.response.ratios; 
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty; 

public class Period3y extends UnrecognizedFieldsCollector {
    @JsonProperty("share_class_id") 
    private String shareClassID;

    @JsonProperty("as_of_date") 
    private String asOfDate;

    @JsonProperty("fiscal_year_end") 
    private String fiscalYearEnd;

    @JsonProperty("period") 
    private String period;

    @JsonProperty("report_type") 
    private String reportType;

    @JsonProperty("book_value_per_share_growth") 
    private Double bookValuePerShareGrowth;

    @JsonProperty("equity_per_share_growth") 
    private Double equityPerShareGrowth;

    @JsonProperty("d_p_s_growth") 
    private Double d_p_s_growth;

    @JsonProperty("diluted_cont_e_p_s_growth") 
    private Double dilutedContEpsGrowth;
    
    @JsonProperty("diluted_e_p_s_growth") 
    private Double dilutedEpsGrowth;
    
    @JsonProperty("f_c_f_per_share_growth") 
    private Double fcfPerShareGrowth;
    
    @JsonProperty("normalized_basic_e_p_s_growth") 
    private Double normalizedBasicEpsGrowth;

    @JsonProperty("normalized_diluted_e_p_s_growth") 
    private Double normalizedDilutedEpsGrowth;    
    
    @JsonProperty("c_f_o_growth3_month_avg") 
    private Double cFOGrowth3MonthAvg;
    
    @JsonProperty("capital_expenditure_annual5_yr_growth") 
    private Double capitalExpenditureAnnual5YrGrowth;
    
    @JsonProperty("cash_ratio_growth") 
    private Double cashRatioGrowth;
    
    @JsonProperty("company_id") 
    private String companyID;
    
    @JsonProperty("current_ratio_growth") 
    private Double currentRatioGrowth;
    
    @JsonProperty("e_b_i_t_d_a_growth") 
    private Double eBITDAGrowth;
    
    @JsonProperty("f_c_f_growth3_month_avg") 
    private Double fCFGrowth3MonthAvg;
    
    @JsonProperty("gross_profit_annual5_yr_growth") 
    private Double grossProfitAnnual5YrGrowth;
    
    @JsonProperty("net_income_cont_ops_growth") 
    private Double netIncomeContOpsGrowth;
    
    @JsonProperty("net_income_growth") 
    private Double netIncomeGrowth;
    
    @JsonProperty("operation_income_growth") 
    private Double operationIncomeGrowth;
    
    @JsonProperty("operation_revenue_growth3_month_avg") 
    private Double operationRevenueGrowth3MonthAvg;
    
    @JsonProperty("revenue_growth") 
    private Double revenueGrowth;
    
    @JsonProperty("stockholders_equity_growth") 
    private Double stockholdersEquityGrowth;
    
    @JsonProperty("total_assets_growth")
    private Double totalAssetsGrowth;
    
    @JsonProperty("total_debt_equity_ratio_growth") 
    private Double totalDebtEquityRatioGrowth;
    
    @JsonProperty("total_liabilities_growth") 
    private Double totalLiabilitiesGrowth;
}
