package com.unknown.commons.base.data;


public interface BaseProfile<ID> {
    ID getProfile_Email();

    void setProfile_Email(ID Profile_Email);

    String getProfile_Name();

    void setProfile_Name(String Profile_Name);

    String getProfile_Password();

    void setProfile_Password(String Profile_Password);
}
