package api.my_market_advisor.components;

import api.my_market_advisor.resource.IEXCloudProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
