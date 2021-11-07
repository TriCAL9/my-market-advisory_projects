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

import api.my_market_advisor.components.IEXCloudComponent;
import api.my_market_advisor.model.News;
@Component
public class NewsURIHandler {
    private URI newsURI;

    @Autowired
    IEXCloudComponent iexCloudComponent;
    
    public NewsURIHandler(String last, String symbol) {
        newsURI = Objects.requireNonNull(iexCloudComponent.getIexCloudProperties().getUrl()
        .expand(symbol, News.getPARAMETER(), iexCloudComponent.getIexCloudProperties().getLast()
            .expand(last).toString(), iexCloudComponent.getIexCloudProperties().getIex_cloud_key()),"Null pointer at news url");
    }
    public URI getURI() {
        return newsURI;
    }
}