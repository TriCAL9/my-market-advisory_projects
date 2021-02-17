/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseMember;
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
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
@Table(name = "MEMBER")
@Entity
public class Member implements BaseMember<Integer>, Serializable {

    @Column(name = "Counterpart")
    Integer participantId;

    @NonNull
    @Column(name = "Member_First_Name")
    String memberFirstname;

    @NonNull
    @Column(name = "Member_Last_Name")
    String memberLastname;

    @Column(name = "Counterpart_Email")
    String participantEmail;

    @Id
    @NonNull
    @Column(name = "Member_Id")
    Integer memberId;

    @NonNull
    @Column(name = "Profile_Email")
    String profileEmail;

    @ManyToOne
    @JoinColumn(name = "Profile_Email", insertable = false, updatable = false)
    UserProfile1 user_profile1;

    @ManyToOne
    @JoinColumn(name = "Member_Id", updatable = false, insertable = false)
    Member member;

    @OneToMany(mappedBy = "member")
    Set<Member> memberSet;

    @OneToMany(mappedBy = "member")
    Set<Trade> tradeSet;

    @OneToMany(mappedBy = "member")
    Set<Comments> commentsMap;

    @OneToMany(mappedBy = "member")
    Set<RatingSubscription> ratingSubscriptionMap;
}
