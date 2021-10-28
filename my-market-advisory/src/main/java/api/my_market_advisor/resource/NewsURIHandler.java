package api.my_market_advisor.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;

import api.my_market_advisor.components.IEXCloudComponent;
import api.my_market_advisor.model.News;

public class NewsURIHandler {
    private URI newsURI;

    @Autowired
    IEXCloudComponent iexCloudComponents;
    
    public NewsURIHandler(int last, String symbol){
        newsURI =iexCloudComponents.getProperties().getUrl()
        .expand(symbol, News.getPARAMETER(), iexCloudComponents.getProperties().getLast()
            .expand(last),iexCloudComponents.getProperties().getIex_cloud_key())
        .toURI();
    }
    
    public URI getURI() {
        return newsURI;
    }
}