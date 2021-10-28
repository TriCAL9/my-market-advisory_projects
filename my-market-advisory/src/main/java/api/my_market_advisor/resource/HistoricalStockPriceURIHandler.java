package api.my_market_advisor.resource;

public class HistoricalStockPriceURIHandler implements URIHandler{
    private URI historicalPriceURI;
    
    @Autowired
    IEXCloudComponent iEXCloudCompoment;
    
    public HistoricalStockPriceURIHandler(String range, String symbol) {
        historicalPriceURI = iEXCloudComponent.getProperties().getHistoricalUrl()
        .expand(symbol,range,iexCloudComponents.getProperties().getIex_cloud_key())
        .toURI();
    }
    
    public URI getURI() {
        return historicalPriceURI;
    }
}