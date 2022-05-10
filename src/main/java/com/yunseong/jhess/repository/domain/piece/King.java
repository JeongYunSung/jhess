package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.module.Direction;
import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.strategy.CompositeMoveStrategy;
import com.yunseong.jhess.repository.domain.piece.strategy.DirectionMoveStrategy;
import com.yunseong.jhess.repository.domain.piece.strategy.LengthMoveStrategy;
import com.yunseong.jhess.repository.domain.piece.strategy.MoveStrategy;

import java.util.Arrays;

public class King extends Piece {

    private Direction[] directions;

    public King(Position position) {
        super(position);
        this.directions = new Direction[] {
                Direction.LEFT_UP, Direction.RIGHT_UP,
                Direction.LEFT_DOWN, Direction.RIGHT_DOWN,
                Direction.UP, Direction.RIGHT,
                Direction.DOWN, Direction.LEFT
        };
    }

    @Override
    public MoveStrategy moveStrategies(Position position) {
        return new CompositeMoveStrategy(Arrays.asList(
                new DirectionMoveStrategy(this.directions, super.getPosition(), position),
                new LengthMoveStrategy(1, super.getPosition(), position)));
    }
}
