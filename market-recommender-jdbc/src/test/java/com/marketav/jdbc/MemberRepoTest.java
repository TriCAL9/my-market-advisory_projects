package com.marketav.jdbc;

import api.recomm.test.BaseMemberRepoTest;
import com.marketav.jdbc.scaffold.model.Comments;
import com.marketav.jdbc.scaffold.model.Member;
import com.marketav.jdbc.scaffold.model.RatingSubscription;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testng.annotations.BeforeMethod;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepoTest extends BaseMemberRepoTest<Member, Comments, RatingSubscription, Integer, String, String> {
    @Override
    protected Member createMember(Integer memberId, String email, Integer participant, String participantEmail, String memberFirstName) {
        return Member.of(memberFirstName, "Montana", memberId, email);
    }

    @BeforeMethod
    @Override
    protected void clearData() {
        this.getRatingSubscriptionRepo().deleteAll();
        this.getCommentsRepo().deleteAll();
        this.getMemberRepo().deleteAll();
    }
}
