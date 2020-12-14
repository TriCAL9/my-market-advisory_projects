package com.unknown.commons.implemented;

import com.unknown.commons.base.properties.BaseAsset;
import com.unknown.commons.properties.AssetType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Asset implements BaseAsset {
    Enum<AssetType> asset;
}
