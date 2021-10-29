package api.my_market_advisor.resource;

import java.net.URI;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
@Component
public class HistoricalStockPriceURIHandler implements URIHandler {
    private URI historicalPriceURI;
    
    @Autowired
    IEXCloudProperties iexCloudProperties;
    
    public HistoricalStockPriceURIHandler(String range, String symbol) {
        historicalPriceURI = Objects.requireNonNull(URI.create(iexCloudProperties.getHistoricalUrl()
        .expand(symbol,range,iexCloudProperties.getIex_cloud_key()).toString()));
    }
    
    public URI getURI() {
        return historicalPriceURI;
    }
}