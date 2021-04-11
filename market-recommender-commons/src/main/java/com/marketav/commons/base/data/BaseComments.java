package com.marketav.commons.base.data;

public interface BaseComments<ID> {
    ID getMemberComments();

    void setMemberComments(ID Member_Comments);

    Integer getMemberId();

    void setMemberId(Integer Member_Id);

    String getProfileEmail();

    void setProfileEmail(String Profile_Email);
}
