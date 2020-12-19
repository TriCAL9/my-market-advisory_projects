package com.unknown.commons.base.repo;

import com.unknown.commons.base.data.BaseStrategy;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface BaseStrategyRepo<T extends BaseStrategy<ID>, ID extends Serializable> extends CrudRepository<T, ID> {
}
