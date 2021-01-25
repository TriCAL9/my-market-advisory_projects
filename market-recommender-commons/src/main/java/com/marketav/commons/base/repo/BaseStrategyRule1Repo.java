package com.marketav.commons.base.repo;

import com.marketav.commons.base.data.BaseStrategyRule1;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface BaseStrategyRule1Repo<S extends BaseStrategyRule1<ID>,
        ID extends Serializable> extends CrudRepository<S, ID> {
}
