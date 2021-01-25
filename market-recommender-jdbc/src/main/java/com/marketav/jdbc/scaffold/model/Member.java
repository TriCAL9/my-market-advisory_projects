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
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Map;
import java.util.Set;

/**
 * @author CalAF
 */
@Data
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
@Table("Member")
public class Member implements BaseMember<Integer> {

    @Column("Counterpart")
    Integer participantId;

    @NonNull
    @Column("Member_First_Name")
    String memberFirstname;

    @NonNull
    @Column("Member_Last_Name")
    String memberLastname;

    @Column("Counterpart_Email")
    String participantEmail;

    @Id
    @NonNull
    @Column("Member_Id")
    Integer memberId;

    @NonNull
    @Column("Profile_Email")
    String profileEmail;


    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    Set<Member> memberSet;

    Set<Trade> tradeSet;

    @MappedCollection(keyColumn = "Member_Comments")
    Map<String, Comments> commentsMap;

    @MappedCollection(keyColumn = "Member_Rating_Sub")
    Map<String, RatingSubscription> ratingSubscriptionMap;
}
