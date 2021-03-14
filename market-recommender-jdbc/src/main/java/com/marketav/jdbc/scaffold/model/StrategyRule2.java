/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseStrategyRule2;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author CalAF
 */
@Data
@Access(AccessType.FIELD)
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
@Table(name = "STRATEGY_RULE2")
@Entity
public class StrategyRule2 implements BaseStrategyRule2<Integer>, Serializable {

    @Id
    @NonNull
    @Column(name = "Rnumber")
    Integer rnumber;

    @NonNull
    @Column(name = "Technical_Indicator")
    String technicalIndicator;

    @NonNull
    @Column(name = "Stage")
    String stage;

    @Column(name = "Target")
    BigDecimal target;

    @NonNull
    @Column(name = "Strategy_Id")
    Integer strategyId;

    @ManyToOne
    @JoinColumn(name = "Strategy_Id", updatable = false, insertable = false)
    StrategyRule1 strategy_rule1;

}
