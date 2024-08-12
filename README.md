# tradier
Tradier Java API Implementation

Java implementation of the <a href="https://developer.tradier.com">Tradier</a> restful API

Only some of the Tradier features are implemented and the rest will depend on use case.

Followings are implemented:
- Symbol lookup.
- Get intra-day & historic quotes.
- Get option chains.
- Get option expiery dates.

- Get user profile.
- Get account detail.
- Get positions & orders.
- Lookup order(s).
- Post simple market/limit stock order.
- Post option order.
- Modify order.

Yet to be added:
- Fundamental data (BETA).
- Streaming quotes.
- Error handling.
- Test cases.
- Spring Boot integration.

  
Use Case:  
I have a algo trading application integrated with TD Ameritrade Rest APIs and was working fine before the TDA to Schwab transition. That API is no longer available. This means I need to either use Schwab API or find some alternatives. Two come into picture. Tradier & Alpaca. 

Alpaca has a decent OpenAPI integration and there is some ongoing efforts to make a java library available. 

Tradier does not have a readily available client jar and and this project will address that issue. 


Building and how to use:  
Work in progress.

Author: <a href="https://github.com/deepaktripathy">Deepak Tripathy</a>
