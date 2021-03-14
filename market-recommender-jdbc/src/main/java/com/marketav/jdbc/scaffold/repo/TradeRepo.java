package com.marketav.jdbc.scaffold.repo;

import com.marketav.commons.base.repo.BaseTradeRepo;
import com.marketav.commons.implemented.id.TradeNonEmbeddedId;
import com.marketav.jdbc.scaffold.model.Trade;

public interface TradeRepo extends BaseTradeRepo<Trade, TradeNonEmbeddedId> {
}
