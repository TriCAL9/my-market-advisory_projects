/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseStrategyRule1;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Map;

/**
 * @author CalAF
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Table("Strategy_Rule1")
public class StrategyRule1 implements BaseStrategyRule1<Integer> {

    @Id
    @NonNull
    Integer strategyId;
    @NonNull
    String strategyResearcher;
    @NonNull
    String strategySummary;
    @NonNull
    String strategySourceUrl;
    @NonNull
    @Column("Member_Rating_Sub")
    String memberRatingSub;
    @NonNull
    @Column("Profile_Email")
    String profileEmail;
    @NonNull
    @Column("Member_Id")
    Integer memberId;
    @MappedCollection(keyColumn = "Rnumber")
    Map<Integer, StrategyRule2> strategyRule2Map;
}
