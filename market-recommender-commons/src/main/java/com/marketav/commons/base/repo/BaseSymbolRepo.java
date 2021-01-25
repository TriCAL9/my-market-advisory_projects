package com.marketav.commons.base.repo;

import com.marketav.commons.base.data.BaseSymbol;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface BaseSymbolRepo<T extends BaseSymbol<ID>, ID extends Serializable> extends CrudRepository<T, ID> {
}
