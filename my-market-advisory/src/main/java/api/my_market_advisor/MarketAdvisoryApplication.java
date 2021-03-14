package api.my_market_advisor;


import api.my_market_advisor.resource.IEXCloudProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(IEXCloudProperties.class)
public class MarketAdvisoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarketAdvisoryApplication.class, args);
    }
    //TODO Add Logger:
    // - determine if this is the Class to add a Logger.
}
