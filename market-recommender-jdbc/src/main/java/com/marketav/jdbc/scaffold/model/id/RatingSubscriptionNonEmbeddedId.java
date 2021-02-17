package com.marketav.jdbc.scaffold.model.id;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class RatingSubscriptionNonEmbeddedId implements Serializable {
    String memberRatingSubscription;
    String profileEmail;
    Integer memberId;
}
