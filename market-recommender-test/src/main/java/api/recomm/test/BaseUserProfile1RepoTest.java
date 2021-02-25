package api.recomm.test;

import com.marketav.commons.base.data.BaseUserProfile1;
import com.marketav.commons.base.repo.BaseUserProfile1Repo;
import com.marketav.commons.implemented.WildCardConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
@Test(groups = "testUserProfile")
public abstract class BaseUserProfile1RepoTest<U extends BaseUserProfile1<ID>, ID> extends AbstractTestNGSpringContextTests {
    @Autowired
    BaseUserProfile1Repo<U, ID> userProfile1Repo;

    @Autowired
    WildCardConverter converter;

    protected abstract U createUserProfile1(String profileName, String profileEmail, String pass);


    @BeforeMethod(dependsOnGroups = {"testUserProfile2", "testMember"})
    public void clearDatabase() {
        if (userProfile1Repo.count() > 0) {
            userProfile1Repo.deleteAll();
        }
    }

    @Test(groups = "testUserProfile")
    public void testOperations() {
        assertEquals(userProfile1Repo.count(), 0);
        U user1 = createUserProfile1("Owner", "cartworld@shopping.com", "xxxxx");
        U user2 = createUserProfile1("member", "lookatusbunch@outlook.com", "xxxxx");
        userProfile1Repo.save(user1);
        assertEquals(userProfile1Repo.count(), 1);
        Optional<U> user = userProfile1Repo.findByProfileEmail(user1.getProfileEmail());
        assertTrue(user.isPresent());
        assertEquals(user.get().getProfileName(), user1.getProfileName());
        userProfile1Repo.save(user2);
        Optional<U> userAgain = userProfile1Repo.findByProfileEmail(user2.getProfileEmail());
        assertEquals(userAgain.get().getProfileName(), user2.getProfileName());
        assertEquals(userProfile1Repo.count(), 2);
    }
}