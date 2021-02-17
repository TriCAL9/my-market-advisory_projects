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
@Table(name = "STRATEGY_RULE1")
@Entity
public class StrategyRule1 implements BaseStrategyRule1<Integer>, Serializable {

    @Id
    @NonNull
    @Column(name = "Strategy_Id")
    Integer strategyId;
    @NonNull
    @Column(name = "Strategy_Researcher")
    String strategyResearcher;
    @NonNull
    @Column(name = "Strategy_Summary")
    String strategySummary;
    @NonNull
    @Column(name = "Strategy_Source_URL")
    String strategySourceUrl;
    @NonNull
    @Column(name = "Member_Rating_Sub")
    String memberRatingSub;
    @NonNull
    @Column(name = "Profile_Email")
    String profileEmail;
    @NonNull
    @Column(name = "Member_Id")
    Integer memberId;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Member_Rating_Sub", updatable = false, insertable = false, referencedColumnName = "Member_Rating_Sub"),
            @JoinColumn(name = "Member_Id", updatable = false, insertable = false, referencedColumnName = "Member_Id"),
            @JoinColumn(name = "Profile_Email", updatable = false, insertable = false, referencedColumnName = "Profile_Email")
    })
    RatingSubscription rating_subscription;
    @OneToMany(mappedBy = "strategy_rule1")
    Set<StrategyRule2> strategyRule2Map;
}
