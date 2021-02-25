/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marketav.commons.base.data.BaseMarketplaceWatchlist2;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author CalAF
 */

@Data
@Access(AccessType.FIELD)
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Table(name = "MARKETPLACE_WATCHLIST2")
@Entity
@EqualsAndHashCode(exclude = "marketplaceWatchlist1Set")
public class MarketplaceWatchlist2 implements BaseMarketplaceWatchlist2<Integer>, Serializable {

    @Id
    @NonNull
    @Column(name = "Market_Id")
    Integer marketId;

    @NonNull
    @Column(name = "Market_Portfolio_Name")
    String marketPortfolioName;

    @OneToMany(mappedBy = "marketplace_watchlist2")
    @JsonIgnore
    Set<MarketplaceWatchlist1> marketplaceWatchlist1Set;
}
