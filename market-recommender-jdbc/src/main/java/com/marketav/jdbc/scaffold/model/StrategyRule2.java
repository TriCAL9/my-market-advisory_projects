/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseStrategyRule2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author CalAF
 */
@Data
@AllArgsConstructor(staticName = "of")
@Table("Strategy_Rule2")
public class StrategyRule2 implements BaseStrategyRule2<Integer> {
    @Id
    @NonNull
    @Column("Rnumber")
    Integer rnumber;
    @NonNull
    @Column("Technical_Indicator")
    String technicalIndicator;
    @NonNull
    @Column("Stage")
    String stage;
    @NonNull
    @Column("Target")
    Integer target;
    @NonNull
    @Column("Strategy_Id")
    Integer strategyId;
}
