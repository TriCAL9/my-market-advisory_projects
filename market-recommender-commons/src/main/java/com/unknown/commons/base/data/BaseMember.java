package com.unknown.commons.base.data;

import com.unknown.commons.implemented.Email;

public interface BaseMember<ID> {

    Email getMember_id();

    void setMember_id(Email Member_id);

    String getMember_First_Name();

    void setMember_First_Name(String Member_First_Name);

    String getMember_Last_Name();

    void setMember_Last_Name(String Member_Last_Name);

    String getMember_Recomm_Sub_Name();

    void setMember_Recomm_Sub_Name(String Member_Recomm_Sub_Name);
}