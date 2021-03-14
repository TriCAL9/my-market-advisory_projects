package api.recomm.test;

import com.marketav.commons.base.data.BaseComments;
import com.marketav.commons.base.repo.BaseCommentsRepo;
import com.marketav.commons.implemented.WildCardConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
@Test(groups = {"testComments"})
public abstract class BaseCommentsRepoTest<C extends BaseComments<ID>, ID extends Serializable> extends AbstractTestNGSpringContextTests {

    @Autowired
    BaseCommentsRepo<C, ID> commentsRepo;

    @Autowired
    WildCardConverter converter;

    protected abstract C createComments(String comments, int memberId, String email);

    @Test(dependsOnGroups = "testMemberQueries")
    public void testOperation() {
        assertEquals(commentsRepo.count(), 0);
        C firstEntity = createComments("Hello! This is taking forever.", 1, "cartworld@shopping.com");
        C secondEntity = createComments("It worked!", 2, "lookatusbunch@outl" +
                "ook.com");
        commentsRepo.save(firstEntity);
        Optional<C> comment = commentsRepo.findByMemberCommentsAndMemberIdAndProfileEmail(firstEntity.getMemberComments(), firstEntity.getMemberId(), firstEntity.getProfileEmail());
        Optional<C> specificComment = commentsRepo.findByMemberComments(firstEntity.getMemberComments());
        assertTrue(comment.isPresent());
        assertEquals(comment.get(), firstEntity);
        List<C> query = commentsRepo.findAllByMemberId(1);
        assertEquals(query.size(), 1);
        assertEquals(query.get(0), secondEntity);
        commentsRepo.save(secondEntity);
        query = commentsRepo.findDistinctCommentsAllByProfileEmail(converter.convertToWildCard("loo"));
        assertEquals(query.size(), 0);
    }
}