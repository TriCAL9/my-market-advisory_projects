package api.my_market_advisor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockProfile extends MarketData {

    private final static String PARAMETER = "company";
    private final String companyName;
    private final String description;
    private final String exchange;
    private final String website;

    private StockProfile(final Builder builder) {
        super(builder);
        this.companyName = builder.companyName;
        this.description = builder.description;
        this.exchange = builder.exchange;
        this.website = builder.website;
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

    public String getWebsite() {
        return website;
    }

    public static class Builder extends MarketData.Builder<Builder> {
        private final String companyName;
        private final String description;
        private final String exchange;
        private final String website;
        
        public Builder(String companyName, String description, String exchange,
                String website) {
            this.companyName = companyName;
            this.description = description;
            this.exchange = exchange;
            this.website = website;
        }

        @Override
        public StockProfile build() {
            return new StockProfile(self());
        }

        @Override
        protected Builder self() {
            return this;
        }
    }


}