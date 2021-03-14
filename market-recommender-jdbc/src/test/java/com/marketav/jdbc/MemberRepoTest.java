package com.marketav.jdbc;

import api.recomm.test.BaseMemberRepoTest;
import com.marketav.jdbc.scaffold.model.Member;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepoTest extends BaseMemberRepoTest<Member, Integer> {
    @Override
    protected Member createMember(Integer memberId, String email, Integer participant, String participantEmail, String memberFirstName) {
        return Member.of(memberFirstName, "Montana", memberId, email);
    }

}
