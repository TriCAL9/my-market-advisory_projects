package com.marketav.jdbc;

import api.recomm.test.BaseMarketplaceWatchlist2RepoTest;
import com.marketav.jdbc.scaffold.model.MarketplaceWatchlist2;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MarketplaceWatchlist2RepoTest extends BaseMarketplaceWatchlist2RepoTest<MarketplaceWatchlist2, Integer> {
    @Override
    public MarketplaceWatchlist2 createMarketplaceWatchlist2(Integer marketId, String marketPortfolioName) {
        return MarketplaceWatchlist2.of(marketId, marketPortfolioName);
    }
}
