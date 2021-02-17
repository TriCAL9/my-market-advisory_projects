package com.marketav.commons.base.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface BaseTrade {
    String getProfileEmail();

    void setProfileEmail(String Profile_Email);

    Integer getMemberId();

    void setMemberId(Integer Member_Id);

    LocalDate getMarketTransactionDate();

    void setMarketTransactionDate(LocalDate Market_Transaction_Date);

    Integer getMarketId();

    void setMarketId(Integer Market_Id);

    BigDecimal getTradePrice();

    void setTradePrice(BigDecimal Trade_Price);

    LocalDate getTradeClosingDate();

    void setTradeClosingDate(LocalDate Trade_Closing_Date);

    String getTradeType();

    void setTradeType(String Trade_Type);

    LocalDate getTradeOpeningDate();

    void setTradeOpeningDate(LocalDate Trade_Opening_Date);

    String getMemberFirstName();

    void setMemberFirstName(String Member_First_Name);

    String getMemberLastName();

    void setMemberLastName(String Member_Last_Name);
}
