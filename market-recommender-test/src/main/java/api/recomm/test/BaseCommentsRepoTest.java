package api.recomm.test;

import com.marketav.commons.base.data.BaseComments;
import com.marketav.commons.base.repo.BaseCommentsRepo;
import com.marketav.commons.implemented.WildCardConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BaseCommentsRepoTest<C extends BaseComments<ID>, ID> extends AbstractTestNGSpringContextTests {

    @Autowired
    BaseCommentsRepo<C, ID> commentsRepo;
    @Autowired
    WildCardConverter converter;

    public BaseCommentsRepo<C, ID> getCommentsRepo() {
        return commentsRepo;
    }

    protected abstract C createComments(String comments, int memberId, String email);

    protected abstract void clearData();

    @Test
    public void testOperation() {
        assertEquals(commentsRepo.count(), 0);
        C firstEntity = createComments("Hello! This is taking forever.", 1, "cartworld@shopping.com");
        C secondEntity = createComments("Another closer to finishing.", 1, "cartworld@shopping.com");
        C thirdEntity = createComments("It worked!", 2, "lookatusbunch@outl" +
                "ook.com");
        commentsRepo.save(firstEntity);
        commentsRepo.save(secondEntity);
        commentsRepo.save(thirdEntity);
        List<C> comments = commentsRepo.findAllCommentsByMemberId(1);
        assertEquals(comments.size(), 2);
        Optional<C> specificComment = commentsRepo.findByMemberComments(secondEntity.getMemberComments());
        assertTrue(specificComment.isPresent());
        assertEquals(specificComment.get(), secondEntity);
        List<C> query = commentsRepo.findAllCommentsByMemberId(2);
        assertEquals(query.size(), 1);
        assertEquals(query.get(0), thirdEntity);
        commentsRepo.save(thirdEntity);
        query = commentsRepo.findDistinctCommentsAllByProfileEmail(converter.convertToWildCard("loo"));
        assertEquals(query.size(), 0);
    }
}