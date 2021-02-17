package com.marketav.commons.base.data;

import java.time.LocalDate;

public interface BaseMarketplaceWatchlist1 {
    LocalDate getMarketTransactionDate();

    void setMarketTransactionDate(LocalDate Market_Transaction_Date);

    Integer getMarketId();

    void setMarketId(Integer Market_Id);

    BaseMarketplaceWatchlist1.Asset getMarketAssetType();

    void setMarketAssetType(BaseMarketplaceWatchlist1.Asset Market_Asset_Type);

    enum Asset {
        STOCK, EFT
    }
}
