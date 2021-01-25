package api.recomm.test;

import com.marketav.commons.base.data.BaseUserProfile2;
import com.marketav.commons.base.repo.BaseUserProfile2Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.io.Serializable;
import java.time.LocalDate;

import static org.testng.Assert.assertEquals;

public abstract class BaseUserProfile2RepoTest<U extends BaseUserProfile2, ID extends Serializable> extends AbstractTestNGSpringContextTests {
    @Autowired
    BaseUserProfile2Repo<U, ID> userProfile2Repo;

    public abstract BaseUserProfile2 createUserProfile2(String email, LocalDate timeIn, LocalDate timeOut, boolean signedInStatus);

    public void clearDatabase() {
        userProfile2Repo.deleteAll();
    }

    @Test
    public void testOperation() {
        assertEquals(userProfile2Repo, 0);
        BaseUserProfile2 userStamp = createUserProfile2("cartworld@shopping.com", LocalDate.now(), null, true);
        BaseUserProfile2 userStamp1 = createUserProfile2("lookatusbunch@outlook.com", LocalDate.now(), null, true);
    }

}