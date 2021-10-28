package api.my_market_advisor.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;

import api.my_market_advisor.components.IEXCloudComponent;
import api.my_market_advisor.model.News;

public class NewsURIHandler {
    private URI newsURI;

    @Autowired
    IEXCloudProperties iexCloudProperties;
    
    public NewsURIHandler(int last, String symbol){
        newsURI = URI.create(iexCloudProperties.getUrl()
        .expand(symbol, News.getPARAMETER(), iexCloudProperties.getLast()
            .expand(last),iexCloudProperties.getIex_cloud_key()).toString());
    }
    
    public URI getURI() {
        return newsURI;
    }
}