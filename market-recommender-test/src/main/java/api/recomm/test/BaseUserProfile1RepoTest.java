package api.recomm.test;

import com.marketav.commons.base.data.*;
import com.marketav.commons.base.repo.*;
import com.marketav.commons.implemented.WildCardConverter;
import com.marketav.commons.implemented.id.TradeNonEmbeddedId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BaseUserProfile1RepoTest<U extends BaseUserProfile1<ID1>, M extends BaseMember<ID2>
        , C extends BaseComments<ID3>, R extends BaseRatingSubscription<ID4>
        , T extends BaseTrade, ID1, ID2, ID3, ID4> extends AbstractTestNGSpringContextTests {

    @Autowired
    BaseUserProfile1Repo<U, ID1> userProfile1Repo;
    @Autowired
    BaseMemberRepo<M, ID2> memberRepo;
    @Autowired
    BaseCommentsRepo<C, ID3> commentsRepo;
    @Autowired
    BaseRatingSubscriptionRepo<R, ID4> ratingSubscriptionRepo;
    @Autowired
    BaseTradeRepo<T, TradeNonEmbeddedId> tradeRepo;
    @Autowired
    WildCardConverter converter;

    public BaseTradeRepo<T, TradeNonEmbeddedId> getTradeRepo() {
        return tradeRepo;
    }

    public BaseCommentsRepo<C, ID3> getCommentsRepo() {
        return commentsRepo;
    }

    public BaseRatingSubscriptionRepo<R, ID4> getRatingSubscriptionRepo() {
        return ratingSubscriptionRepo;
    }

    public BaseMemberRepo<M, ID2> getMemberRepo() {
        return memberRepo;
    }

    public BaseUserProfile1Repo<U, ID1> getUserProfile1Repo() {
        return userProfile1Repo;
    }

    public WildCardConverter getConverter() {
        return converter;
    }

    protected abstract U createUserProfile1(String profileName, String profileEmail, String pass);

    @BeforeMethod
    protected abstract void clearData();

    @Test(alwaysRun = true)
    public void testOperations() {
        U user1 = createUserProfile1("Owner", "cartworld@shopping.com", "xxxxx");
        U user2 = createUserProfile1("member", "lookatusbunch@outlook.com", "xxxxx");
        userProfile1Repo.save(user1);
        assertEquals(userProfile1Repo.count(), 1);
        Optional<U> user = userProfile1Repo.findByProfileEmail(user1.getProfileEmail());
        assertTrue(user.isPresent());
        assertEquals(user.get().getProfileName(), user1.getProfileName());
        userProfile1Repo.save(user2);
        Optional<U> userAgain = userProfile1Repo.findByProfileEmail(user2.getProfileEmail());
        assertTrue(userAgain.isPresent());
        assertEquals(userAgain.get().getProfileName(), user2.getProfileName());
        assertEquals(userProfile1Repo.count(), 2);
    }
}