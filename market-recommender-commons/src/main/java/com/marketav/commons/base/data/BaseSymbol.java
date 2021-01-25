package com.marketav.commons.base.data;


import java.time.LocalDate;

public interface BaseSymbol<ID> {
    ID getSymbolSign();

    void setSymbolSign(ID Symbol_Sign);

    Asset getSymbolType();

    void setSymbolType(Asset Symbol_Type);

    String getSymbolRating();

    void setSymbolRating(String Symbol_Rating);

    String getProfileEmail();

    void setProfileEmail(String Profile_Email);

    Integer getMemberId();

    void setMemberId(Integer Member_Id);

    Integer getMarketId();

    void setMarketId(Integer Market_Id);

    LocalDate getMarketTransactionDate();

    void setMarketTransactionDate(LocalDate Market_Transaction_Date);

    enum Asset {
        STOCK, EFT
    }
}
