package api.my_market_advisor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockProfile extends MarketData {

    private final static String PARAMETER = "company";
    private final String companyName;
    private final String description;
    private final String exchange;

    public StockProfile(Builder builder) {
        super(builder);
        this.companyName = builder.companyName;
        this.description = builder.description;
        this.exchange = builder.exchange;
    }

    public static String getPARAMETER() {
        return PARAMETER;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDescription() {
        return description;
    }

    public String getExchange() {
        return exchange;
    }

    public static class Builder extends MarketData.Builder<Builder> {
        private final String companyName;
        private final String description;
        private String exchange;

        public Builder(String companyName, String description) {
            this.companyName = companyName;
            this.description = description;
        }

        public Builder addExchange(String exchange) {
            this.exchange = Objects.requireNonNull(exchange);
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public MarketData build() {
            return new StockProfile(this);
        }
    }


}
