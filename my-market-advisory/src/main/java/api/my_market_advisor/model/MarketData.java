package api.my_market_advisor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class MarketData {
    private final String symbol;

    public MarketData(Builder<?> builder) {
        symbol = builder.symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract static class Builder<T extends Builder<?>> {

        private String symbol;

        public Builder addSymbol(String symbol) {
            this.symbol = symbol;
            return self();
        }

        protected abstract T self();

        public abstract MarketData build();

    }
}
