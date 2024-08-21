package com.deepaktripathy.tradierjava.client.user.response;

/**
 * Account type/class.
 * 
 * Fields from:
 * https://documentation.tradier.com/brokerage-api/reference/response/profile
 * 
 * @author deepak
 *
 */
public enum Classification {

   custodial_cash,

   entity_cash,

   entity_margin,

   /** Missing in the doc, added here */
   individual,

   individual_cash,

   individual_margin,

   joint_cash_survivor,

   joint_margin_survivor,

   joint_margin_tenant,

   rollover_ira,

   roth_ira,

   sep_ira,

   traditional_ira,

   traditional_sep_ira
}
