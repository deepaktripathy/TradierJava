package com.tradierapi.tradierjava.client;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.tradierapi.tradierjava.model.ExchangeCode;
import com.tradierapi.tradierjava.model.SecurityType;
import com.tradierapi.tradierjava.model.request.EquityOrderRequest;
import com.tradierapi.tradierjava.model.request.OptionOrderRequest;
import com.tradierapi.tradierjava.model.response.Balances;
import com.tradierapi.tradierjava.model.response.HistoricPrice;
import com.tradierapi.tradierjava.model.response.Interval;
import com.tradierapi.tradierjava.model.response.Option;
import com.tradierapi.tradierjava.model.response.Order;
import com.tradierapi.tradierjava.model.response.Position;
import com.tradierapi.tradierjava.model.response.Profile;
import com.tradierapi.tradierjava.model.response.Quote;
import com.tradierapi.tradierjava.model.response.Security;
import com.tradierapi.tradierjava.model.response.SessionFilter;

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

    /**
     * Includes greeks for options only 
     * */
    @Nullable
    Optional<Quote> getQuote(@Nonnull String symbol, @Nullable Boolean includeGreeks);

    /**
     * Includes greeks for options only 
     * */
    List<Quote> getQuotes(@Nonnull List<String> symbols, @Nullable Boolean includeGreeks);

    /**
     * If fromDate is after toDate, throws IllegalArgumentException
     */ 
    List<HistoricPrice> getPriceHistory(@Nonnull String symbol, @Nullable Interval interval, 
    		@Nullable LocalDate fromDate, @Nullable LocalDate toDate, @Nullable SessionFilter sessionFilter);

    /** 
     * Returns all the daily extennded session history as available between two dates
     * */
    List<HistoricPrice> getPriceHistory(@Nonnull String symbol, 
    		@Nullable LocalDate fromDate, @Nullable LocalDate toDate);
    
    /** 
     * Returns all the history as available
     * */
    List<HistoricPrice> getPriceHistory(@Nonnull String symbol);
    
    /**
     * Look up stocks, etfs, indices as well as individual option symbols.
     * 
     * Note: This will be extremely slow since this will do a huge lookup. It is suggested to 
     * use the overloaded method with a supplied type.
     * */
    Optional<Security> lookupSymbol(@Nonnull String symbol);

    /**
     * Look up stocks, etfs, indices as well as individual option symbols based on the 
     * supplied type.
     * */
    Optional<Security> lookupSymbol(@Nonnull String symbol, 
    		@Nonnull List<ExchangeCode> exchangeCodes, @Nonnull List<SecurityType> types);

    /** 
     * Returns all the options traded for an underlying stock.
     * 
     * Note: This will be extremely slow since this will do a huge lookup. It is 
     * suggested to use the overloaded method with supplied type(s).
     * */
    List<String> lookupOptionSymbolsFor(@Nonnull String underlyingSymbol);
    
    /**
     * Gets an order by orderId
     */
    Optional<Order> getOrder(@Nonnull Long orderId, @Nullable Boolean includeTags);
    
    /** 
     * Returns all the unfilled orders
     * */
    List<Order> getOrders(@Nullable Boolean includeTags);

    /** 
     * Returns all the positions under an account 
     * */
    List<Position> getPositions();

    /**
     * Posts a stock only order 
     * */
    long postStockOrder(EquityOrderRequest order);

    /**
     * Posts an Option order. 
     * 
     * Request must have both the symbol as well as optionSymbol present.
     * */
    long postOptionOrder(OptionOrderRequest order);

    /** 
     * Tradier API site notes: You can only modify some of the parameters like type, duration, price 
     * and stopPrice. You may not change the session of a pre/post market session order. Send only the 
     * parameters you would like to adjust,
     * 
     * TODO: Ask Tradier on why NOT quantity?
     * */
    long modifyOrder(@Nonnull Long orderId, @Nullable String type, @Nullable String duration, @Nullable Double price, @Nullable Double stopPrice);
    
    /**
     * Cancels an unfilled order.  
     * */
    long cancelOrder(@Nonnull Long orderId);
    
    /** 
     * Returns these parameters: 
     * account_type, total_cash, cash_available, stock_buying_power, option_buying_power
     * */
    Map<String, Object> getAccountCashBalances(@Nonnull String accountId);

    /**
     * Returns the account balance for the supplied account
     * */
    Balances getAccountBalances(@Nonnull String account);

    /**
     * Returns these parameters: 
     * account_type, total_cash, cash_available, stock_buying_power, option_buying_power
     * */
    Profile getUserProfile();

    /** 
     * An option chain is all calls+puts for a single expiration. Since this may take a lot of resources, 
     * have another method to filter out these. 
     * */
    List<Option> getOptionChainFor(@Nonnull String underlyingSymbol, @Nonnull LocalDate expieryDate, @Nullable Boolean greeks);
    
    /** 
     * Returns all the future option expiery dates for a stock
     * */
    List<LocalDate> getOptionExpieryDates(@Nonnull String underlyingStockSymbol);
 
    /** 
     * Tradier returns single digit exchange codes in some of the responses. 
     * This returns a static map of all the names to the respective exchange codes. 
     * */
    Map<String, String> getStockExchangeCodeMap();
    
    /** 
     * Tradier returns single digit exchange codes in some of the responses. 
     * This returns a static map of all the names to the respective option exchange codes. 
     * */
    Map<String, String> getOptionExchangeCodeMap();

}
