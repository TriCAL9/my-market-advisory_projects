package api.my_market_advisor.resource;

import java.net.URI;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import api.my_market_advisor.model.StockProfile;
@Component
public class CompanyURIHandler implements URIHandler {
    
    private URI companyURI;
    
    @Autowired
    private IEXCloudProperties iexCloudProperties;

    public CompanyURIHandler(String symbol) {
        companyURI = Objects.requireNonNull(URI.create(iexCloudProperties.getCompanyUrl()
        .expand(symbol,StockProfile.getPARAMETER(), iexCloudProperties.getIex_cloud_key()).toString()), "Attempt to fix null issue");
    }
    
    public URI getURI() {
        return companyURI;
    }
}