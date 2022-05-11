package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.module.Direction;
import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.strategy.*;

import java.util.Arrays;

public class Bishop extends Piece {

    private final Direction[] directions = new Direction[] {
            Direction.LEFT_UP, Direction.RIGHT_UP,
            Direction.LEFT_DOWN, Direction.RIGHT_DOWN
    };

    public Bishop(Position position) {
        super("비숍", position);
    }

    @Override
    protected MoveStrategy moveStrategies(Position position) {
        return new CompositeMoveStrategy(Arrays.asList(
                new DirectionMoveStrategy(this.directions, super.getPosition(), position),
                new DistanceMoveStrategy(new Position(8, 8), super.getPosition(), position)));
    }
}
