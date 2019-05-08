package com.nn.study.entities;

import java.io.Serializable;

public enum SeasonEnum implements Serializable {

    SPRING("spring @_@"),
    SUMMER("summer @_@"),
    AUTUMN("autumn @_@"),
    WINTER("winter @_@");

    private String seasonName;

    SeasonEnum(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }
}
