/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marketav.commons.base.data.BaseMarketplaceWatchlist1;
import com.marketav.commons.implemented.id.MarketplaceWatchlist1NonEmbeddedId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author CalAF
 */
@IdClass(MarketplaceWatchlist1NonEmbeddedId.class)
@Data
@Access(AccessType.FIELD)
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Table(name = "MARKETPLACE_WATCHLIST1")
@Entity
@EqualsAndHashCode(exclude = "tradeSet")
public class MarketplaceWatchlist1 implements BaseMarketplaceWatchlist1, Serializable {
    @Id
    @NonNull
    @Column(name = "Market_Transaction_Date")
    LocalDate marketTransactionDate;
    @Id
    @NonNull
    @Column(name = "Market_Id")
    Integer marketId;
    @NonNull
    @Column(name = "Market_Asset_Type")
    @Enumerated(EnumType.STRING)
    BaseMarketplaceWatchlist1.Asset marketAssetType;
    @OneToMany(mappedBy = "marketplace_watchlist1")
    @JsonIgnore
    Set<Trade> tradeSet;
    @ManyToOne
    @JoinColumn(name = "Market_Id", insertable = false, updatable = false)
    MarketplaceWatchlist2 marketplace_watchlist2;
}
