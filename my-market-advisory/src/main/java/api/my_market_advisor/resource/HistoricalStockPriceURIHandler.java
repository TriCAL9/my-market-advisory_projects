package api.my_market_advisor.resource;

import java.net.URI;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriTemplate;
@Component
public class HistoricalStockPriceURIHandler implements URIHandler {
    private URI historicalPriceURI;
    
    @Autowired
    IEXCloudProperties iexCloudProperties;
    
    public HistoricalStockPriceURIHandler(String range, String symbol) {
        Objects.requireNonNull(symbol);
        Objects.requireNonNull(range);
        historicalPriceURI = Objects.requireNonNull(iexCloudProperties.getHistoricalUrl()
        .expand(symbol,range,iexCloudProperties.getIex_cloud_key()), "if null i stink");
    }
    public URI getURI() {
        return historicalPriceURI;
    }
}