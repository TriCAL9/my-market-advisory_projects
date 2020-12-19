package com.unknown.commons.base.repo;

import com.unknown.commons.base.data.BaseSymbol;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface BaseSymbolRepo<T extends BaseSymbol<ID>, ID extends Serializable> extends CrudRepository<T, ID> {
}