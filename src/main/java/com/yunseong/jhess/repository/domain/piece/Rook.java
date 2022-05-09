package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.api.Direction;
import com.yunseong.jhess.repository.domain.api.Position;

public class Rook extends Piece {

    public Rook(Position position) {
        super(8, position);
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public Direction[] canDirection() {
        return new Direction[] {
                Direction.UP, Direction.RIGHT,
                Direction.DOWN, Direction.LEFT
        };
    }
}
