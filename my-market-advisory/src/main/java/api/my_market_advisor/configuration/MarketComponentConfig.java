package api.my_market_advisor.configuration;

@Configuration
@ComponentScan("api.my_market_advisor.resource")
public class MarketComponentConfig {
    private Map<Integer, URIHandler> uriHandlerMap;
    
    public MarketComponentConfig(List<URIHandler> uriList) {
        uriHandlerMap = uriList
            .stream()
            .collect(Collectors
                .toMap(URIHandler::hashCode, Function.identity()));
    }


    @Bean
    CompanyURIHandler companyURIHandler(String stockSymbol){

        return new companyURIHandler(stockSymbol);

    }

    @Bean
    HistoricalStockPriceURIHandler historicalStockPriceURIHandler(String stockSymbol) {
    
        return new HistoricalStockPriceURIHandler(stockSymbol);
    
    }

    @Bean 
    LogoURIHandler logoURIHandler(String stockSymbol) {

        return new LogoURIHandler(stockSymbol);
    }

    @Bean
    NewsURIHandler newsURIHandler(String stockSymbol) {

        return new NewsURIHandler(stockSymbol);
    
    }
    
    @Bean
    String stockSymbol() {
        return "fb";
    }
}