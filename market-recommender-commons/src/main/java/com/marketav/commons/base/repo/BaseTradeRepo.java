package com.marketav.commons.base.repo;

import com.marketav.commons.base.data.BaseTrade;
import org.springframework.data.repository.CrudRepository;

public interface BaseTradeRepo<T extends BaseTrade, ID>
        extends CrudRepository<T, ID> {
}
