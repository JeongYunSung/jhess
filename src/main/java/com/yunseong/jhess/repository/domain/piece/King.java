package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.module.Direction;
import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.strategy.*;

import java.util.Arrays;

public class King extends Piece {

    private final Direction[] directions = new Direction[] {
            Direction.LEFT_UP, Direction.RIGHT_UP,
            Direction.LEFT_DOWN, Direction.RIGHT_DOWN,
            Direction.UP, Direction.RIGHT,
            Direction.DOWN, Direction.LEFT
    };

    public King(Position position) {
        super("킹", position);
    }

    @Override
    protected MoveStrategy moveStrategies(Position position) {
        return new CompositeMoveStrategy(Arrays.asList(
                new DirectionMoveStrategy(this.directions, super.getPosition(), position),
                new DistanceMoveStrategy(new Position(1, 1), super.getPosition(), position)));
    }
}
