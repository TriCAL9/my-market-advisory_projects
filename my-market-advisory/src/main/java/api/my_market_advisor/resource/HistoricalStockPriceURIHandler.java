package api.my_market_advisor.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;

import api.my_market_advisor.components.IEXCloudComponent;

public class HistoricalStockPriceURIHandler implements URIHandler {
    private URI historicalPriceURI;
    
    @Autowired
    IEXCloudComponent iexCloudComponents;
    
    public HistoricalStockPriceURIHandler(String range, String symbol) {
        historicalPriceURI = iexCloudComponents.getProperties().getHistoricalUrl()
        .expand(symbol,range,iexCloudComponents.getProperties().getIex_cloud_key())
        .toURI();
    }
    
    public URI getURI() {
        return historicalPriceURI;
    }
}