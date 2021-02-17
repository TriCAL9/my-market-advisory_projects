package com.marketav.commons.base.repo;

import com.marketav.commons.base.data.BaseMember;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BaseMemberRepo<T extends BaseMember<ID>, ID> extends CrudRepository<T, ID> {

    @Query("SELECT * FROM MEMBER M " +
            "WHERE M.Member_Id = :memberId " +
            "AND M.Profile_Email = :email")
    Optional<T> findMemberByMemberIdAndProfileEmail(Integer memberId, String email);

    @Query("SELECT * FROM MEMBER WHERE Member_First_Name " +
            " = :firstname AND Member_Last_Name = :lastname")
    List<T> findAllMemberByMemberFirstnameAndMemberLastname(@Param(":firstname") String firstname, @Param(":lastname") String lastname);

    Optional<T> findDistinctMemberAllByProfileEmail(String email);
}
