package com.unknown.commons.base.data;

import com.unknown.commons.implemented.Asset;

public interface BaseSymbol<ID> {
    Asset getSymbol_Type();

    void setSymbol_Type(Asset Symbol_Type);

    String getSymbol_Rating();

    void setSymbol_Rating(String Symbol_Rating);

    String getSymbol_Sign();

    void setSymbol_Sign(String Symbol_Sign);

}
