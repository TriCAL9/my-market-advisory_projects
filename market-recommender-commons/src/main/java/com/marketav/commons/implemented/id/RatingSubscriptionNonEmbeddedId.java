package com.marketav.commons.implemented.id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingSubscriptionNonEmbeddedId implements Serializable {
    String memberRatingSubscription;
    String profileEmail;
    Integer memberId;
}
