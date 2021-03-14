/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.marketav.commons.base.data.BaseMember;
import com.marketav.commons.implemented.id.MemberNonEmbeddedId;
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
@EqualsAndHashCode(exclude = {"ratingSubscriptionSet", "commentsSet", "tradeSet", "counterpartSet"})
@ToString(exclude = {"ratingSubscriptionSet", "commentsSet", "tradeSet", "counterpartSet"})
@Table(name = "MEMBER")
@IdClass(MemberNonEmbeddedId.class)
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

    @Id
    @NonNull
    @Column(name = "Profile_Email")
    String profileEmail;

    @ManyToOne
    @JoinColumn(name = "Profile_Email", updatable = false, insertable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    UserProfile1 userProfile1;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Counterpart", updatable = false, insertable = false),
            @JoinColumn(name = "Counterpart_Email", updatable = false, insertable = false)
    })
    @JsonBackReference
    Member counterpart;

    @OneToMany(mappedBy = "counterpart", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Member> counterpartSet;

    @OneToMany(mappedBy = "member")
    Set<Trade> tradeSet;

    @OneToMany(mappedBy = "member")
    Set<Comments> commentsSet;

    @OneToMany(mappedBy = "member")
    Set<RatingSubscription> ratingSubscriptionSet;
}
