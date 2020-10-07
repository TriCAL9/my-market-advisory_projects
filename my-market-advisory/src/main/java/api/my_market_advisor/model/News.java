package api.my_market_advisor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class News extends MarketData {

    private final static String PARAMETER = "news";
    private final boolean hasPayWall;
    private final int datetime;
    private final String headline;
    private final String summary;
    private final String source;
    private final String url;
    private final String image;

    News(Builder builder) {
        super(builder);
        headline = builder.headline;
        summary = builder.summary;
        source = builder.source;
        image = builder.image;
        url = builder.url;
        hasPayWall = builder.hasPayWall;
        datetime = builder.datetime;
    }

    public static String getPARAMETER() {
        return PARAMETER;
    }

    public String getHeadline() {
        return headline;
    }

    public String getSource() {
        return source;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public String toString() {
        return getClass().getName()
                + "[headline=" + getHeadline()
                + ",summary=" + getSummary()
                + ",source=" + getSource()
                + ",url=" + getUrl()
                + ",img=" + getImage()
                + ",hasPayWall=" + hasHasPayWall()
                + ",datetime=" + getDatetime() + "]";
    }

    public String getSummary() {
        return this.summary;
    }

    public boolean hasHasPayWall() {
        return hasPayWall;
    }

    public int getDatetime() {
        return datetime;
    }

    public static class Builder extends MarketData.Builder<Builder> {
        private final String headline;
        private final String source;
        private final String image;
        private final String url;
        private String summary;
        private int datetime;
        private boolean hasPayWall;

        public Builder(String headline, String source, String url, String image) {
            this.headline = Objects.requireNonNull(headline);
            this.source = (Objects.requireNonNull(source));
            this.url = (Objects.requireNonNull(url));
            this.image = (Objects.requireNonNull(image));
        }

        public Builder addSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder addDateTime(int datetime) {
            this.datetime = datetime;
            return this;
        }

        public Builder addHasPayWall(boolean hasPayWall) {
            this.hasPayWall = hasPayWall;
            return this;
        }

        @Override
        public News build() {
            return new News(self());
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

}
