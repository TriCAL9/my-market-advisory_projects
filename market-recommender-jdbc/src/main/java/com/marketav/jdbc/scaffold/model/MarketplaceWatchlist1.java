/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseMarketplaceWatchlist1;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

/**
 * @author CalAF
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Table
public class MarketplaceWatchlist1 implements BaseMarketplaceWatchlist1 {
    @Id
    @NonNull
    @Column("Market_Transaction_Date")
    LocalDate marketTransactionDate;
    @NonNull
    @Column("Market_Id")
    Integer marketId;
    @NonNull
    @Column("Market_Asset_Type")
    BaseMarketplaceWatchlist1.Asset marketAssetType;

}
