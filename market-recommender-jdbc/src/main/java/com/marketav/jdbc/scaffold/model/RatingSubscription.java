package com.marketav.jdbc.scaffold.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marketav.commons.base.data.BaseRatingSubscription;
import com.marketav.commons.implemented.id.RatingSubscriptionNonEmbeddedId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Access(AccessType.FIELD)
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Table(name = "RATING_SUBSCRIPTION")
@IdClass(RatingSubscriptionNonEmbeddedId.class)
@EqualsAndHashCode(exclude = {"strategyRule1"})
@Entity
public class RatingSubscription implements BaseRatingSubscription<String>, Serializable {

    @Id
    @NonNull
    @Column(name = "Member_Rating_Sub")
    String memberRatingSubscription;

    @Id
    @NonNull
    @Column(name = "Profile_Email", columnDefinition = "varchar(45)")
    String profileEmail;

    @Id
    @NonNull
    @Column(name = "Member_Id")
    Integer memberId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Profile_Email", updatable = false, insertable = false),
            @JoinColumn(name = "Member_Id", updatable = false, insertable = false)
    })
    Member member;

    @OneToMany(mappedBy = "rating_subscription")
    @JsonIgnore
    Set<StrategyRule1> strategyRule1;

}
