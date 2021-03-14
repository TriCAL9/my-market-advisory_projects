package api.recomm.test;

import com.marketav.commons.base.data.BaseMarketplaceWatchlist2;
import com.marketav.commons.base.repo.BaseMarketplaceWatchlist2Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
@Test(groups = "testWatchlist2", dependsOnGroups = "testWatchlist1")
public abstract class BaseMarketplaceWatchlist2RepoTest<M extends BaseMarketplaceWatchlist2<ID>, ID> extends AbstractTestNGSpringContextTests {
    @Autowired
    BaseMarketplaceWatchlist2Repo<M, ID> marketplaceWatchlist2Repo;

    protected abstract M createMarketplaceWatchlist2(Integer marketId, String marketPortfolioName);

    @Test
    public void testOperations() {
        M firstWatchlist = createMarketplaceWatchlist2(1, "Long-term Holds");
        M secondWatchlist = createMarketplaceWatchlist2(2, "Short-term Holds");
        marketplaceWatchlist2Repo.save(firstWatchlist);
        assertEquals(marketplaceWatchlist2Repo.count(), 2);
        Optional<M> portfolio = marketplaceWatchlist2Repo.findByMarketId(1);
        assertTrue(portfolio.isPresent());
        marketplaceWatchlist2Repo.save(secondWatchlist);
        assertEquals(marketplaceWatchlist2Repo.count(), 2);
        List<M> memberListsofPortfolio = marketplaceWatchlist2Repo.findAllByMarketId(2);
        assertEquals(memberListsofPortfolio.size(), 1);
    }
}