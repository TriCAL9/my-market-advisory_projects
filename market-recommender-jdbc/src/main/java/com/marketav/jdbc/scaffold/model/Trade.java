/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marketav.commons.base.data.BaseTrade;
import com.marketav.jdbc.scaffold.model.id.TradeNonEmbeddedId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author CalAF
 */
@IdClass(TradeNonEmbeddedId.class)
@Data
@Access(AccessType.FIELD)
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
@Table(name = "TRADE")
@Entity
public class Trade implements BaseTrade, Serializable {
    @Id
    @NonNull
    @Column(name = "Profile_Email")
    String profileEmail;
    @Id
    @NonNull
    @Column(name = "Member_Id")
    Integer memberId;
    @Id
    @NonNull
    @Column(name = "Market_Transaction_Date")
    LocalDate marketTransactionDate;
    @Id
    @NonNull
    @Column(name = "Market_Id")
    Integer marketId;

    @NonNull
    @Column(name = "Trade_Price")
    BigDecimal tradePrice;

    @NonNull
    @Column(name = "Trade_Closing_Date")
    LocalDate tradeClosingDate;

    @NonNull
    @Column(name = "Trade_Type")
    String tradeType;

    @NonNull
    @Column(name = "Trade_Opening_Date")
    LocalDate tradeOpeningDate;

    @NonNull
    @Column(name = "Member_First_Name")
    String memberFirstName;

    @NonNull
    @Column(name = "Member_Last_Name")
    String memberLastName;

    @OneToMany(mappedBy = "trade")
    @JsonIgnore
    Set<Symbol> symbolSet;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Member_Id", updatable = false, insertable = false, referencedColumnName = "Member_Id"),
            @JoinColumn(name = "Profile_Email", updatable = false, insertable = false, referencedColumnName = "Profile_Email")
    })
    Member member;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Market_Transaction_Date", updatable = false, insertable = false, referencedColumnName = "Market_Transaction_Date"),
            @JoinColumn(name = "Market_Id", updatable = false, insertable = false, referencedColumnName = "Market_Id")
    })
    MarketplaceWatchlist1 marketplace_watchlist1;

}
