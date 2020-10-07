package api.my_market_advisor;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketAdvisoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarketAdvisoryApplication.class, args);
    }
    //TODO Add Logger:
    // - determine if this is the Class to add Logger in.
    // - Log getImage return value
    // - use toString method with logger

    //TODO Add Class:
    // - necessary login classes
    // - create resource for - feature to consider; recommendation feature
    // - create backend classes for recommendation feature

    //FIXME
    // - image property in class StockProfile

}