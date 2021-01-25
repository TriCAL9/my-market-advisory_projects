package com.marketav.commons.base.repo;

import com.marketav.commons.base.data.BaseUserProfile1;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BaseUserProfile1Repo<T extends BaseUserProfile1<ID>, ID> extends CrudRepository<T, ID> {
    Optional<T> findByProfileEmail(ID email);
}
