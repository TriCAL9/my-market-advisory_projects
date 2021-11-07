package api.my_market_advisor.model;

import org.springframework.web.client.RestTemplate;

import api.my_market_advisor.resource.CompanyURIHandler;
import api.my_market_advisor.resource.HistoricalStockPriceURIHandler;
import api.my_market_advisor.resource.LogoURIHandler;
import api.my_market_advisor.resource.NewsURIHandler;

public interface RequestHandler {
    NewsRequestHandler getNewsMarketDataRequestHandler(RestTemplate restTemplate, NewsURIHandler uriHandler
    ,LogoURIHandler logoURIHandler, CompanyURIHandler companyURIHandler);
    HistoricalStockPriceRequestHandler geHistoricalStockPriceRequestHandler(RestTemplate restTemplate, HistoricalStockPriceURIHandler historicalStockPriceURIHandler);
}