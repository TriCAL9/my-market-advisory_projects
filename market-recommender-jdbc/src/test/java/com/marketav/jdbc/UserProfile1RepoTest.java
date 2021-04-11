package com.marketav.jdbc;

import api.recomm.test.BaseUserProfile1RepoTest;
import com.marketav.jdbc.scaffold.model.*;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testng.annotations.BeforeMethod;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserProfile1RepoTest extends BaseUserProfile1RepoTest<UserProfile1, Member, Comments, RatingSubscription, Trade, String, Integer, String, String> {
    @Override
    protected UserProfile1 createUserProfile1(String profileName, String profileEmail, String pass) {
        return UserProfile1.of(profileName, profileEmail, pass);
    }

    @BeforeMethod
    @Override
    protected void clearData() {
        this.getTradeRepo().deleteAll();
        this.getCommentsRepo().deleteAll();
        this.getRatingSubscriptionRepo().deleteAll();
        this.getMemberRepo().deleteAll();
        this.getUserProfile1Repo().deleteAll();
    }
}
