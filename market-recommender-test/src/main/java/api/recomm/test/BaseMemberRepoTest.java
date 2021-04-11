package api.recomm.test;

import com.marketav.commons.base.data.BaseComments;
import com.marketav.commons.base.data.BaseMember;
import com.marketav.commons.base.data.BaseRatingSubscription;
import com.marketav.commons.base.repo.BaseCommentsRepo;
import com.marketav.commons.base.repo.BaseMemberRepo;
import com.marketav.commons.base.repo.BaseRatingSubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BaseMemberRepoTest<M extends BaseMember<ID1>, C extends BaseComments<ID2>, R extends BaseRatingSubscription<ID3>, ID1, ID2, ID3> extends AbstractTestNGSpringContextTests {

    @Autowired
    BaseMemberRepo<M, ID1> memberRepo;
    @Autowired
    BaseCommentsRepo<C, ID2> commentsRepo;
    @Autowired
    BaseRatingSubscriptionRepo<R, ID3> ratingSubscriptionRepo;

    protected abstract M createMember(Integer memberId, String email, Integer participant, String participantEmail,
                                      String memberFirstName);

    protected abstract void clearData();

    public BaseRatingSubscriptionRepo<R, ID3> getRatingSubscriptionRepo() {
        return ratingSubscriptionRepo;
    }

    public BaseCommentsRepo<C, ID2> getCommentsRepo() {
        return commentsRepo;
    }

    public BaseMemberRepo<M, ID1> getMemberRepo() {
        return memberRepo;
    }

    @Test
    public void testOperation() {
        assertEquals(memberRepo.count(), 0);
        M firstEntity = createMember(1, "cartworld@shopping.com", null, null, "Hannah");
        M secondEntity = createMember(2, "lookatusbunch@outlook.com", 1, "cartworld@shopping.com", "Laura");

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
        Optional<M> secondMember = memberRepo.findMemberByUserProfile1ProfileName("member");
        assertTrue(secondMember.isPresent());
        assertEquals(secondMember.get().getParticipantId(), secondEntity.getParticipantId());
        assertEquals(memberRepo.count(), 2);
    }
}