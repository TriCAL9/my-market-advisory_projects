package api.my_market_advisor.resource;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.util.UriTemplate;

@ConfigurationProperties("app")
@Getter
@Setter
public class IEXCloudProperties {
    private UriTemplate url;
    private UriTemplate companyUrl;
    private UriTemplate last;
    private UriTemplate logo;
    private String iex_cloud_key;
}