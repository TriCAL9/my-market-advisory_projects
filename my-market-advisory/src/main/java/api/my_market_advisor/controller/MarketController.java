package api.my_market_advisor.controller;

import api.my_market_advisor.components.IEXCloudComponent;
import api.my_market_advisor.model.Logo;
import api.my_market_advisor.model.News;
import api.my_market_advisor.model.StockProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
class MarketController extends RestTemplate {
    @Autowired
    private IEXCloudComponent iexCloudComponent;
    @Autowired
    private RestTemplateBuilder builder;

    @GetMapping(value = "{symbol}/{last}")
    public ModelAndView feedNews(@PathVariable(name = "symbol") String symbol
            , @PathVariable(name = "last") String last) {
        final ModelAndView news = new ModelAndView("news");
        final var size = Integer.parseInt(last);
        news.addObject("stockProfile", buildMarketData(symbol));
        news.addObject("latestNews", buildMarketData(symbol, size));
        news.addObject("logo", getLogo(symbol));
        return news;
    }

    List<News> buildMarketData(String symbol, int size) {
        News.Builder[] builders = Objects.requireNonNull(restTemplate(builder).getForObject(initializeURI(symbol,
                News.getPARAMETER(), size), (Class<? extends News.Builder[]>) News.Builder[].class),
                "A null object is not accepted. It is recommended that you check the structure of the Json" +
                        " object before continuing.");
        List<News> latestNews = new ArrayList<>();
        for (News.Builder builder : builders) {
            latestNews.add(builder.build());
        }
        return latestNews;
    }

    StockProfile buildMarketData(String symbol) {
        StockProfile.Builder builder1 = Objects.requireNonNull(restTemplate(builder).getForObject(initializeURI(symbol, StockProfile.getPARAMETER()),
                (Class<? extends StockProfile.Builder>) StockProfile.Builder.class), "A null object is not accepted. "
                + "It is recommended that you check the structure of the Json object before continuing.");
        return builder1.addSymbol(symbol).build();
    }

    Logo getLogo(String symbol) {
        var temp = iexCloudComponent.getProperties().getLogo().expand(symbol, iexCloudComponent.getProperties().getIex_cloud_key());
        return Objects.requireNonNull(restTemplate(builder).getForObject(temp.toString(), Logo.class), "Logo not found");
    }

    @Bean
    private RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    protected URI initializeURI(String symbol, String filter, int last) {
        return iexCloudComponent.getProperties().getUrl().expand(symbol, filter,
                iexCloudComponent.getProperties().getLast().expand(last),
                iexCloudComponent.getProperties().getIex_cloud_key());
    }

    protected URI initializeURI(String symbol, String filter) {
        return iexCloudComponent.getProperties().getCompanyUrl().expand(symbol,
                filter, iexCloudComponent.getProperties().getIex_cloud_key());
    }

}