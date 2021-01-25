package com.marketav.commons.base.repo;

import com.marketav.commons.base.data.BaseStrategyRule2;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface BaseStrategyRule2Repo<T extends BaseStrategyRule2<ID>, ID extends Serializable> extends CrudRepository<T, ID> {
}
