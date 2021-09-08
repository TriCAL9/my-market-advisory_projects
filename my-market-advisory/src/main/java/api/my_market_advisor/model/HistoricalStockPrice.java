package api.my_market_advisor.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HistoricalStockPrice extends MarketData {
    private float close;
    private String date;
    private long volume;
    
    public static class Builder extends MarketData.Builder<Builder> {
        private final float close;
        private final String date;
        private long volume;

        public Builder(float close, String date) {
            this.close  = close;
            this.date   = date;
            this.volume = -1;
        }

        public Builder setVolume(long volume) {
            this.volume = volume;
            return self();
        }

        @Override
        protected Builder self() {
            // TODO Auto-generated method stub
            return this;
        }

        @Override
        public HistoricalStockPrice build() {
            // TODO Auto-generated method stub
            return new HistoricalStockPrice(self());
        }
    }
    public HistoricalStockPrice(Builder builder) {
        super(Objects.requireNonNull(builder));
        this.close  = builder.close;
        this.date   = builder.date;
        this.volume =builder.volume;
    }

    public float getClose() {
        return close;
    }

    public String getDate() {
        return date;
    }

    public long getVolume() {
        return volume;
    }


    
}