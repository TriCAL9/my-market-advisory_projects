package com.unknown.commons.base.repo;

import com.unknown.commons.base.data.BaseMarket;
import com.unknown.commons.base.data.BaseMember;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface BaseTradeReceiptRepo<T extends BaseMarket<BaseMember<Integer>, ID>, ID extends Serializable>
        extends CrudRepository<T, ID> {
}
