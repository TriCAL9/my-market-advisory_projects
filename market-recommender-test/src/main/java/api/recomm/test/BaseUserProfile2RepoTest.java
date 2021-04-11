package api.recomm.test;

import com.marketav.commons.base.data.BaseUserProfile2;
import com.marketav.commons.base.repo.BaseUserProfile2Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.Serializable;
import java.time.LocalDate;

import static org.testng.Assert.assertEquals;


public abstract class BaseUserProfile2RepoTest<U extends BaseUserProfile2, ID extends Serializable> extends AbstractTestNGSpringContextTests {
    @Autowired
    BaseUserProfile2Repo<U, ID> userProfile2Repo;

    public BaseUserProfile2Repo<U, ID> getUserProfile2Repo() {
        return userProfile2Repo;
    }

    protected abstract U createUserProfile2(String email, LocalDate timeIn, LocalDate timeOut, boolean signedInStatus);

    @BeforeMethod
    protected abstract void clearData();

    @Test
    public void testOperation() {
        assertEquals(userProfile2Repo.count(), 0);
        U userStamp = createUserProfile2("cartworld@shopping.com", LocalDate.of(LocalDate.EPOCH.getYear(), LocalDate.EPOCH.getMonth(), LocalDate.EPOCH.getDayOfMonth()), LocalDate.now().plusDays(1), true);
        U userStamp1 = createUserProfile2("lookatusbunch@outlook.com", LocalDate.of(LocalDate.EPOCH.getYear(), LocalDate.EPOCH.getMonth(), LocalDate.EPOCH.getDayOfMonth()), LocalDate.now().plusDays(3), true);
        userProfile2Repo.save(userStamp);
    }

}