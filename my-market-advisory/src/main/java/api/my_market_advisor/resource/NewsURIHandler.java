package api.my_market_advisor.resource;

import java.net.URI;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import api.my_market_advisor.components.IEXCloudComponent;
import api.my_market_advisor.model.News;
@Component
public class NewsURIHandler {
    private URI newsURI;

    @Autowired
    IEXCloudProperties iexCloudProperties;
    @Autowired
    public NewsURIHandler(int last, String symbol){
        newsURI = Objects.requireNonNull(URI.create(iexCloudProperties.getUrl()
        .expand(symbol, News.getPARAMETER(), iexCloudProperties.getLast()
            .expand(last),iexCloudProperties.getIex_cloud_key()).toString()),"Attempt to fix null issue");
    }
    
    public URI getURI() {
        return newsURI;
    }
}