package com.marketav.commons.base.data;

import java.math.BigDecimal;

public interface BaseStrategyRule2<ID> {
    ID getRnumber();

    void setRnumber(ID Rnumber);

    String getTechnicalIndicator();

    void setTechnicalIndicator(String Technical_Indicator);

    BigDecimal getTarget();

    void setTarget(BigDecimal Target);

    String getStage();

    void setStage(String Stage);
}
