package com.yunseong.jhess.domain.common;

import lombok.Getter;

@Getter
public enum TeamColor {

    NONE(0), BLACK(1), WHITE(-1);

    private final int multiple;

    TeamColor(int multiple) {
        this.multiple = multiple;
    }

    public static TeamColor valueOf(int color) {
        switch (color) {
            case 1:
                return TeamColor.BLACK;
            default:
                return TeamColor.WHITE;
        }
    }
}
