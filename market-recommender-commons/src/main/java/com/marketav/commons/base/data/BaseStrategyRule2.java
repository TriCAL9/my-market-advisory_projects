package com.marketav.commons.base.data;

public interface BaseStrategyRule2<ID> {
    ID getRnumber();

    void setRnumber(ID Rnumber);

    String getTechnicalIndicator();

    void setTechnicalIndicator(String Technical_Indicator);

    Double getTarget();

    void setTarget(Double Target);

    String getStage();

    void setStage(String Stage);
}
