/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseSymbol;
import com.marketav.jdbc.scaffold.model.id.SymbolNonEmbeddedId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author CalAF
 */
@Data
@IdClass(value = SymbolNonEmbeddedId.class)
@Access(AccessType.FIELD)
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
@Table(name = "SYMBOL")
@Entity
public class Symbol implements BaseSymbol<Character>, Serializable {
    @Id
    @NonNull
    @Column(name = "Symbol_Sign")
    Character symbolSign;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "Symbol_Type")
    Asset symbolType;

    @NonNull
    @Column(name = "Symbol_Rating")
    String symbolRating;

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
    @Column(name = "Market_Id")
    Integer marketId;

    @Id
    @NonNull
    @Column(name = "Market_Transaction_Date")
    LocalDate marketTransactionDate;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Market_Id", updatable = false, insertable = false, referencedColumnName = "Market_Id"),
            @JoinColumn(name = "Market_Transaction_Date", updatable = false, insertable = false, referencedColumnName = "Market_Transaction_Date"),
            @JoinColumn(name = "Member_Id", updatable = false, insertable = false, referencedColumnName = "Member_Id"),
            @JoinColumn(name = "Profile_Email", updatable = false, insertable = false, referencedColumnName = "Profile_Email")
    })
    Trade trade;
}
