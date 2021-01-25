package com.marketav.commons.base.repo;

import com.marketav.commons.base.data.BaseTrade;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface BaseTradeRepo<T extends BaseTrade, ID extends Serializable>
        extends CrudRepository<T, ID> {
}
