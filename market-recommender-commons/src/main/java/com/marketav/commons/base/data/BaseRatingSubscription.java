package com.marketav.commons.base.data;

public interface BaseRatingSubscription<ID> {
    ID getMemberRatingSubscription();

    void setMemberRatingSubscription(ID Member_Rating_Subscription);

    ID getProfileEmail();

    void setProfileEmail(ID Profile_Email);

    Integer getMemberId();

    void setMemberId(Integer Member_Id);
}
