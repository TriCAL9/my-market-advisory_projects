package com.marketav.jdbc;

import api.recomm.test.BaseCommentsRepoTest;
import com.marketav.jdbc.scaffold.model.Comments;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CommentsRepoTest extends BaseCommentsRepoTest<Comments, String> {
    @Override
    protected Comments createComments(String comments, int memberId, String email) {
        return Comments.of(comments, memberId, email);
    }
}
