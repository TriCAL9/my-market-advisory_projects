package com.unknown.commons.base.repo;

import com.unknown.commons.base.data.BaseTradeReceipt;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface BaseTradeReceiptRepo<T extends BaseTradeReceipt<ID>, ID extends Serializable> extends CrudRepository<T, ID> {
}
