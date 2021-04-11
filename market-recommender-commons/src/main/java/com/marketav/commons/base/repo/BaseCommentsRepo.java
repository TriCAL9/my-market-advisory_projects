package com.marketav.commons.base.repo;

import com.marketav.commons.base.data.BaseComments;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BaseCommentsRepo<T extends BaseComments<ID>, ID> extends CrudRepository<T, ID> {
    @Query("select c from Comments where c.Member_Comments = :comment")
    Optional<T> findByMemberComments(@Param("comment") ID comment);

    @Query("select distinct u from Comments where u.Profile_Email = :email")
    List<T> findDistinctCommentsAllByProfileEmail(@Param("email") String profileEmail);

    @Query("select c from Comments where c.Member_Id = :member_id")
    List<T> findAllCommentsByMemberId(@Param("member_id") int id);
}
