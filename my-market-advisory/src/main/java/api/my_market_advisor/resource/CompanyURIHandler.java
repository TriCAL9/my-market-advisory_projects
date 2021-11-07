package api.my_market_advisor.resource;

import java.net.URI;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import api.my_market_advisor.components.IEXCloudComponent;
import api.my_market_advisor.model.StockProfile;
@Component
public class CompanyURIHandler implements URIHandler {
    
    private URI companyURI;

    @Autowired
    private IEXCloudComponent iexCloudComponents;

    public CompanyURIHandler(String symbol) {
        Objects.requireNonNull(symbol);
        companyURI = iexCloudComponents.getIexCloudProperties().getCompanyUrl()
        .expand(symbol,StockProfile.getPARAMETER(), iexCloudComponents.getIexCloudProperties().getIex_cloud_key());
    }

    public URI getURI() {
        return companyURI;
    }
}