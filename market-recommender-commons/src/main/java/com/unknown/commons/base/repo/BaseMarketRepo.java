package com.unknown.commons.base.repo;

import com.unknown.commons.base.data.BaseMarket;
import com.unknown.commons.base.data.BaseMember;
import com.unknown.commons.properties.AssetType;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface BaseMarketRepo<T extends BaseMarket<BaseMember<Integer>, ID>, ID extends Serializable>
        extends CrudRepository<T, ID> {

    List<T> readDistinctMarketByMarket_Asset_Type(AssetType assetType);

}
