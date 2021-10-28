package api.my_market_advisor.resource;

public class LogoURIHandler implements URIHandler{
    private URI logoURI;
    
    public LogoURIHandler(String symbol) {
        logoURI = iEXCloudComponents.getProperties().getLogo()
            .expand(symbol,iEXCloudComponents.getProperties().getIex_cloud_key())
            .toURI();
    }
    
    public URI getURI() {
        return logoURI;
    }
}