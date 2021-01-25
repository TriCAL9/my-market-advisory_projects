package com.marketav.commons.base.data;

import java.time.LocalDate;

public interface BaseTradeId {
    String getProfileEmail();

    void setProfileEmail(String Profile_Email);

    Integer getMemberId();

    void setMemberId(Integer Member_Id);

    LocalDate getMarketTransactionDate();

    void setMarketTransactionDate(LocalDate Market_Transaction_Date);

    Integer getMarketId();

    void setMarketId(Integer Market_Id);

}
