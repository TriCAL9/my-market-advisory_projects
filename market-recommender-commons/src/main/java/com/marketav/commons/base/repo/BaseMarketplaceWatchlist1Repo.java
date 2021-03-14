package com.marketav.commons.base.repo;

import com.marketav.commons.base.data.BaseMarketplaceWatchlist1;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BaseMarketplaceWatchlist1Repo<T extends BaseMarketplaceWatchlist1, ID>
        extends CrudRepository<T, ID> {
    @Query("SELECT W.*, M.Market_Portfolio_Name FROM (marketplace_watchlist2 W"
            + " JOIN marketplace_watchlist1 M)"
            + "WHERE W.Market_Id = :marketId")
    List<T> getAllByMarketId(@Param("marketId") int marketID);
}
