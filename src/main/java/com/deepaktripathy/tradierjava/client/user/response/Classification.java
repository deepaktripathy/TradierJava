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

   /** Missing in the doc, added here */
   individual,

   individual_cash,

   entity_cash,

   entity_margin,

   individual_margin,

   joint_margin_survivor,

   joint_cash_survivor,

   traditional_ira,

   roth_ira,

   rollover_ira,

   sep_ira,

   custodial_cash,

   traditional_sep_ira,

   joint_margin_tenant
}
