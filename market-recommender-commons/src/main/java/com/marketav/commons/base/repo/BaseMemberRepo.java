package com.marketav.commons.base.repo;

import com.marketav.commons.base.data.BaseMember;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BaseMemberRepo<T extends BaseMember<ID>, ID> extends CrudRepository<T, ID> {
    Optional<T> findMemberMemberIdByMemberIdAndProfileEmail(Integer memberId, String email);

    List<T> findDistinctMemberAllByProfileEmail(String email);
}
