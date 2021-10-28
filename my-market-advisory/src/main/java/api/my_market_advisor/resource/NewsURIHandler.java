package api.my_market_advisor.resource;

public class NewsURIHandler {
    private URI newsURI;
    
    @Autowire
    IEXCloudComponents iexCloudComponents
    
    public NewsURIHandler(int last, String symbol){
        newsURI =iEXCloudComponents.getProperties().getUrl()
        .expand(symbol, News.PARAMETER, iEXCloudComponents.getProperties().getLast()
            .expand(last),iEXCloudComponents.getProperties().getIex_cloud_key())
        .toURI();
    }
    
    public URI getURI() {
        return newsURI;
    }
}