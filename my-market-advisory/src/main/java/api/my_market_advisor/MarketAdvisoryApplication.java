package api.my_market_advisor;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.SqlReturnResultSet;

import api.my_market_advisor.resource.CompanyURIHandler;
import api.my_market_advisor.resource.HistoricalStockPriceURIHandler;
import api.my_market_advisor.resource.IEXCloudProperties;
import api.my_market_advisor.resource.LogoURIHandler;
import api.my_market_advisor.resource.NewsURIHandler;

@SpringBootApplication(scanBasePackages = {"api.my_market_advisor", "api.my_market_advisory_security"})
@EnableConfigurationProperties(IEXCloudProperties.class)
public class MarketAdvisoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarketAdvisoryApplication.class, args);
    }
    /*
    @Bean
    public CompanyURIHandler companyURIHandler(String symbol){
        return new CompanyURIHandler(symbol);
    }
    @Bean
    public LogoURIHandler logoURIHandler(String symbol) {
        return new LogoURIHandler(symbol);
    }
    @Bean
    public NewsURIHandler newsURIHandler(int size, String symbol){
        return newsURIHandler(size, symbol);
    }
    @Bean
    public HistoricalStockPriceURIHandler historicalStockPriceURIHandler(String range, String symbol) {
        return new HistoricalStockPriceURIHandler(range, symbol);
    }
    
    @Bean 
    public String symbol(String symbol){
        return symbol;
    }
    */
    //TODO Add Logger:
    // - determine if this is the Class to add a Logger.
}
