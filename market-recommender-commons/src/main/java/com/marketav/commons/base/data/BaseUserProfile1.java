package com.marketav.commons.base.data;


public interface BaseUserProfile1<ID> {
    ID getProfileEmail();

    void setProfileEmail(ID Profile_Email);

    String getProfileName();

    void setProfileName(String Profile_Name);

    String getProfilePassword();

    void setProfilePassword(String Profile_Password);
}
