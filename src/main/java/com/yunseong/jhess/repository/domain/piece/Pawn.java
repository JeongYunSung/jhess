package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.api.Direction;
import com.yunseong.jhess.repository.domain.api.Position;

public class Pawn extends Piece {

    public Pawn(Position position) {
        super(2, position);
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public Direction[] canDirection() {
        return new Direction[] {
                Direction.UP, Direction.RIGHT_UP, Direction.LEFT_UP
        };
    }
}
