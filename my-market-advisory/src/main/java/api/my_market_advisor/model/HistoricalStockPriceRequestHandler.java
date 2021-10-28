package api.my_market_advisor.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.web.client.RestTemplate;

import api.my_market_advisor.resource.HistoricalStockPriceURIHandler;

public class HistoricalStockPriceRequestHandler {
    private List<HistoricalStockPrice> historicalStockPrice;
    
    public HistoricalStockPriceRequestHandler(HistoricalStockPriceURIHandler historicalStockPriceURIHandler, RestTemplate restTemplate) {
        HistoricalStockPrice.Builder[] historicalStockPriceBuilder = Objects.requireNonNull(restTemplate.getForObject(historicalStockPriceURIHandler.getURI(), HistoricalStockPrice.Builder[].class),"Check structure of json if this returns null");
        historicalStockPrice = new ArrayList<>();
        for(final HistoricalStockPrice.Builder hspb : historicalStockPriceBuilder) {
           historicalStockPrice.add(hspb.build());
        }
    }
    public List<HistoricalStockPrice> getHistoricalStockPrice() {
        return historicalStockPrice;
    }
}