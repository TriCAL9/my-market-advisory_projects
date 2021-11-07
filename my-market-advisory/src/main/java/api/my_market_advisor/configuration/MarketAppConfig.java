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
@ComponentScan("api.my_market_advisor.resource")
public class MarketAppConfig {
   /*
    @Bean
    @Override
    public HistoricalStockPriceRequestHandler geHistoricalStockPriceRequestHandler(@Autowired RestTemplate restTemplate,
           @Autowired HistoricalStockPriceURIHandler historicalStockPriceURIHandler) {
        // TODO Auto-generated method stub
        return new HistoricalStockPriceRequestHandler(historicalStockPriceURIHandler, restTemplate) ;
    }
    @Bean
    @Override
    public NewsRequestHandler getNewsMarketDataRequestHandler(@Autowired RestTemplate restTemplate, @Autowired NewsURIHandler newsURIHandler
    ,@Autowired LogoURIHandler logoURIHandler, @Autowired CompanyURIHandler companyURIHandler) {
        // TODO Auto-generated method stub
        return new NewsRequestHandler(restTemplate, companyURIHandler, newsURIHandler, logoURIHandler) ;
    }
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder){
         return builder.build();
    }
    @Bean
    public String symbol(String symbol) {
        return "ab";
    }
    @Bean
    NewsURIHandler newsURIHandler(String last, String symbol){
        return new NewsURIHandler(last, symbol);
    }
    @Bean
    LogoURIHandler logoURIHandler(String symbol) {
        return new LogoURIHandler(symbol);
    }
    @Bean
    CompanyURIHandler companyURIHandler(String symbol){
        return new CompanyURIHandler(symbol);
    }
    */
    @Bean 
    IEXCloudComponent iexCloudComponent() {
        return new IEXCloudComponent();
    }
}