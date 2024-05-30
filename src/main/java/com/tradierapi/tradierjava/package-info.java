/**
 * <p>The {@link com.tradierapi.tradierjava.client.TradierClient TradierClient} is the main interface into the API.</p>
 * 
 * <p>Tradier allows a paper trading mode and so needs a separate set of properties. But as a client, this does not need to know if the parameters are for paper or live. So, the implementing client should send the correct set of parameters for live/paper</p>
 * 
 * <pre class="code">
 *   //create tradier-config.properties in the classpath with your Tradier url, accountId & token.
 *
 *   TradierClient tradClient = new TradierRestClient();
 *   final Quote quote = tradClient.getQuote("TSLA");
 *
 *   System.out.println("Current price of TSLA: " + quote.getAsk());
 * </pre>
 *
 * <p>Or, if you don't want to deal with a properties file, you can just set them manually</p>
 * <pre class="code">
 *
 *   Properties props = new Properties();
 *   props.setProperty("tradierjava.api.url", "...");
 *   props.setProperty("tradierjava.api.accountid", "...");
 *   props.setProperty("tradierjava.api.token", "...");
 *
 *   TradierClient tradClient = new TradierRestClient();
 *   final Quote quote = tradClient.getQuote("TSLA");
 *
 *   System.out.println("Current price of TSLA: " + quote.getAsk());
 * </pre>
 *
 *
 */
package com.tradierapi.tradierjava;
