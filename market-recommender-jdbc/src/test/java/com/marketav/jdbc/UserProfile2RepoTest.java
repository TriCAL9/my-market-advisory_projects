package com.marketav.jdbc;

import api.recomm.test.BaseUserProfile2RepoTest;
import com.marketav.jdbc.scaffold.model.UserProfile2;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserProfile2RepoTest extends BaseUserProfile2RepoTest<UserProfile2, LocalDate> {

    @Override
    protected UserProfile2 createUserProfile2(String email, LocalDate timeIn, LocalDate timeOut, boolean signedInStatus) {
        return UserProfile2.of(timeOut, email, timeIn);
    }

    @Override
    protected void clearData() {
        this.getUserProfile2Repo().deleteAll();
    }
}
