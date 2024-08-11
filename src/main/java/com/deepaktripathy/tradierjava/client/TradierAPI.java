package com.deepaktripathy.tradierjava.client;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deepaktripathy.tradierjava.client.account.AccountAPI;
import com.deepaktripathy.tradierjava.client.marketdata.MarketDataAPI;
import com.deepaktripathy.tradierjava.client.user.UserAPI;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 
 * @author deepak tripathy created on 07/02/2024
 *
 */
public class TradierAPI {

   private static final Logger LOGGER = LoggerFactory.getLogger(TradierAPI.class);

   protected static final String DEFAULT_PATH = "https://sandbox.tradier.com";

   // property keys
   public static String K_TRADIER_URL = "tradierjava.api.url";
   public static String K_TRADIER_ACCOUNTID = "tradierjava.api.accountid";
   public static String K_TRADIER_TOKEN = "tradierjava.api.token";

   /** Base api url. */
   private String baseApiUrl;

   /** API Key/secret */
   private final String apiKey;

   private final OkHttpClient okHttpClient;

   private UserAPI user;
   private AccountAPI account;
   private MarketDataAPI marketData;

   /**
    * Tries to load from the property file from classPath using the default client.
    * 
    */
   public TradierAPI() {
      this(null, null);
   }

   /**
    * Loads from the supplied properties using the default client
    * 
    */
   public TradierAPI(Properties props) {
      this(props, null);
   }

   /**
    * Loads from supplied properties and client, else uses the default.
    */
   public TradierAPI(Properties props, OkHttpClient okHttpClient) {
      LOGGER.info("Initiating TradierClient...");

      Properties tradierProps = (props == null) ? initProps() : props;

      validateProps(tradierProps);

      apiKey = tradierProps.getProperty(K_TRADIER_TOKEN);
      baseApiUrl = tradierProps.getProperty(K_TRADIER_URL);

//      this.headers = new HashMap<>();
      if (okHttpClient == null) {
         okHttpClient = createHttpClient();
      }
      this.okHttpClient = okHttpClient;
   }

   protected static Properties initProps() {
      try (InputStream in = TradierAPI.class.getClassLoader().getResourceAsStream("tradier-api-config.properties")) {
         Properties tradProperties = new Properties();
         if(in != null)
            tradProperties.load(in);
         LOGGER.info("Properties loaded, keys: " + tradProperties.keySet());
         return tradProperties;
      } catch (IOException e) {
         throw new IllegalArgumentException(
               "Could not load default properties from tradier-api-config.properties in classpath");
      }
   }

   /**
    * validates the necessary props like token and account id. If others are
    * missing, just use friendly defaults.
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

   /**
    * Returns the UserAPI servicing all the user related endpoints '/user'
    */
   public synchronized UserAPI user() {
      if (user == null) {
         user = new UserAPI(baseApiUrl, apiKey, okHttpClient);
      }
      return user;
   }

   /**
    * Returns the AccountAPI servicing all the account related endpoints
    * '/accounts'
    */
   public synchronized AccountAPI accounts() {
      if (account == null) {
         account = new AccountAPI(baseApiUrl, apiKey, okHttpClient);
      }
      return account;
   }

   /**
    * Returns the MarketDataAPI servicing all the market related endpoints
    * '/markets'
    */
   public synchronized MarketDataAPI marketData() {
      if (marketData == null) {
         marketData = new MarketDataAPI(baseApiUrl, apiKey, okHttpClient);
      }
      return marketData;
   }

   public Map<String, String> getOptionExchangeCodeMap() {
      String exchMapStr = "A=NYSE Amex Options" + ",B=BOX Options Exchange" + ",C=Chicago Board Options Exchange (CBOE)"
            + ",H=ISE Gemini" + ",I=International Securities Exchange (ISE)" + ",M=MIAX Options Exchange"
            + ",N=NYSE Arca Options" + ",O=Options Price Reporting Authority (OPRA)" + ",P=MIAX PEARL"
            + ",Q=NASDAQ Options Market" + ",T=NASDAQ OMX BX" + ",W=C2 Options Exchange" + ",X=NASDAQ OMX PHLX"
            + ",Z=BATS Options Market";

      return Stream.of(exchMapStr.split("\\,"))
            .collect(Collectors.toMap(t -> t.toString().split("=")[0], t -> t.toString().split("=")[1]));
   }

   public Map<String, String> getStockExchangeCodeMap() {
      String exchMapStr = "A=NYSE MKT" + ",B=NASDAQ OMX BX" + ",C=National Stock Exchange" + ",D=FINRA ADF"
            + ",E=Market Independent (Generated by Nasdaq SIP)" + ",F=Mutual Funds/Money Markets (NASDAQ)"
            + ",I=International Securities Exchange" + ",J=Direct Edge A" + ",K=Direct Edge X"
            + ",L=Long Term Stock Exchange" + ",M=Chicago Stock Exchange" + ",N=NYSE" + ",P=NYSE Arca" + ",Q=NASDAQ OMX"
            + ",S=NASDAQ Small Cap" + ",T=NASDAQ Int" + ",U=OTCBB" + ",V=OTC other" + ",W=CBOE" + ",X=NASDAQ OMX PSX"
            + ",G=GLOBEX" + ",Y=BATS Y-Exchange" + ",Z=BATS";

      return Stream.of(exchMapStr.split("\\,"))
            .collect(Collectors.toMap(t -> t.toString().split("=")[0], t -> t.toString().split("=")[1]));
   }

   private OkHttpClient createHttpClient() {
      OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
      if (LOGGER.isDebugEnabled()) {
         final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(LOGGER::debug);
         loggingInterceptor.setLevel(BODY);
         clientBuilder.addInterceptor(loggingInterceptor);
      }
      clientBuilder.readTimeout(2, TimeUnit.MINUTES);
      clientBuilder.writeTimeout(2, TimeUnit.MINUTES);
      return clientBuilder.build();

   }
}
