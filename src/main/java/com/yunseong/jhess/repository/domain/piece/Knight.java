package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.api.Direction;
import com.yunseong.jhess.repository.domain.api.Position;

public class Knight extends Piece {

    public Knight(Position position) {
        super(2, position);
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public Direction[] canDirection() {
        return new Direction[] {
                Direction.LEFT_LEFT_UP, Direction.RIGHT_RIGHT_UP,
                Direction.LEFT_LEFT_DOWN, Direction.RIGHT_RIGHT_DOWN,
                Direction.UP_UP_RIGHT, Direction.DOWN_DOWN_RIGHT,
                Direction.UP_UP_LEFT, Direction.DOWN_DOWN_LEFT,
        };
    }
}
