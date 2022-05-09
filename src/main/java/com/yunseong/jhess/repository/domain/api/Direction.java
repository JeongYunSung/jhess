package com.yunseong.jhess.repository.domain.api;

import lombok.Getter;

@Getter
public enum Direction {

    UP(0, 1), DOWN(0, -1), LEFT(-1, 0), RIGHT(1, 0),
    LEFT_UP(-1, 1), LEFT_DOWN(-1, -1), RIGHT_UP(1, 1), RIGHT_DOWN(1, -1),
    LEFT_LEFT_UP(-2, 1), LEFT_LEFT_DOWN(-2, 1), RIGHT_RIGHT_UP(2, 1), RIGHT_RIGHT_DOWN(-2, 1),
    UP_UP_LEFT(-1, 2), UP_UP_RIGHT(1, 2), DOWN_DOWN_LEFT(-1, -2), DOWN_DOWN_RIGHT(1, -2),
    EMPTY(0, 0);

    private int x;
    private int y;
    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Direction getDirection(int x, int y) {
        Direction[] values = Direction.values();
        for(int i = 0; i < values.length; i++) {
            if(values[i].x == x && values[i].y == y) {
                return values[i];
            }
        }
        return Direction.EMPTY;
    }
}
