package com.tradierapi.tradierjava.client;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.tradierapi.tradierjava.model.HistoricPrice;
import com.tradierapi.tradierjava.model.Option;
import com.tradierapi.tradierjava.model.Order;
import com.tradierapi.tradierjava.model.OrderRequest;
import com.tradierapi.tradierjava.model.Position;
import com.tradierapi.tradierjava.model.Profile;
import com.tradierapi.tradierjava.model.Quote;
import com.tradierapi.tradierjava.model.Security;
import com.tradierapi.tradierjava.model.StockSplitInfo;

/**
 * Currently this works and returns data for a single account. Decide if the client should lock to the 
 * initially supplied account that can be set via constructor or be flexible to take an accountId argument 
 * for most of the functions, like getOrders() or getPositions().
 *  
 * Created by Deepak Tripathy on 5/17/2024.
 */
public interface TradierClient {

    public static final String KEY_ACCOUNT_ACCOUNT_TYPE = "account_type";
    public static final String KEY_ACCOUNT_TOTAL_CASH = "total_cash";
    public static final String KEY_ACCOUNT_PENDING_CASH = "pending_cash";//cash allocated for pending orders
    public static final String KEY_ACCOUNT_CASH_AVAILABLE = "cash_available";//in a CASH account
    public static final String KEY_ACCOUNT_STOCK_BP = "stock_buying_power";//in a Margin account
    public static final String KEY_ACCOUNT_OPTION_BP = "option_buying_power";//in a Margin account

    Quote getQuote(String symbol);

    Collection<Quote> getQuotes(String... symbols);

    /**
     * If fromDate is after toDate or any of these are zero/negative, throws IllegalArgumentException
     *  
     * Note: from/to dates are epochMilliseconds not seconds.
     * */
    List<HistoricPrice> getHistory(String symbol, long fromDateMillisFromEpoch, long toDateMillisFromEpoch);

    /**
     * If fromDate is after toDate, throws IllegalArgumentException
     */ 
    List<HistoricPrice> getHistory(String symbol, LocalDate fromDate, LocalDate toDate);

    List<HistoricPrice> getHistory(String symbol);
    
    /**
     * Look up stocks, etfs, indices as well as individual option symbols.
     * */
    Optional<Security> lookupSymbol(String symbol);

    /** 
     * Returns all the options traded for an underlying stock.
     * */
    List<String> lookupOptionSymbolsFor(String underlyingSymbol);
    
    /**
     * Looks up an order by orderId
     * 
     */
    Optional<Order> lookupOrder(long orderId);
    
    /**
     * Lookup orders by the supplied parameters.
     * */
    List<Order> lookupOrders(String status,	Integer limitCount, String afterTimestamp, String untilTimestamp,
    		 							String symbols, String side);
    
    /** 
     * Returns all the unfilled orders
     * */
    List<Order> getOrders();

    /** Returns all the positions under an account */
    List<Position> getPositions();

    /**
     * Posts a stock only order 
     * */
    long postStockOrder(OrderRequest order);

    /**
     * Posts an Option order. 
     * 
     * Request must have both the symbol as well as optionSymbol present.
     * */
    long postOptionOrder(OrderRequest order);

    /** 
     * Tradier API site notes: You can only modify some of the parameters like type, duration, price 
     * and stopPrice. You may not change the session of a pre/post market session order. Send only the 
     * parameters you would like to adjust,
     * 
     * TODO: Ask Tradier on why NOT quantity?
     * */
    long modifyOrder(long orderId, String type, String duration, Double price, Double stopPrice);
    
    /**
     * Cancels an unfilled order.  
     * */
    long cancelOrder(long orderId);
    
    /**
     * Currently only support one account, so no need to pass accountId.
     * Returns these parameters: 
     * account_type, total_cash, cash_available, stock_buying_power, option_buying_power
     * */
    Map<String, Object> getAccountBalances(String account);

    /**
     * Currently only support one account, so no need to pass accountId.
     * Returns these parameters: 
     * account_type, total_cash, cash_available, stock_buying_power, option_buying_power
     * */
    Profile getUserProfile();

    /** 
     * An option chain is all calls+puts for a single expiration. Since this may take a lot of resources, 
     * have another method to filter out these. 
     * */
    List<Option> getOptionChainFor(String underlyingSymbol, LocalDate expieryDate);
    
    /** 
     * Returns all the future option expiery dates for a stock
     * */
    List<LocalDate> getOptionExpieryDates(String underlyingStockSymbol);
    
}
