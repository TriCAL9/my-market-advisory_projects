package com.marketav.commons.base.repo;

import com.marketav.commons.base.data.BaseComments;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BaseCommentsRepo<T extends BaseComments<ID>, ID> extends CrudRepository<T, ID> {

    Optional<T> findByMemberComments(ID comment);

    List<T> findAllByMemberId(Integer id);

    List<T> findDistinctCommentsAllByProfileEmail(String profileEmail);

    Optional<T> findByMemberCommentsAndMemberIdAndProfileEmail(ID memberComment, int i, ID email);
}
