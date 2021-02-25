package api.recomm.test;

import com.marketav.commons.base.data.BaseMember;
import com.marketav.commons.base.repo.BaseMemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = "testMember")
public abstract class BaseMemberRepoTest<M extends BaseMember<ID>, ID> extends AbstractTestNGSpringContextTests {

    @Autowired
    BaseMemberRepo<M, ID> memberRepo;

    @BeforeMethod(groups = "testMember")
    public void clearDatabase() {
        memberRepo.deleteAll();
    }

    protected abstract M createMember(Integer memberId, String email, Integer participant, String participantEmail,
                                      String memberFirstName, String memberLastName);

    @Test(dependsOnGroups = "testUserProfile")
    public void testOperation() {
        assertEquals(memberRepo.count(), 0);
        M firstEntity = createMember(1, "cartworld@shopping.com", null, null, "Hannah", "Montana");
        M secondEntity = createMember(2, "lookatusbunch@outlook.com", 1, "cartworld@shopping.com", "Laura", "Montana");
        M thirdEntity = createMember(3, "jajabinks@driods.net", 2, "lookatusbunch@outloook.  com", "JaJa", "Binks");

        memberRepo.save(firstEntity);
        Optional<M> member = memberRepo.findMemberByMemberIdAndProfileEmail((Integer) firstEntity.getMemberId()
                , firstEntity.getProfileEmail());
        assertTrue(member.isPresent());
        assertEquals(member.get().getProfileEmail(), firstEntity.getProfileEmail());

        List<M> query = memberRepo.findAllMemberByMemberFirstnameAndMemberLastname(firstEntity.getMemberFirstname(),
                firstEntity.getMemberLastname());
        assertEquals(query.size(), 1);
        assertEquals(query.get(0).getProfileEmail(), firstEntity.getProfileEmail());
        memberRepo.save(secondEntity);
        Optional<M> secondMember = memberRepo.findDistinctMemberAllByProfileEmail(secondEntity.getProfileEmail());
        assertTrue(secondMember.isPresent());
        assertEquals(secondMember.get(), secondEntity);
        memberRepo.save(thirdEntity);
        assertEquals(memberRepo.count(), 3);
    }
}