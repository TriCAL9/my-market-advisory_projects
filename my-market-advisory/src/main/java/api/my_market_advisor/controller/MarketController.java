package api.my_market_advisor.controller;

import api.my_market_advisor.model.Logo;
import api.my_market_advisor.model.News;
import api.my_market_advisor.model.StockProfile;
import api.my_market_advisor.resource.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class MarketController extends RestTemplate {
    private final AppProperties properties;

    @Autowired
    public MarketController(AppProperties properties) {
        this.properties = properties;
    }

    @Autowired
    RestTemplateBuilder builder;

    @GetMapping(value = "{symbol}/{last}")
    public ModelAndView feedNews(@PathVariable(name = "symbol") String symbol
            , @PathVariable(name = "last") String last) {
        final ModelAndView news = new ModelAndView("news");
        var size = Integer.parseInt(last);
        List<News> latestNews = new ArrayList<>();
        for (News.Builder builders : buildMarketData(symbol, size, News.Builder[].class)) {
            var news1 = builders.build();
            latestNews.add(builders.addSummary(news1.getSummary()).build());
        }
        news.addObject("stockProfile", buildMarketData(symbol, StockProfile.Builder.class).addSymbol(symbol).build());
        news.addObject("latestNews", latestNews);
        news.addObject("logo", getLogo(symbol));
        return news;
    }

    public News.Builder[] buildMarketData(String symbol, int size, Class<? extends News.Builder[]> news) {
        return Objects.requireNonNull(restTemplate(builder).getForObject(initializeURI(symbol, News.getPARAMETER(), size),
                news), "A null object is not accepted. "
                + "It is recommended that you check the structure of the Json object before continuing.");
    }

    public StockProfile.Builder buildMarketData(String symbol, Class<? extends StockProfile.Builder> stockProfile) {
        return Objects.requireNonNull(restTemplate(builder).getForObject(initializeURI(symbol, StockProfile.getPARAMETER()),
                stockProfile), "A null object is not accepted. "
                + "It is recommended that you check the structure of the Json object before continuing.");
    }

    public Logo getLogo(String symbol) {
        var temp = properties.getLogo().expand(symbol, properties.getIex_cloud_key());
        return Objects.requireNonNull(restTemplate(builder).getForObject(temp.toString(), Logo.class), "Logo not found");
    }

    @Bean
    private RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    private String initializeURI(String symbol, String filter, int last) {
        return this.properties.getUrl().expand(symbol, filter, this.properties.getLast().expand(last), this
                .properties.getIex_cloud_key()).toString();
    }

    private String initializeURI(String symbol, String filter) {
        return this.properties.getCompanyUrl().expand(symbol, filter, this.properties.getIex_cloud_key()).toString();
    }

}