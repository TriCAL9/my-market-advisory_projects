package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseRatingSubscription;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Map;

@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Table("Rating_Subscription")
public class RatingSubscription implements BaseRatingSubscription<String, Integer> {
    @Id
    @NonNull
    @Column("Member_Rating_Subscription")
    String memberRatingSubscription;

    @NonNull
    @Column("Profile_Email")
    String profileEmail;

    @NonNull
    Integer memberId;

    @MappedCollection(keyColumn = "Strategy_Id")
    Map<String, StrategyRule1> stringStrategyRule1Map;
}
