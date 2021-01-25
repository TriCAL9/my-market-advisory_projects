package com.marketav.commons.base.data;

import java.time.LocalDate;

public interface BaseMarketplaceWatchlist1 {
    LocalDate getMarketTransactionDate();

    void setMarketTransactionDate(LocalDate Market_Transaction_Date);

    Integer getMarketId();

    void setMarketId(Integer Market_Id);

    Asset getMarketAssetType();

    void setMarketAssetType(Asset Market_Asset_Type);

    enum Asset {
        STOCK, EFT
    }
}
