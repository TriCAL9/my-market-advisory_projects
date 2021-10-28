package api.my_market_advisor.resource;

public class CompanyURIHandler implements URIHandler{
    
    private URI companyURI;
    
    @Autowire
    private IEXCloudComponents iexCloudComponents

    public CompanyURIHandler(String symbol) {
        companyURI = iexCloudComponents.getIexCloudProperties.getCompanyUrl()
        .expand(symbol,StockProfile.PARAMETER,iexCloudProperties().getIex_cloud_key())
        .toURI();
    }
    
    public URI getURI() {
        return companyURI;
    }
}