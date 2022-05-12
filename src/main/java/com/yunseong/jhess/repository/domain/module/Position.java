package com.yunseong.jhess.repository.domain.module;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class Position {

    private final int x;
    private final int y;

    public Position setX(int x) {
        return new Position(x, this.y);
    }

    public Position setY(int y) {
        return new Position(this.x, y);
    }

    public Position setLocation(int x, int y) {
        return new Position(this.x, this.y);
    }
}
