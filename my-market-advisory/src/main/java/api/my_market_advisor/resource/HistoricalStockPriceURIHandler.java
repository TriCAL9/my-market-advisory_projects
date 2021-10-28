package api.my_market_advisor.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;

public class HistoricalStockPriceURIHandler implements URIHandler {
    private URI historicalPriceURI;
    
    @Autowired
    IEXCloudProperties iexCloudProperties;
    
    public HistoricalStockPriceURIHandler(String range, String symbol) {
        historicalPriceURI = URI.create(iexCloudProperties.getHistoricalUrl()
        .expand(symbol,range,iexCloudProperties.getIex_cloud_key()).toString());
    }
    
    public URI getURI() {
        return historicalPriceURI;
    }
}