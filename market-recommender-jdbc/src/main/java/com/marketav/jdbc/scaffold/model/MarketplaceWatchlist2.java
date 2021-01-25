/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseMarketplaceWatchlist2;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Map;

/**
 * @author CalAF
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Table
public class MarketplaceWatchlist2 implements BaseMarketplaceWatchlist2<Integer> {
    @Id
    @NonNull
    Integer marketId;

    @NonNull
    String marketPortfolioName;

    @MappedCollection(keyColumn = "Market_Transaction_Date")
    Map<Integer, MarketplaceWatchlist1> marketplaceWatchlist1Set;

}
