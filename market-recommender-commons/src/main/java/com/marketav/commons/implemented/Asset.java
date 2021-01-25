package com.marketav.commons.implemented;

import com.marketav.commons.base.data.BaseSymbol;
import com.marketav.commons.base.properties.BaseAsset;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Asset implements BaseAsset {
    Enum<BaseSymbol.Asset> asset;
}
