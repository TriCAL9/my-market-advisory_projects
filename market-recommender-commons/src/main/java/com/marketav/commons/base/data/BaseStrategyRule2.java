package com.marketav.commons.base.data;

public interface BaseStrategyRule2<ID> {
    ID getRnumber();

    void setRnumber(ID Rnumber);

    String getTechnicalIndicator();

    void setTechnicalIndicator(String Technical_Indicator);

    Integer getTarget();

    void setTarget(Integer Target);

    String getStage();

    void setStage(String Stage);
}
