package com.marketav.jdbc;

import api.recomm.test.BaseMemberRepoTest;
import com.marketav.jdbc.scaffold.model.Member;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepoTest extends BaseMemberRepoTest<Member, Integer> {
    protected Member createMember(Integer memberId, String email, Integer participant, String participantEmail, String memberFirstName, String memberLastName) {
        return Member.of(memberFirstName, memberLastName, memberId, email);
    }

}
