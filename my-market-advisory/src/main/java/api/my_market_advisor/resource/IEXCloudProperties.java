package api.my_market_advisor.resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.util.UriTemplate;

import lombok.Getter;
import lombok.Setter;


@ConfigurationProperties("app")
@Getter
@Setter
public final class IEXCloudProperties {
    private UriTemplate url;
    private UriTemplate companyUrl;
    private UriTemplate historicalUrl;
    private UriTemplate last;
    private UriTemplate logo;
    private String iex_cloud_key;
}