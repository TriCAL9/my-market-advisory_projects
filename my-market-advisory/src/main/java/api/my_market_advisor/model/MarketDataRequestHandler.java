package api.my_market_advisor.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.web.client.RestTemplate;

import api.my_market_advisor.components.IEXCloudComponent;
import api.my_market_advisor.model.StockProfile.Builder;
import api.my_market_advisor.resource.URIHandler;

public final class MarketDataRequestHandler {

    public static List<News> buildMarketData(RestTemplate restTemplate, final String symbol, final int size, URIHandler uriHandler, IEXCloudComponent iexCloudComponent) {
        final News.Builder[] builders = Objects.requireNonNull(
                restTemplate.getForObject(uriHandler.initializeURI(symbol, News.getPARAMETER(), size, iexCloudComponent),
                        (Class<? extends News.Builder[]>) News.Builder[].class),
                "A null object is not accepted. It is recommended that you check the structure of the Json"
                        + " object before continuing.");
        final List<News> latestNews = new ArrayList<>();
        for (final News.Builder builder : builders) {
            latestNews.add(builder.build());
        }
        return latestNews;
    }

    public static List<HistoricalStockPrice> buildMarketData(RestTemplate restTemplate, String symbol, String range, URIHandler uriHandler, IEXCloudComponent iexCloudComponent){
        HistoricalStockPrice.Builder[] historicalStockPriceBuilder;
        List <HistoricalStockPrice> listOfPricesPerStock = new ArrayList<>();
        historicalStockPriceBuilder = Objects.requireNonNull(restTemplate.getForObject(uriHandler.initializePricesURI(symbol, range, iexCloudComponent)
        ,(Class<? extends HistoricalStockPrice.Builder[]>) HistoricalStockPrice.Builder[].class), "Check data structure of Json object requested.");
       
       for(final HistoricalStockPrice.Builder hspb : historicalStockPriceBuilder) {
           listOfPricesPerStock.add(hspb.build());
       }
        return listOfPricesPerStock;
    }

    public static StockProfile buildMarketData(RestTemplate restTemplate, String symbol, URIHandler uriHandler, final IEXCloudComponent iexCloudComponents) {
        final Builder builder = Objects.requireNonNull(
                restTemplate.getForObject(uriHandler.initializeURI(symbol, StockProfile.getPARAMETER(), iexCloudComponents),
                       (Class<? extends StockProfile.Builder>) StockProfile.Builder.class),
                "A null object is not accepted. "
                        + "It is recommended that you check the structure of the Json object before continuing.");
        return builder.build();
    }

    public static Logo getLogo(RestTemplate restTemplate, final String symbol, URIHandler uriHandler, final IEXCloudComponent iexCloudComponents) {
        return Objects.requireNonNull(
                restTemplate.getForObject(uriHandler.initializeURI(symbol, iexCloudComponents), Logo.class), "Logo not found");
    }
}
