package com.unknown.commons.base.data;

import java.sql.Date;

public interface BaseTradeReceipt<T extends BaseMarket<BaseMember<Integer>, ID>, ID> {
    String getTrade_Owner();

    void setTrade_Owner(String Trade_Owner);

    String getTrade_Price();

    void setTrade_Price(String Trade_Price);

    String getTrade_Type();

    void setTrade_Type(String Trade_Type);

    Date getTrade_Opening_Date();

    void setTrade_Opening_Date(Date Trade_Opening_Date);

    Date getTrade_Closing_Date();

    void setTrade_Closing_Date(Date Trade_Closing_Date);

    String getTrade_Strategy_Name();

    void setTrade_Strategy_Name(String Trade_Strategy_Name);

    String getTrade_Transaction_Symbol();

    void setTrade_Transaction_Symbol(String Trade_Transaction_Symbol);
}
