package api.my_market_advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import api.my_market_advisor.model.NewsRequestHandler;
import api.my_market_advisor.resource.CompanyURIHandler;
import api.my_market_advisor.resource.LogoURIHandler;
import api.my_market_advisor.resource.NewsURIHandler;

@RestController
@RequestMapping("news")
class MarketController extends RestTemplate{

    @Autowired
    private RestTemplateBuilder builder;

    @GetMapping(value = "{symbol}/{last}")
    public ModelAndView feedNews(@PathVariable(name = "symbol") final String symbol,
            @PathVariable(name = "last") final String last) {
        final var news = new ModelAndView("news");
        final var size = Integer.parseInt(last);
        CompanyURIHandler companyURI = new CompanyURIHandler(symbol);
        NewsURIHandler newsURI = new NewsURIHandler(size, symbol);
        LogoURIHandler logoURI = new  LogoURIHandler(symbol);
        NewsRequestHandler newsRequestHandler = new NewsRequestHandler(restTemplate(builder)
        , companyURI, newsURI, logoURI);
        news.addObject("stockProfile",newsRequestHandler.getStockProfile());
        news.addObject("latestNews", newsRequestHandler.getNews());
        news.addObject("logo", newsRequestHandler.getLogo());
        return news;
    }

    private RestTemplate restTemplate( RestTemplateBuilder builder){
        return builder.build();
    }
}