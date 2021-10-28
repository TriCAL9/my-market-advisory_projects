package api.my_market_advisor.model;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.web.client.RestTemplate;

import api.my_market_advisor.components.IEXCloudComponent;
import api.my_market_advisor.model.StockProfile.Builder;
import api.my_market_advisor.model.StockProfile;
import api.my_market_advisor.model.News.Builder;
import api.my_market_advisor.model.News;
import api.my_market_advisor.resource.CompanyURIHandler;
import api.my_market_advisor.resource.LogoURIHandler;
import api.my_market_advisor.resource.NewsURIHandler;

public final class NewsRequestHandler{
    private List<News> news;
    private StockProfile stockProfile;
    private Logo logo;
    
    public NewsRequestHandler(RestTemplate restTemplate, CompanyURIHandler companyURIHandler, NewsURIHandler newsURIHandler, LogoURIHandler logoURIHandler) {
        stockProfile = Objects.requireNonNull(
                restTemplate.getForObject(companyURIHandler.getURI(),
                       (Class<? extends StockProfile.Builder>) StockProfile.Builder.class),
                "It is recommended that you check the structure of the Json object before continuing.");

        
        logo = Objects.requireNonNull(
             restTemplate.getForObject(logoURIHandler, Logo.class),
             "Logo not found");
        
        final News.Builder[] builders = Objects.requireNonNull(
                restTemplate.getForObject(newsURIHandler.getURI(),
                        (Class<? extends News.Builder[]>) News.Builder[].class),
                "It is recommended that you check the structure of the Json object before continuing.");
        
        news = new ArrayList<>();
        for (final News.Builder builder : builders) {
            news.add(builder.build());
        }
    }
    public Logo getLogo(){
        return logo;
    }
    public List<News> getNews() {
        return news;
    }
    public StockProfile getStockProfile() {
        return stockProfile;
    }
}