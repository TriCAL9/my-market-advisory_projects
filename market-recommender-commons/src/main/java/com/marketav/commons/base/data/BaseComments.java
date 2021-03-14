package com.marketav.commons.base.data;

public interface BaseComments<ID> {
    ID getMemberComments();

    void setMemberComments(ID Member_Comments);

    Integer getMemberId();

    void setMemberId(Integer Member_Id);

    ID getProfileEmail();

    void setProfileEmail(ID Profile_Email);
}
