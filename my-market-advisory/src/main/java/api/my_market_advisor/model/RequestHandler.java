package api.my_market_advisor.model;

import org.springframework.web.client.RestTemplate;

import api.my_market_advisor.resource.URIHandler;

public interface RequestHandler {
    MarketData getMarketDataRequestHandler(RestTemplate restTemplate, URIHandler uriHandler);
}