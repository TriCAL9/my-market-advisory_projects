package api.recomm.test;

import com.marketav.commons.base.data.BaseMember;
import com.marketav.commons.base.repo.BaseMemberRepo;
import com.marketav.commons.implemented.WildCardConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = "create member")
public abstract class BaseMemberRepoTest<M extends BaseMember<ID>, ID> extends AbstractTestNGSpringContextTests {

    @Autowired
    BaseMemberRepo<M, ID> memberRepo;

    @Autowired
    WildCardConverter converter;

    @Autowired

    protected abstract M createMember(Integer memberId, String email, Integer participant, String participantEmail, String memberFirstName, String memberLastName);

    @Test
    public void testOperation() {
//        assertEquals(memberRepo.count(), 0);
        M firstEntity = createMember(1, "cartworld@shopping.com", null, null, "Hannah", "Montana");
        M secondEntity = createMember(2, "lookatusbunch@outlook.com", 1, "cartworld@shopping.com", "Laura", "Montana");
        memberRepo.save(firstEntity);
        Optional<M> member = memberRepo.findMemberMemberIdByMemberIdAndProfileEmail((Integer) firstEntity.getMemberId()
                , firstEntity.getProfileEmail());
        assertTrue(member.isPresent());
        assertEquals(member.get(), firstEntity);

        List<M> query = memberRepo.findDistinctMemberAllByProfileEmail(firstEntity.getProfileEmail());
        assertEquals(query.size(), 1);
        assertEquals(query.get(0), firstEntity);
        memberRepo.save(secondEntity);
        query = memberRepo.findDistinctMemberAllByProfileEmail(secondEntity.getProfileEmail());
        assertEquals(query.size(), 1);
    }
}