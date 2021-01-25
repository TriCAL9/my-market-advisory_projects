package com.marketav.commons.base.properties;

import com.marketav.commons.base.data.BaseSymbol;

public interface BaseAsset {
    Enum<BaseSymbol.Asset> getAsset();

    void setAsset(Enum<BaseSymbol.Asset> asset);
}
