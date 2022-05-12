package com.yunseong.jhess.repository.domain.module;

import lombok.Getter;

@Getter
public enum Color {

    BLACK(1), WHITE(-1);

    private int multiple;

    Color(int multiple) {
        this.multiple = multiple;
    }
}
