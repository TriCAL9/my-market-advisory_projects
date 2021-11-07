package api.my_market_advisor.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriTemplate;

import lombok.Getter;
import lombok.Setter;


@ConfigurationProperties("app")
@PropertySource("classpath:application.properties")
@Getter
@Setter
public final class IEXCloudProperties {
   
    @Value("${app.url}")
    private UriTemplate url;
    @Value("${app.companyUrl}")
    private UriTemplate companyUrl;
    @Value("${historicalUrl")
    private UriTemplate historicalUrl;
    @Value("${app.last}")
    private UriTemplate last;
    @Value("${app.logo}")
    private UriTemplate logo;
    @Value("${app.iex_cloud_key}")
    private String iex_cloud_key;
}