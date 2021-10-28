package api.my_market_advisor.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;

import api.my_market_advisor.components.IEXCloudComponent;

public class LogoURIHandler implements URIHandler {
    private URI logoURI;
    @Autowired
    IEXCloudComponent iexCloudComponents;
    public LogoURIHandler(String symbol) {
        logoURI = iexCloudComponents.getProperties().getLogo()
            .expand(symbol,iexCloudComponents.getProperties().getIex_cloud_key())
            .toURI();
    }
    
    public URI getURI() {
        return logoURI;
    }
}