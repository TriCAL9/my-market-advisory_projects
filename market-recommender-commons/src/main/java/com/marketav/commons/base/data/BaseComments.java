package com.marketav.commons.base.data;

public interface BaseComments<ID, FK> {
    ID getMemberComments();

    void setMemberComments(ID Member_Comments);

    FK getMemberId();

    void setMemberId(FK Member_Id);

    String getProfileEmail();

    void setProfileEmail(String Profile_Email);
}
