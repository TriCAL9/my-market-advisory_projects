package api.my_market_advisor.resource;

import java.net.URI;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
@Component
public class LogoURIHandler implements URIHandler {
    private URI logoURI;
    @Autowired
    IEXCloudProperties iexCloudProperties;
    public LogoURIHandler(String symbol) {
        logoURI = Objects.requireNonNull(URI.create(iexCloudProperties.getLogo()
            .expand(symbol, iexCloudProperties.getIex_cloud_key()).toString()));
    }
    
    public URI getURI() {
        return logoURI;
    }
}