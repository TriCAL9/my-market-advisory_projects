package com.unknown.commons.base.data;

public interface BaseTradeReceipt<ID> {
    String getTrade_Owner();

    void setTrade_Owner(String Trade_Owner);

    String getTrade_Price();

    void setTrade_Price(String Trade_Price);

    String getTrade_Type();

    void setTrade_Type(String Trade_Type);

    String getTrade_Opening_Date();

    void setTrade_Opening_Date(String Trade_Opening_Date);

    String getTrade_Closing_Date();

    void setTrade_Closing_Date(String Trade_Closing_Date);

    String getTrade_Strategy_Name();

    void setTrade_Strategy_Name(String Trade_Strategy_Name);

    String getTrade_Transaction_Symbol();

    void setTrade_Transaction_Symbol(String Trade_Transaction_Symbol);
}
