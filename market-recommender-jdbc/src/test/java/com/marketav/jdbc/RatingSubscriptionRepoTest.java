package com.marketav.jdbc;

import api.recomm.test.BaseRatingSubscriptionRepoTest;
import com.marketav.jdbc.scaffold.model.RatingSubscription;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RatingSubscriptionRepoTest extends BaseRatingSubscriptionRepoTest<RatingSubscription, String> {
    @Override
    protected RatingSubscription createSubscription(String rating, String email, int memberId) {
        return RatingSubscription.of(rating, email, memberId);
    }

    @Override
    protected void clearRatingSubscription() {
        this.getRatingSubscriptionRepo().deleteAll();
    }
}
