package com.marketav.commons.base.repo;

import com.marketav.commons.base.data.BaseMarketplaceWatchlist2;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BaseMarketplaceWatchlist2Repo<T extends BaseMarketplaceWatchlist2<ID>, ID>
        extends CrudRepository<T, ID> {

    Optional<T> findByMarketId(int marketId);

    List<T> findAllByMarketId(int marketId);
}
