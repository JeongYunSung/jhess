package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.api.Direction;
import com.yunseong.jhess.repository.domain.api.Position;

public class Bishop extends Piece {

    public Bishop(Position position) {
        super(8, position);
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public Direction[] canDirection() {
        return new Direction[] {
                Direction.LEFT_UP, Direction.RIGHT_UP,
                Direction.LEFT_DOWN, Direction.RIGHT_DOWN
        };
    }
}
