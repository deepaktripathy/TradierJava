package com.tradierapi.tradierjava.client;

import static com.tradierapi.tradierjava.utils.Utils.isoDate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tradierapi.tradierjava.model.EquityOrderRequest;
import com.tradierapi.tradierjava.model.HistoricPrice;
import com.tradierapi.tradierjava.model.Option;
import com.tradierapi.tradierjava.model.OptionOrderRequest;
import com.tradierapi.tradierjava.model.Options;
import com.tradierapi.tradierjava.model.Order;
import com.tradierapi.tradierjava.model.Orders;
import com.tradierapi.tradierjava.model.Position;
import com.tradierapi.tradierjava.model.Positions;
import com.tradierapi.tradierjava.model.Profile;
import com.tradierapi.tradierjava.model.Quote;
import com.tradierapi.tradierjava.model.Quotes;
import com.tradierapi.tradierjava.model.Security;
import com.tradierapi.tradierjava.model.SecurityType;
import com.tradierapi.tradierjava.utils.Utils;

/**
 * Looks like we cant use Gson for parsing since Gson mangles all the numbers to doubles, even orderIds 
 * are returned as E'notations. So, Jackson is the better choice even though somewhat slower.
 * 
 * This has all the code using pure HttpClient & jackson similar to the Tradier API site examples.
 * But in the next change try to move to OkHttp since that feels faster and has better support.
 * 
 *  
 * Created by Deepak Tripathy on 5/17/2024.
 * 
 */
public class TradierRestClient implements TradierClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(TradierRestClient.class);

	protected static final String DEFAULT_PATH = "https://api.tradier.com/v1";
	
	//property keys
	private static String K_TRADIER_URL = "tradierjava.api.url";
	private static String K_TRADIER_ACCOUNTID = "tradierjava.api.accountid";
	private static String K_TRADIER_TOKEN = "tradierjava.api.token";

	private Properties tradierProps;
	private final Map<String, String> headers;

	public TradierRestClient() {
		this(null);
	}

	public TradierRestClient(Properties props) {
		LOGGER.info("Initiating TradierClient...");

		this.tradierProps = (props == null) ? initProps() : props;

		validateProps(this.tradierProps);
		
		this.headers = new HashMap<>();
		setupHeaders();
	}

	protected static Properties initProps() {
		try (InputStream in = TradierRestClient.class.getClassLoader()
				.getResourceAsStream("tradier-api-config.properties")) {
			Properties tradProperties = new Properties();
			tradProperties.load(in);
			return tradProperties;
		} catch (IOException e) {
			throw new IllegalArgumentException(
					"Could not load default properties from tradier-api-config.properties in classpath");
		}
	}
	
	  /**
	   * validates the necessary props like token and account id. If others are missing, just use
	   * friendly defaults.
	   *
	   * @param tdaProps the required props to validate
	   */
	  protected static void validateProps(Properties tradierProps) {
	    LOGGER.trace("Validating props: {}", tradierProps.toString());
	    String accountId = tradierProps.getProperty(K_TRADIER_ACCOUNTID);
	    if (StringUtils.isBlank(accountId)) {
	      throw new IllegalArgumentException(
	          "Missing tradierjava.api.accountid property. This is obtained from Tradier account API settings page");
	    }

	    String token = tradierProps.getProperty(K_TRADIER_TOKEN);
	    if (StringUtils.isBlank(token)) {
	      throw new IllegalArgumentException(
	          "Missing tradierjava.api.token property. This is obtained from the Tradier account API settings page when creating a authentication token");
	    }

	    String url = tradierProps.getProperty(K_TRADIER_URL);
	    if (StringUtils.isBlank(url)) {
	    	tradierProps.setProperty(K_TRADIER_URL, DEFAULT_PATH);
	    }
	  }


	private void setupHeaders() {
		headers.put("Authorization", "Bearer " + tradierProps.getProperty(K_TRADIER_TOKEN));
		//this removes all the 'POST' content of HttpClient. Dont use.
		//headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
	}

	@Override
	public Quote getQuote(String symbol) {

		Quote quote = null;
		try {
			String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "markets/quotes");
			URI uri = new URIBuilder(url)
					.build();
			RequestBuilder requestBuilder = RequestBuilder.get(uri);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			final HttpUriRequest request = requestBuilder
					.addParameter("symbols", symbol)
					.addParameter("greeks", "true")// we need a separate method for options to make it usable.
					.build();

			final HttpResponse response = HttpClientBuilder.create().build().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				final String responseEntity = EntityUtils.toString(response.getEntity());
				System.out.println("Entity: " + responseEntity);
				ObjectMapper mapper = Utils.objectMapper();
				final JsonNode jsonTree = mapper.readTree(responseEntity);    	    
				JsonNode quoteNode = jsonTree.findPath("quotes").findPath("quote");
				//Tradier returns single quote as an object while multi as an Array
				if(quoteNode.isObject()) {
					quote = mapper.treeToValue(quoteNode, Quote.class);
				}
				else {
					List<Quote> myQuotes = mapper.treeToValue(jsonTree.findPath("quotes"), Quotes.class).getQuotes();
					if(myQuotes != null && !myQuotes.isEmpty())
						quote = myQuotes.get(0);
				}
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(IOException|URISyntaxException ex) {
			throw new RuntimeException(ex);
		}
		return quote;
	}

	//TODO: Add retryable as Tradier sometimes refuses connection
	@Override
	public List<Quote> getQuotes(List<String> symbols) {
		List<Quote> quotes = new ArrayList<>();
		try {
			String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "markets/quotes");
			RequestBuilder requestBuilder = RequestBuilder.post(url);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			final HttpUriRequest request = requestBuilder
					.addParameter("symbols", symbols.stream().collect(Collectors.joining(",")))
					.addParameter("greeks", "true")
					.build();

			final HttpResponse response = HttpClientBuilder.create().build().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				final String responseEntity = EntityUtils.toString(response.getEntity());
				ObjectMapper mapper = Utils.objectMapper();
				final JsonNode jsonTree = mapper.readTree(responseEntity);
				JsonNode quoteNode = jsonTree.findPath("quotes").findPath("quote");
	
				//Tradier returns single quote as an object while multi as an Array
//				System.out.println("tree: " + jsonTree);
//				System.out.println("obj: " + quoteNode.isObject());
//				System.out.println("arr: " + quoteNode.isArray());
//				System.out.println("container: " + quoteNode.isContainerNode());
				if(quoteNode.isObject()) {
					Quote quote = mapper.treeToValue(quoteNode, Quote.class);
					quotes.add(quote);
				}
				else {
					List<Quote> myQuotes = mapper.treeToValue(jsonTree.findPath("quotes"), Quotes.class).getQuotes();
					if(myQuotes != null && !myQuotes.isEmpty())
						quotes.addAll(myQuotes);
				}
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		return quotes;
	}


	@Override
	public List<HistoricPrice> getHistory(String symbol) {
		return getHistory(symbol, null, null);
	}

	@Override
	public List<HistoricPrice> getHistory(String symbol, long fromDate, long toDate) {
		if(fromDate <= 0 || toDate <= 0)
			throw new IllegalArgumentException("From and To date values can not be zero or lower");
		return getHistory(symbol, LocalDate.ofEpochDay(fromDate), LocalDate.ofEpochDay(toDate));
	}

	@Override
	public List<HistoricPrice> getHistory(String symbol, LocalDate fromDate, LocalDate toDate) {
		if(fromDate != null && toDate != null && fromDate.isAfter(toDate))
			throw new IllegalArgumentException("From date can not be after To date");

		try {
			String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "markets/history");
			URI uri = new URIBuilder(url)
					.setParameter("symbol", symbol)
					.build();
			RequestBuilder requestBuilder = RequestBuilder.get(uri);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			if(fromDate != null && toDate != null) {
				requestBuilder.addParameter("start", isoDate(fromDate));
				requestBuilder.addParameter("end", isoDate(toDate));
			}
			final HttpUriRequest request = requestBuilder.build();

			final HttpResponse response = HttpClientBuilder.create().build().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				final String responseEntity = EntityUtils.toString(response.getEntity());
				ObjectMapper mapper = Utils.objectMapper();
				final JsonNode jsonTree = mapper.readTree(responseEntity);    	    
				JsonNode dayNode = jsonTree.findPath("history").findPath("day");
	
				if(dayNode.isNull() || dayNode.isMissingNode())
					return new ArrayList<>();
	
				//Tradier returns single quote as an object while multi as an Array
				if(dayNode.isObject()) {
					HistoricPrice historic = mapper.treeToValue(dayNode, HistoricPrice.class);
					return List.of(historic);
				}
				else {
					HistoricPrice[] historicArray = mapper.treeToValue(dayNode, HistoricPrice[].class);
					//direct mapping to List<> will not parse and will make List<LinkedHashMap<..>>. 
					//Rather map to a object[] and then stream to list
					if(historicArray.length > 0)
						return Arrays.stream(historicArray).collect(Collectors.toList());
				}
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(IOException|URISyntaxException ex) {
			throw new RuntimeException(ex);
		}
		return new ArrayList<>();
	}

	@Override
	public Optional<Security> lookupSymbol(String symbol) {
		List<SecurityType> types = new ArrayList();
		types.add(SecurityType.stock);
		types.add(SecurityType.option);
		types.add(SecurityType.etf);
		types.add(SecurityType.index);
		return lookupSymbol(symbol, types);
	}

	@Override
	public Optional<Security> lookupSymbol(String symbol, List<SecurityType> types) {
		try {
			String typesStr = types.stream().map(String::valueOf).collect(Collectors.joining(",")); 
			String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "markets/lookup");
			URI uri = new URIBuilder(url)
					.setParameter("q", symbol)
					//.setParameter("exchanges", "Q,N")//can even filter by exchange
					.setParameter("types", typesStr)//"stock,option,etf,index")
					.build();
			RequestBuilder requestBuilder = RequestBuilder.get(uri);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			final HttpUriRequest request = requestBuilder.build();
			
			final HttpResponse response = HttpClientBuilder.create().build().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				final String responseEntity = EntityUtils.toString(response.getEntity());
				ObjectMapper mapper = Utils.objectMapper();
				final JsonNode jsonTree = mapper.readTree(responseEntity);    	    
				JsonNode lookupNode = jsonTree.findPath("securities").findPath("security");
	
				if(lookupNode.isMissingNode())
					return Optional.empty();
				
				//Tradier returns single security as an object while multi as an Array
				//but, since this does approx matches, it can return an array of similar ones
				if(lookupNode.isObject()) {
					Security security = mapper.treeToValue(lookupNode, Security.class);
					return Optional.ofNullable(security.getSymbol().equals(symbol.toUpperCase())
							?security :null);
				}
				else {
					Security[] securityArray = mapper.treeToValue(lookupNode, Security[].class);
					//direct mapping to List<> will not parse and will make List<LinkedHashMap<..>>. 
					//Rather map to a object[] and then stream to list
					if(securityArray.length > 0) {
						Optional<Security> securityOpt = Arrays.stream(securityArray)
								.filter(sec -> sec.getSymbol().equals(symbol.toUpperCase()))
								.findAny();
						return securityOpt;
					}
				}
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(IOException|URISyntaxException ex) {
			throw new RuntimeException(ex);
		}

		return Optional.empty();
	}

	@Override
	public List<String> lookupOptionSymbolsFor(String underlyingStockSymbol) {
		try {
			String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "markets/options/lookup");
			URI uri = new URIBuilder(url)
					.build();
			RequestBuilder requestBuilder = RequestBuilder.get(uri);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			final HttpUriRequest request = requestBuilder
					.addParameter("underlying", underlyingStockSymbol)
					.build();

			final HttpResponse response = HttpClientBuilder.create().build().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				final String responseEntity = EntityUtils.toString(response.getEntity());
				ObjectMapper mapper = Utils.objectMapper();
				final JsonNode jsonTree = mapper.readTree(responseEntity);    	    
				JsonNode optionsNode = jsonTree.findPath("symbols").findPath("options");
	
				//Tradier returns single quote as an object while multi as an Array
				if(optionsNode.isObject()) {
					String optionSymbol = mapper.treeToValue(optionsNode, String.class);
					return Collections.singletonList(optionSymbol);
				}
				else if(optionsNode.isArray()) {
					List<String> optionSymbols = mapper.treeToValue(optionsNode, List.class);
					return optionSymbols;
				}
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(IOException|URISyntaxException ex) {
			throw new RuntimeException(ex);
		}

		return new ArrayList<>();
	}

	@Override
	public List<Order> lookupOrders(String status,	Integer limitCount, String afterTimestamp, String untilTimestamp,
			String symbols, String side) {

		throw new UnsupportedOperationException("TODO: Not yet implemented.");
	}

	@Override
	public Optional<Order> lookupOrder(long orderId) {
		Order order = null;
		try {
			String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "accounts/%s/orders/%s", 
					tradierProps.getProperty(K_TRADIER_ACCOUNTID), orderId);
			URI uri = new URIBuilder(url)
					.setParameter("includeTags", "true")
					.build();
			RequestBuilder requestBuilder = RequestBuilder.get(uri);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			final HttpUriRequest request = requestBuilder.build();
			
			final HttpResponse response = HttpClientBuilder.create().build().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				final String responseEntity = EntityUtils.toString(response.getEntity());
				ObjectMapper mapper = Utils.objectMapper();
				final JsonNode jsonTree = mapper.readTree(responseEntity);    	    

				JsonNode orderNode = jsonTree.findPath("order");
	
				if(orderNode.isObject()) {
					order = mapper.treeToValue(orderNode, Order.class);
					return Optional.of(order);
				}
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(IOException|URISyntaxException ex) {
			throw new RuntimeException(ex);
		}
		return Optional.empty();
	}

	@Override
	public List<Position> getPositions() {
		List<Position> positions = new ArrayList<>();
		try {
			String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "accounts/%s/positions", 
					tradierProps.getProperty(K_TRADIER_ACCOUNTID));
			RequestBuilder requestBuilder = RequestBuilder.get(url);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			final HttpUriRequest request = requestBuilder
					.addParameter("account_id", tradierProps.getProperty(K_TRADIER_ACCOUNTID))
					.build();

			final HttpResponse response = HttpClientBuilder.create().build().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				final String responseEntity = EntityUtils.toString(response.getEntity());
				ObjectMapper mapper = Utils.objectMapper();
				final JsonNode jsonTree = mapper.readTree(responseEntity);

				JsonNode positionNode = jsonTree.findPath("positions").findPath("position");
				if(positionNode.isObject()) {
					Position position = mapper.treeToValue(positionNode, Position.class);
					positions.add(position);
				}
				else {
					List<Position> myPositions = mapper.treeToValue(jsonTree.findPath("positions"), Positions.class).getPositions();
					if(myPositions != null && !myPositions.isEmpty())
						positions.addAll(myPositions);
				}
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(IOException ex) {
			throw new RuntimeException(ex);
		}

		return positions;
	}

	@Override
	public List<Order> getOrders() {
		List<Order> orders = new ArrayList<>();
		try {
			String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "accounts/%s/orders", 
					tradierProps.getProperty(K_TRADIER_ACCOUNTID));
			RequestBuilder requestBuilder = RequestBuilder.get(url);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			final HttpUriRequest request = requestBuilder
					.addParameter("account_id", tradierProps.getProperty(K_TRADIER_ACCOUNTID))
					.addParameter("includeTags", "true")
					.build();

			final HttpResponse response = HttpClientBuilder.create().build().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				final String responseEntity = EntityUtils.toString(response.getEntity());
				ObjectMapper mapper = Utils.objectMapper();
				final JsonNode jsonTree = mapper.readTree(responseEntity);
	
				JsonNode orderNode = jsonTree.findPath("orders").findPath("order");
				//Tradier returns single quote as an object while multi as an Array
				if(orderNode.isObject()) {
					Order order = mapper.treeToValue(orderNode, Order.class);
					orders.add(order);
				}
				else {
					List<Order> myOrders = mapper.treeToValue(jsonTree.findPath("orders"), Orders.class).getOrders();
					if(myOrders != null && !myOrders.isEmpty())
						orders.addAll(myOrders);
				}
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(IOException ex) {
			throw new RuntimeException(ex);
		}
		return orders;
	}

	@Override
	public Profile getUserProfile() {
		try {
			String url = tradierProps.getProperty(K_TRADIER_URL) + "user/profile";
			RequestBuilder requestBuilder = RequestBuilder.get(url);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			final HttpUriRequest request = requestBuilder.build();

			final HttpResponse response = HttpClientBuilder.create().build().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				ObjectMapper mapper = Utils.objectMapper();
				final String responseEntity = EntityUtils.toString(response.getEntity());
	
				final JsonNode jsonTree = mapper.readTree(responseEntity);    	    
				JsonNode profileNode = jsonTree.findPath("profile");
				if(profileNode.isObject()) {
					Profile profile = mapper.treeToValue(profileNode, Profile.class);
					return profile;
				}
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		return null;
	}

	@Override
	public Map<String, Object> getAccountBalances(String accountId) {
		Map<String, Object> params = new HashMap<>();
		
		try {
			String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "accounts/%s/balances", accountId);
			RequestBuilder requestBuilder = RequestBuilder.get(url);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			final HttpUriRequest request = requestBuilder.build();

			final HttpResponse response = HttpClientBuilder.create().build().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				final String responseEntity = EntityUtils.toString(response.getEntity());
	
				ObjectMapper mapper = Utils.objectMapper();
				final JsonNode jsonTree = mapper.readTree(responseEntity);    	    
				JsonNode balancesNode = jsonTree.findPath("balances");
				JsonNode marginNode = balancesNode.findPath("margin");
				JsonNode cashNode = balancesNode.findPath("cash");
				//JsonNode pdtNode = balancesNode.findPath("pdt");
				
				String accountType = balancesNode.get(KEY_ACCOUNT_ACCOUNT_TYPE).asText();
				double totalCash = balancesNode.get(KEY_ACCOUNT_TOTAL_CASH).asDouble();
				double pendingCash = balancesNode.get(KEY_ACCOUNT_PENDING_CASH).asDouble();
	
				double availableCash = 0;
				if(! cashNode.isNull() && !cashNode.isMissingNode()) {
					//interestingly cash account dont have the stock/option BP!!!
					availableCash = cashNode.get(KEY_ACCOUNT_CASH_AVAILABLE).asDouble();
					//LOGGER.debug("Json cash available: " + availableCash);
				}
				double stockBp, optionBp;
				stockBp = optionBp = 0;
				if(marginNode != null) {
					stockBp = marginNode.get(KEY_ACCOUNT_STOCK_BP).asDouble();
					optionBp = marginNode.get(KEY_ACCOUNT_OPTION_BP).asDouble();
				}
				//look inside the PDT node?
				
				//common entries
				params.put(KEY_ACCOUNT_ACCOUNT_TYPE, accountType);
				params.put(KEY_ACCOUNT_TOTAL_CASH, totalCash);
				params.put(KEY_ACCOUNT_PENDING_CASH, pendingCash);
				//margin acct entries
				params.put(KEY_ACCOUNT_STOCK_BP, stockBp);
				params.put(KEY_ACCOUNT_OPTION_BP, optionBp);
				//cash acct entries
				params.put(KEY_ACCOUNT_CASH_AVAILABLE, availableCash);
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		return params;
	}

	@Override
	public long cancelOrder(long orderId) {
		try {
			String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "accounts/%s/orders/%s", 
					tradierProps.getProperty(K_TRADIER_ACCOUNTID), orderId);

			RequestBuilder requestBuilder = RequestBuilder.delete(url);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			final HttpUriRequest request = requestBuilder.build();

			final HttpResponse response = HttpClientBuilder.create().build().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				final String responseEntity = EntityUtils.toString(response.getEntity());
				ObjectMapper mapper = Utils.objectMapper();
				final com.fasterxml.jackson.databind.JsonNode responseJson = mapper.readTree(responseEntity);
				if(responseJson.isObject()) {
					return responseJson.findValue("id").asLong();
				}
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(IOException ex) {
			throw new RuntimeException(ex);
		}

		return 0;
	}

	@Override
	public long postStockOrder(EquityOrderRequest orderReq) {
		try {
			String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "accounts/%s/orders", 
					tradierProps.getProperty(K_TRADIER_ACCOUNTID));

			RequestBuilder requestBuilder = RequestBuilder.post(url);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			final HttpUriRequest request = requestBuilder
					.addParameter("account_id", tradierProps.getProperty(K_TRADIER_ACCOUNTID))
					.addParameter("class", orderReq.getEquityClass().toString())
					.addParameter("symbol", orderReq.getSymbol())
					.addParameter("side", orderReq.getSide().toString())
					.addParameter("quantity", ""+(int)orderReq.getQuantity())
					.addParameter("type", orderReq.getOrderType().toString())
					.addParameter("duration", orderReq.getDuration().toString())
					.addParameter("price", ""+orderReq.getPrice())
					.addParameter("stop", ""+orderReq.getStopPrice())
					.addParameter("tag", orderReq.getOrderTag())
					.build();

			final HttpResponse response = HttpClientBuilder.create().build().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				final String responseEntity = EntityUtils.toString(response.getEntity());
				ObjectMapper mapper = Utils.objectMapper();
				final com.fasterxml.jackson.databind.JsonNode jsonNode = mapper.readTree(responseEntity);
				if(jsonNode.hasNonNull("order"))
					return jsonNode.findValue("id").asLong();
				if(jsonNode.has("errors")) {
					JsonNode errorNode = jsonNode.findPath("errors").findPath("error");
					String errorStr = mapper.writeValueAsString(errorNode);
					LOGGER.error("postStockOrder Error response: " + errorStr);
				}
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(IOException ex) {
			throw new RuntimeException(ex);
		}
		return 0;
	}

	@Override
	public long postOptionOrder(OptionOrderRequest orderReq) {
		try {
			String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "accounts/%s/orders", 
					tradierProps.getProperty(K_TRADIER_ACCOUNTID));
			RequestBuilder requestBuilder = RequestBuilder.post(url);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			final HttpUriRequest request = requestBuilder
					.addParameter("account_id", tradierProps.getProperty(K_TRADIER_ACCOUNTID))
					.addParameter("class", orderReq.getEquityClass().toString())
					.addParameter("symbol", orderReq.getSymbol())
					.addParameter("side", orderReq.getSide().toString())
					.addParameter("quantity", ""+(int)orderReq.getQuantity())
					.addParameter("type", orderReq.getOrderType().toString())
					.addParameter("duration", orderReq.getDuration().toString())
					.addParameter("price", ""+orderReq.getPrice())
					.addParameter("stop", ""+orderReq.getStopPrice())
					.addParameter("tag", orderReq.getOrderTag())
					.addParameter("option_symbol", orderReq.getOptionSymbol())
					.build();

			final HttpResponse response = HttpClientBuilder.create().build().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				final String responseEntity = EntityUtils.toString(response.getEntity());
				ObjectMapper mapper = Utils.objectMapper();
				final com.fasterxml.jackson.databind.JsonNode jsonNode = mapper.readTree(responseEntity);
				if(jsonNode.hasNonNull("order"))
					return jsonNode.findValue("id").asLong();
				if(jsonNode.has("errors")) {
					JsonNode errorNode = jsonNode.findPath("errors").findPath("error");
					String errorStr = mapper.writeValueAsString(errorNode);
					LOGGER.error("postOptionOrder Error response: " + errorStr);
				}
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(IOException ex) {
			throw new RuntimeException(ex);
		}
		return 0;
	}

	@Override
	public List<LocalDate> getOptionExpieryDates(String underlyingSymbol) {

		List<LocalDate> expireDates = new ArrayList<>();
		try {
			String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "markets/options/expirations");
			RequestBuilder requestBuilder = RequestBuilder.get(url);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			final HttpUriRequest request = requestBuilder
					.addParameter("symbol", underlyingSymbol)
					.addParameter("includeAllRoots", "true")
					//.addParameter("strikes", "true")
					//.addParameter("contractSize", "true")
					//.addParameter("expirationType", "true")
					.build();

			final HttpResponse response = HttpClientBuilder.create().build().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				final String responseEntity = EntityUtils.toString(response.getEntity());
				ObjectMapper mapper = Utils.objectMapper();
				final JsonNode jsonTree = mapper.readTree(responseEntity);
				//if only date then this does not return the expiration block.
				JsonNode expireDateNode = jsonTree.findPath("expirations").findPath("date");
	
				//Tradier returns single quote as an object while multi as an Array
				if(expireDateNode.isObject()) {
					//String expireDateStr = expireDateNode.get("date").asText();
					String expireDateStr = expireDateNode.asText();
					LocalDate expireDate = LocalDate.parse(expireDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
					expireDates.add(expireDate);
				}
				else {
					for (final JsonNode objNode : expireDateNode) {
						String expireDateStr = objNode.asText();
						LocalDate expireDate = LocalDate.parse(expireDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
						expireDates.add(expireDate);
					}
				}
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		return expireDates;
	}

	@Override
	public List<Option> getOptionChainFor(String underlyingSymbol, LocalDate expieryDate) {
		List<Option> optionQuotes = new ArrayList<>();
		try {
			String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "markets/options/chains");
			RequestBuilder requestBuilder = RequestBuilder.get(url);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			final HttpUriRequest request = requestBuilder
					.addParameter("symbol", underlyingSymbol)
					.addParameter("expiration", expieryDate.format(DateTimeFormatter.ISO_LOCAL_DATE))
					.addParameter("greeks", "true")
					.build();

			final HttpResponse response = HttpClientBuilder.create().build().execute(request);
			if(response.getStatusLine().getStatusCode() == 200) {
				final String responseEntity = EntityUtils.toString(response.getEntity());
				ObjectMapper mapper = Utils.objectMapper();
				final JsonNode jsonTree = mapper.readTree(responseEntity);
				JsonNode optionNode = jsonTree.findPath("options").findPath("option");
		
				//Tradier returns single quote as an object while multi as an Array
				if(optionNode.isObject()) {
					Option quote = mapper.treeToValue(optionNode, Option.class);
					optionQuotes.add(quote);
				}
				else {
					List<Option> myQuotes = mapper.treeToValue(jsonTree.findPath("options"), Options.class).getOptions();
					if(myQuotes != null && !myQuotes.isEmpty())
						optionQuotes.addAll(myQuotes);
				}
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(Exception ex) {
			throw new RuntimeException(ex);
		}
		return optionQuotes;
	}

	@Override
	public long modifyOrder(long existingOrderId, String orderType, String duration, Double price, Double stopPrice) {
		try {
			String url = String.format(tradierProps.getProperty(K_TRADIER_URL) + "accounts/%s/orders/%s", 
					tradierProps.getProperty(K_TRADIER_ACCOUNTID), existingOrderId);
			RequestBuilder requestBuilder = RequestBuilder.put(url);
			headers.forEach((k, v) -> requestBuilder.addHeader(k, v));
			final HttpUriRequest request = requestBuilder
					//.addParameter("type", orderType)
					//.addParameter("duration", duration)
					.addParameter("price", "" + price)
					.addParameter("stop", "" + stopPrice)
					.build();

			final HttpResponse response = HttpClientBuilder.create().build().execute(request);

			//We may get 400 with message: 'order not in valid state for modifications' in some cases
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode == 200 || statusCode == 201) {//what is the code that the order is updated?
				final String responseEntity = EntityUtils.toString(response.getEntity());
				ObjectMapper mapper = Utils.objectMapper();
				final com.fasterxml.jackson.databind.JsonNode jsonTree = mapper.readTree(responseEntity);
				if(jsonTree.hasNonNull("order"))
					return jsonTree.findValue("id").asLong();
				if(jsonTree.has("errors")) {
					JsonNode errorNode = jsonTree.findPath("errors").findPath("error");
					String errorStr = mapper.writeValueAsString(errorNode);
					LOGGER.error("modifyOrder Error response: " + errorStr);
				}
			}
			else
				LOGGER.warn("Response code: " + response.getStatusLine().getStatusCode() + ", reason: " + response.getStatusLine().getReasonPhrase());
		}
		catch(IOException ex) {
			throw new RuntimeException(ex);
		}

		return 0;
	}

	@Override
    public Map<String, String> getOptionExchangeCodeMap() {
    	String exchMapStr = "A=NYSE Amex Options"
    			+ ",B=BOX Options Exchange"
    			+ ",C=Chicago Board Options Exchange (CBOE)"
    			+ ",H=ISE Gemini"
    			+ ",I=International Securities Exchange (ISE)"
    			+ ",M=MIAX Options Exchange"
    			+ ",N=NYSE Arca Options"
    			+ ",O=Options Price Reporting Authority (OPRA)"
    			+ ",P=MIAX PEARL"
    			+ ",Q=NASDAQ Options Market"
    			+ ",T=NASDAQ OMX BX"
    			+ ",W=C2 Options Exchange"
    			+ ",X=NASDAQ OMX PHLX"
    			+ ",Z=BATS Options Market";
    	
    	return Stream.of(exchMapStr.split("\\,"))
                .collect(Collectors.toMap(t -> t.toString().split("=")[0], t -> t.toString().split("=")[1]));
    }
    
	@Override
    public Map<String, String> getStockExchangeCodeMap() {
    	String exchMapStr = "A=NYSE MKT"
    			+ ",B=NASDAQ OMX BX"
    			+ ",C=National Stock Exchange"
    			+ ",D=FINRA ADF"
    			+ ",E=Market Independent (Generated by Nasdaq SIP)"
    			+ ",F=Mutual Funds/Money Markets (NASDAQ)"
    			+ ",I=International Securities Exchange"
    			+ ",J=Direct Edge A"
    			+ ",K=Direct Edge X"
    			+ ",L=Long Term Stock Exchange"
    			+ ",M=Chicago Stock Exchange"
    			+ ",N=NYSE"
    			+ ",P=NYSE Arca"
    			+ ",Q=NASDAQ OMX"
    			+ ",S=NASDAQ Small Cap"
    			+ ",T=NASDAQ Int"
    			+ ",U=OTCBB"
    			+ ",V=OTC other"
    			+ ",W=CBOE"
    			+ ",X=NASDAQ OMX PSX"
    			+ ",G=GLOBEX"
    			+ ",Y=BATS Y-Exchange"
    			+ ",Z=BATS";
    	
    	return Stream.of(exchMapStr.split("\\,"))
                .collect(Collectors.toMap(t -> t.toString().split("=")[0], t -> t.toString().split("=")[1]));
    }

}
