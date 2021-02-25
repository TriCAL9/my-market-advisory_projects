/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marketav.commons.base.data.BaseMember;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
@EqualsAndHashCode(exclude = {"ratingSubscriptionSet", "commentsSet", "tradeSet", "memberSet"})
@ToString(exclude = {"ratingSubscriptionSet", "commentsSet", "tradeSet", "memberSet"})
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
    @JoinColumn(name = "Profile_Email", updatable = false, insertable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    UserProfile1 user_profile1;

    @ManyToOne
    @JoinColumn(name = "Counterpart", updatable = false, insertable = false)
    @JsonBackReference
    Member counterpart;

    @OneToMany(mappedBy = "counterpart", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    Set<Member> counterpartSet;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    Set<Trade> tradeSet;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    Set<Comments> commentsSet;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    Set<RatingSubscription> ratingSubscriptionSet;
}
