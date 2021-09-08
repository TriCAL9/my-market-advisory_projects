package api.my_market_advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import api.my_market_advisor.components.IEXCloudComponent;
import api.my_market_advisor.model.MarketDataRequestHandler;
import api.my_market_advisor.resource.URIHandler;

@RestController
class MarketController extends RestTemplate{

    @Autowired
    private RestTemplateBuilder builder;

    @Autowired
    private IEXCloudComponent iexCloudComponent;

    private URIHandler uriHandler;

    @GetMapping(value = "{symbol}/{last}")
    public ModelAndView feedNews(@PathVariable(name = "symbol") final String symbol,
            @PathVariable(name = "last") final String last) {
        final var news = new ModelAndView("news");
        final var size = Integer.parseInt(last);
        uriHandler = new URIHandler();
        news.addObject("stockProfile", MarketDataRequestHandler.buildMarketData(restTemplate(builder), symbol, uriHandler, iexCloudComponent));
        news.addObject("latestNews", MarketDataRequestHandler.buildMarketData(restTemplate(builder), symbol, size, uriHandler, iexCloudComponent));
        news.addObject("logo", MarketDataRequestHandler.getLogo(restTemplate(builder), symbol, uriHandler, iexCloudComponent));
        return news;
    }

    private RestTemplate restTemplate( RestTemplateBuilder builder){
        return builder.build();
    }
}