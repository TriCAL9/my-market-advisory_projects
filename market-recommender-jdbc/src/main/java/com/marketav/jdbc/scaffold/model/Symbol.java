/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseSymbol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

/**
 * @author CalAF
 */
@Data
@AllArgsConstructor(staticName = "of")
@Table
public class Symbol implements BaseSymbol<String> {
    @Id
    @NonNull
    @Column("Symbol_Sign")
    String symbolSign;

    @NonNull
    @Column("Symbol_Type")
    Asset symbolType;

    @NonNull
    @Column("Symbol_Rating")
    String symbolRating;

    @NonNull
    @Column("Profile_Email")
    String profileEmail;

    @NonNull
    @Column("Member_Id")
    Integer memberId;

    @NonNull
    @Column("Market_Id")
    Integer marketId;

    @NonNull
    @Column("Market_Transaction_Date")
    LocalDate marketTransactionDate;

}
