package api.recomm.test;

import com.marketav.commons.base.data.BaseMarketplaceWatchlist1;
import com.marketav.commons.base.repo.BaseMarketplaceWatchlist1Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.assertEquals;

public abstract class BaseMarketplaceWatchlist1RepoTest<M extends BaseMarketplaceWatchlist1> extends AbstractTestNGSpringContextTests {

    @Autowired
    BaseMarketplaceWatchlist1Repo<M, LocalDate> marketplaceWatchlist1Repo;

    protected abstract M createMarketWatchlist(LocalDate transactionDate, Integer marketId, BaseMarketplaceWatchlist1.Asset assetType);

    @BeforeMethod
    public void clearDatabase() {
        marketplaceWatchlist1Repo.deleteAll();
    }

    @Test
    public void testOperation() {
        M watchlist1 = createMarketWatchlist(LocalDate.now(), 1, BaseMarketplaceWatchlist1.Asset.STOCK);
        M secondWatchlist11 = createMarketWatchlist(LocalDate.from(LocalDate.now()), 2, BaseMarketplaceWatchlist1.Asset.EFT);
        marketplaceWatchlist1Repo.save(watchlist1);
        marketplaceWatchlist1Repo.save(secondWatchlist11);
        assertEquals(marketplaceWatchlist1Repo.count(), 2);
    }
}