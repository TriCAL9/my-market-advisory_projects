package com.unknown.commons.base.data;

import com.unknown.commons.implemented.Asset;

public interface BaseMarket<T extends BaseMember<Integer>, ID> {
    ID getMarket_Transaction_Date();

    void setMarket_Transaction_Date(ID Market_Transaction_Date);

    String getMarket_Portfolio_Name();

    void setMarket_Portfolio_Name(String Market_Portfolio_Name);

    String getMarket_Technical_Condition();

    void setMarket_Technical_Condition(String Market_Technical_Condition);

    Asset getMarket_Asset_Type();

    void setMarket_Asset_Type(Asset Market_Asset_Type);
}
