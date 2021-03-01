package api.my_market_advisor.service;

import api.my_market_advisor.resource.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarketControllerProperties {
    private final AppProperties properties;

    @Autowired
    public MarketControllerProperties(AppProperties properties) {
        this.properties = properties;
    }

    public AppProperties getProperties() {
        return properties;
    }
}
