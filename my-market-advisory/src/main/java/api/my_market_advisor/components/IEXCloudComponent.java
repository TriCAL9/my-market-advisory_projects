package api.my_market_advisor.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import api.my_market_advisor.resource.IEXCloudProperties;

@Configuration
@ComponentScan("api.my_market_advisor")
public class IEXCloudComponent {
    @Autowired
    private IEXCloudProperties iexCloudProperties;
   
    public IEXCloudProperties getIexCloudProperties() {
        return iexCloudProperties;
    }
}