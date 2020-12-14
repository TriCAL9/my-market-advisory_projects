package com.unknown.commons.base.properties;

import com.unknown.commons.properties.AssetType;

public interface BaseAsset {
    Enum<AssetType> getAsset();

    void setAsset(Enum<AssetType> asset);
}
