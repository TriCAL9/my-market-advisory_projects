package com.marketav.jdbc;

import api.recomm.test.BaseUserProfile1RepoTest;
import com.marketav.jdbc.scaffold.model.UserProfile1;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserProfile1RepoTest extends BaseUserProfile1RepoTest<UserProfile1, String> {
    @Override
    protected UserProfile1 createUserProfile1(String profileName, String profileEmail, String pass) {
        return UserProfile1.of(profileName, profileEmail, pass);
    }
}
