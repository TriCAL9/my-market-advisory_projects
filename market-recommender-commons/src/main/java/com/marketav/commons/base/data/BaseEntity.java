package com.marketav.commons.base.data;

public interface BaseEntity<ID> {
    ID getId();

    void setId(ID id);
}
