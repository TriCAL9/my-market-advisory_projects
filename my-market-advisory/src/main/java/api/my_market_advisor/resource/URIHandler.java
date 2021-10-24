package api.my_market_advisor.resource;

import java.net.URI;

import api.my_market_advisor.components.IEXCloudComponent;

public class URIHandler {

    public URI initializeURI(final String symbol, final String filter, final int last, final IEXCloudComponent iexCloudComponents) {
        return iexCloudComponents.getProperties().getUrl().expand(symbol, filter,
                iexCloudComponents.getProperties().getLast().expand(last),
                iexCloudComponents.getProperties().getIex_cloud_key());
    }

    public URI initializePricesURI(final String symbol, final String range, final IEXCloudComponent iexCloudComponents) {
        return iexCloudComponents.getProperties().getHistoricalUrl().expand(symbol, range,
                iexCloudComponents.getProperties().getIex_cloud_key());
    }

    public URI initializeURI(final String symbol, final String filter, final IEXCloudComponent iexCloudComponents) {
        return iexCloudComponents.getProperties().getCompanyUrl().expand(symbol, filter,
                iexCloudComponents.getProperties().getIex_cloud_key());
    }

    public URI initializeURI(final String symbol, final IEXCloudComponent iexCloudComponents) {
        return iexCloudComponents.getProperties().getLogo().expand(symbol,
                iexCloudComponents.getProperties().getIex_cloud_key());

    }
}