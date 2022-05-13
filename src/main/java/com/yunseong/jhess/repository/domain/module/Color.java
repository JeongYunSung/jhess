package com.yunseong.jhess.repository.domain.module;

import lombok.Getter;

@Getter
public enum Color {

    BLACK(1), WHITE(-1);

    private final int multiple;

    Color(int multiple) {
        this.multiple = multiple;
    }

    public static Color valueOf(int color) {
        switch (color) {
            case 1:
                return Color.BLACK;
            default:
                return Color.WHITE;
        }
    }
}
