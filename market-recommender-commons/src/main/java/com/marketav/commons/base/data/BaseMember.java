package com.marketav.commons.base.data;

public interface BaseMember<ID> {
    ID getMemberId();

    void setMemberId(ID Member_id);

    String getProfileEmail();

    void setProfileEmail(String Profile_Email);

    Integer getParticipantId();

    void setParticipantId(Integer Participant_Id);

    String getParticipantEmail();

    void setParticipantEmail(String participantEmail);

    String getMemberFirstname();

    void setMemberFirstname(String Member_First_Name);

    String getMemberLastname();

    void setMemberLastname(String Member_Last_Name);
}
