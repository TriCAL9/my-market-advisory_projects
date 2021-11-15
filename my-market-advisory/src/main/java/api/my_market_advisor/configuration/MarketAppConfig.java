package api.my_market_advisor.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import api.my_market_advisor.components.IEXCloudComponent;
import api.my_market_advisor.model.HistoricalStockPriceRequestHandler;
import api.my_market_advisor.model.NewsRequestHandler;
import api.my_market_advisor.model.RequestHandler;
import api.my_market_advisor.resource.CompanyURIHandler;
import api.my_market_advisor.resource.HistoricalStockPriceURIHandler;
import api.my_market_advisor.resource.LogoURIHandler;
import api.my_market_advisor.resource.NewsURIHandler;

@Configuration
public class MarketAppConfig {
    private Map<URI, String> uriMapsToSymbol;
    
    @Autowired
    public MarketAppConfig(List<URIHandler> uriList, Sting symbol) {
        uriMapsToSymbol = uriList.stream().collect(Collectors.toMap(URIHandler::getURI, symbol);
    }
}