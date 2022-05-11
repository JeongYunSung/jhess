package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.module.Direction;
import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.strategy.CompositeMoveStrategy;
import com.yunseong.jhess.repository.domain.piece.strategy.DirectionMoveStrategy;
import com.yunseong.jhess.repository.domain.piece.strategy.LengthMoveStrategy;
import com.yunseong.jhess.repository.domain.piece.strategy.MoveStrategy;

import java.util.Arrays;

public class Knight extends Piece {

    private final Direction[] directions = new Direction[] {
            Direction.LEFT_LEFT_UP, Direction.RIGHT_RIGHT_UP,
            Direction.LEFT_LEFT_DOWN, Direction.RIGHT_RIGHT_DOWN,
            Direction.UP_UP_RIGHT, Direction.DOWN_DOWN_RIGHT,
            Direction.UP_UP_LEFT, Direction.DOWN_DOWN_LEFT,
    };

    public Knight(Position position) {
        super("나이트", position);
    }

    @Override
    protected MoveStrategy moveStrategies(Position position) {
        return new CompositeMoveStrategy(Arrays.asList(
                new DirectionMoveStrategy(this.directions, super.getPosition(), position),
                new LengthMoveStrategy(2, super.getPosition(), position)));
    }
}
