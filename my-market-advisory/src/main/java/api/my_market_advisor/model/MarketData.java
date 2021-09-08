package api.my_market_advisor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class MarketData {
    private final String symbol;

    public String getSymbol() {
        return symbol;
    }

    MarketData(Builder<?> builder) {
        symbol = builder.symbol;
    }

    abstract static class Builder<T extends Builder<T>> {

        private String symbol;

        public T setSymbol(String symbol) {
            this.symbol = symbol;
            return self();
        }

        protected abstract T self();

        public abstract MarketData build();

    }
}
