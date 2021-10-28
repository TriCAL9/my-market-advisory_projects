package api.my_market_advisor.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;

import api.my_market_advisor.components.IEXCloudComponent;
import api.my_market_advisor.model.StockProfile;

public class CompanyURIHandler implements URIHandler {
    
    private URI companyURI;
    
    @Autowired
    private IEXCloudComponent iexCloudComponents;

    public CompanyURIHandler(String symbol) {
        companyURI = iexCloudComponents.getProperties().getCompanyUrl()
        .expand(symbol,StockProfile.getPARAMETER(), iexCloudComponents.getProperties().getIex_cloud_key())
        .toURI();
    }
    
    public URI getURI() {
        return companyURI;
    }
}