package api.my_market_advisor.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;

import api.my_market_advisor.model.StockProfile;

public class CompanyURIHandler implements URIHandler {
    
    private URI companyURI;
    
    @Autowired
    private IEXCloudProperties iexCloudProperties;

    public CompanyURIHandler(String symbol) {
        companyURI = URI.create(iexCloudProperties.getCompanyUrl()
        .expand(symbol,StockProfile.getPARAMETER(), iexCloudProperties.getIex_cloud_key()).toString());
    }
    
    public URI getURI() {
        return companyURI;
    }
}