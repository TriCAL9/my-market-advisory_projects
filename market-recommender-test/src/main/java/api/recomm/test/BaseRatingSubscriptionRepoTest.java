package api.recomm.test;


import com.marketav.commons.base.data.BaseRatingSubscription;
import com.marketav.commons.base.repo.BaseRatingSubscriptionRepo;
import com.marketav.commons.implemented.WildCardConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BaseRatingSubscriptionRepoTest<R extends BaseRatingSubscription<ID>, ID> extends AbstractTestNGSpringContextTests {
    @Autowired
    WildCardConverter wildCardConverter;

    @Autowired
    BaseRatingSubscriptionRepo<R, ID> ratingSubscriptionRepo;

    @BeforeMethod
    protected abstract void clearRatingSubscription();

    public WildCardConverter getWildCardConverter() {
        return wildCardConverter;
    }

    public BaseRatingSubscriptionRepo<R, ID> getRatingSubscriptionRepo() {
        return ratingSubscriptionRepo;
    }

    @Test
    public void testOperation() {
        assertEquals(ratingSubscriptionRepo.count(), 0);
        R firstEntity = createSubscription("MACD indicator", "cartworld@shopping.com", 1);
        R secondEntity = createSubscription("ATR indicator", "lookatusbunch@outlook.com", 2);
        ratingSubscriptionRepo.save(firstEntity);
        Optional<R> rating = ratingSubscriptionRepo.findRatingSubscriptionByMemberRatingSubscriptionAndMemberId(
                firstEntity.getMemberRatingSubscription(), firstEntity.getMemberId());
        assertTrue(rating.isPresent());
    }

    protected abstract R createSubscription(String rating, String email, int memberId);
}