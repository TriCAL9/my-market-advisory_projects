package com.marketav.commons.base.data;

public interface BaseRatingSubscription<ID, FK> {
    ID getMemberRatingSubscription();

    void setMemberRatingSubscription(ID Member_Rating_Subscription);

    ID getProfileEmail();

    void setProfileEmail(ID Profile_Email);

    FK getMemberId();

    void setMemberId(FK Member_Id);
}
