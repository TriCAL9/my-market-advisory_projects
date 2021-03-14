package com.marketav.jdbc;

import api.recomm.test.BaseMarketplaceWatchlist1RepoTest;
import com.marketav.commons.base.data.BaseMarketplaceWatchlist1;
import com.marketav.jdbc.scaffold.model.MarketplaceWatchlist1;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MarketplaceWatchlist1RepoTest extends BaseMarketplaceWatchlist1RepoTest<MarketplaceWatchlist1, Integer> {
    @Override
    protected MarketplaceWatchlist1 createMarketWatchlist(LocalDate transactionDate, Integer marketId, BaseMarketplaceWatchlist1.Asset assetType) {
        return MarketplaceWatchlist1.of(transactionDate, marketId, assetType);
    }
}
