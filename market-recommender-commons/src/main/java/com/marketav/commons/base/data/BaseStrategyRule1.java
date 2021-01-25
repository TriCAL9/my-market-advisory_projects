package com.marketav.commons.base.data;

public interface BaseStrategyRule1<ID> {
    ID getStrategyId();

    void setStrategyId(ID Strategy_Id);

    String getStrategyResearcher();

    void setStrategyResearcher(String Strategy_Researcher);

    String getStrategySummary();

    void setStrategySummary(String Strategy_Summary);

    String getStrategySourceUrl();

    void setStrategySourceUrl(String Strategy_Source_URL);
}
