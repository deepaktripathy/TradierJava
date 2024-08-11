package com.deepaktripathy.tradierjava.client.account.response;

public enum OrderStatus {
   /**
    * Order is not yet accepted by the queue
    */
   open,

   /**
    * Part of order is filled.
    */
   partially_filled,

   /**
    * The whole order is filled.
    */
   filled,

   /**
    * Expired
    */
   expired,

   /**
    * Order is canceled
    */
   canceled,

   /**
    * Order is pending
    */
   pending,

   /**
    * Order rejected by backoffice
    */
   rejected,

   /**
    * Unspecified error.
    */
   error
}
