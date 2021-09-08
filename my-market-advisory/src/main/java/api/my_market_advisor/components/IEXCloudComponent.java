package api.my_market_advisor.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import api.my_market_advisor.resource.IEXCloudProperties;

@Component
public class IEXCloudComponent {
    private final IEXCloudProperties properties;

    @Autowired
    public IEXCloudComponent(IEXCloudProperties properties) {
        this.properties = properties;
    }

    public IEXCloudProperties getProperties() {
        return properties;
    }
}
