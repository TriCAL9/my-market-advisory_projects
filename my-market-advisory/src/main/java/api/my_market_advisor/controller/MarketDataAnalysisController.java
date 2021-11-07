package api.my_market_advisor.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import api.my_market_advisor.model.HistoricalStockPrice;
import api.my_market_advisor.model.HistoricalStockPriceRequestHandler;
import api.my_market_advisor.resource.HistoricalStockPriceURIHandler;

@RequestMapping("/watchlist")
@RestController
public class MarketDataAnalysisController extends RestTemplate {

    @Autowired
    private RestTemplateBuilder builder;


    @GetMapping(value = "/adds", params = {"symbol", "id", "range"}, produces =  "text/html")
    public ResponseEntity<List<HistoricalStockPrice>>addsToWatchlist(@RequestParam String symbol, @RequestParam String id, @RequestParam String range) {
        
        //URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        //.path("{symbol}/watchlist/{id}")
      //  .buildAndExpand(symbol, id)
        //.toUri();
        List<HistoricalStockPrice> historicalStockPrice = new HistoricalStockPriceRequestHandler( new HistoricalStockPriceURIHandler(symbol, range), restTemplate(builder)).getHistoricalStockPrice();
        ResponseEntity<List<HistoricalStockPrice>> resultingEntity =  ResponseEntity.ok().body(historicalStockPrice);
        return resultingEntity;
    }
    
    @ModelAttribute("symbol")
    private String[] generateSymbolList(String symbol) {
        Pattern p = Pattern.compile("(\\n)(,)( )");
        Matcher m = p.matcher(symbol);
        boolean multiLine = m.find();
        if(multiLine) {
        int symbolCount = symbol.split("\\n").length;
        String[] symbolList = new String[symbolCount];
        symbolList = symbol.split("\\n");
        return symbolList;
        }
        else {
        String[] empty = {""};
        return empty;
        }
    }

    private RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}