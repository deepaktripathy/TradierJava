package com.deepaktripathy.tradierjava.client.fundamental.response.ratios; 
import com.deepaktripathy.tradierjava.client.model.response.UnrecognizedFieldsCollector;
import com.fasterxml.jackson.annotation.JsonProperty; 

public class Period5y extends UnrecognizedFieldsCollector {
    @JsonProperty("company_id") 
    private String companyID;
    
    @JsonProperty("as_of_date") 
    private String asOfDate;
    
    @JsonProperty("fiscal_year_end") 
    private String fiscalYearEnd;
    
    @JsonProperty("period") 
    private String period;
    
    @JsonProperty("report_type") 
    private String reportType;    

    @JsonProperty("regression_growth_operating_revenue5_years") 
    private Double regressionGrowthOperatingRevenue5Years;
    
    @JsonProperty("share_class_id") 
    private String shareClassID;
    
    @JsonProperty("book_value_per_share_growth") 
    private Double bookValuePerShareGrowth;
    
    @JsonProperty("equity_per_share_growth") 
    private Double equityPerShareGrowth;

    @JsonProperty("c_f_o_growth3_month_avg") 
    private Double cfoGrowth3MonthAvg;
    
    @JsonProperty("capital_expenditure_annual5_yr_growth") 
    private Double capitalExpenditureAnnual5YrGrowth;
    
    @JsonProperty("cash_ratio_growth") 
    private Double cashRatioGrowth;
    
    @JsonProperty("current_ratio_growth") 
    private Double currentRatioGrowth;
    
    @JsonProperty("d_p_s_growth")
    private Double dpsGrowth;
    
    @JsonProperty("diluted_cont_e_p_s_growth") 
    private Double dilutedContEpsGrowth;
    
    @JsonProperty("diluted_e_p_s_growth") 
    private Double dilutedEpsGrowth;
    
    @JsonProperty("e_b_i_t_d_a_growth") 
    private Double ebitdaGrowth;
    
    @JsonProperty("f_c_f_growth3_month_avg") 
    private Double fcfGrowth3MonthAvg;
    
    @JsonProperty("f_c_f_per_share_growth") 
    private Double fcfPerShareGrowth;
    
    @JsonProperty("gross_profit_annual5_yr_growth") 
    private Double grossProfitAnnual5YrGrowth;
    
    @JsonProperty("net_income_cont_ops_growth") 
    private Double netIncomeContOpsGrowth;
    
    @JsonProperty("net_income_growth") 
    private Double netIncomeGrowth;
    
    @JsonProperty("normalized_basic_e_p_s_growth") 
    private Double normalizedBasicEpsGrowth;
    
    @JsonProperty("normalized_diluted_e_p_s_growth") 
    private Double normalizedDilutedEpsGrowth;
    
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
    
    @JsonProperty("a_v_g5_yrs_r_o_i_c") 
    private Double aVG5YrsRoic;
    
    @JsonProperty("gross_margin5_yr_avg") 
    private Double grossMargin5YrAvg;
    
    @JsonProperty("post_tax_margin5_yr_avg")
    private Double postTaxMargin5YrAvg;
    
    @JsonProperty("pre_tax_margin5_yr_avg") 
    private Double preTaxMargin5YrAvg;
    
    @JsonProperty("profit_margin5_yr_avg")
    private Double profitMargin5YrAvg;
    
    @JsonProperty("r_o_a5_yr_avg") 
    private Double roa5YrAvg;
    
    @JsonProperty("r_o_e5_yr_avg") 
    private Double roe5YrAvg;

}
