/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseTrade;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Map;

/**
 * @author CalAF
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
@Table
public class Trade implements BaseTrade {

    @NonNull
    @Column("Profile_Email")
    String profileEmail;

    @NonNull
    @Column("Member_Id")
    Integer memberId;

    @NonNull
    @Column("Market_Transaction_Date")
    LocalDate marketTransactionDate;

    @NonNull
    @Column("Market_Id")
    Integer marketId;

    @NonNull
    @Column("Trade_Price")
    Double tradePrice;

    @NonNull
    @Column("Trade_Closing_Date")
    LocalDate tradeClosingDate;

    @NonNull
    @Column("Trade_Type")
    String tradeType;

    @NonNull
    @Column("Trade_Opening_Date")
    LocalDate tradeOpeningDate;

    @NonNull
    @Column("Member_First_Name")
    String memberFirstName;

    @NonNull
    @Column("Member_Last_Name")
    String memberLastName;

    @MappedCollection(keyColumn = "Symbol_Sign")
    Map<String, Symbol> symbolMap;
}
