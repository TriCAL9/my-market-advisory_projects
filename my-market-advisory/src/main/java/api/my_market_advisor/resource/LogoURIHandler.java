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
@Component
public class LogoURIHandler implements URIHandler {
    private URI logoURI;
    @Autowired
    IEXCloudComponent iexCloudComponent;
    
    public LogoURIHandler(String symbol) {
        Objects.requireNonNull(symbol);
        logoURI = Objects.requireNonNull(iexCloudComponent.getIexCloudProperties().getLogo()
            .expand(symbol, iexCloudComponent.getIexCloudProperties().getIex_cloud_key()),"Null pointer at logo template uri");
    }
    public URI getURI() {
        return logoURI;
    }
}