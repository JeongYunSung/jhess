package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.module.Direction;
import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.strategy.CompositeMoveStrategy;
import com.yunseong.jhess.repository.domain.piece.strategy.DirectionMoveStrategy;
import com.yunseong.jhess.repository.domain.piece.strategy.LengthMoveStrategy;
import com.yunseong.jhess.repository.domain.piece.strategy.MoveStrategy;

import java.util.Arrays;

public class Pawn extends Piece {

    private final Direction[] directions = new Direction[] {
            Direction.UP, Direction.RIGHT_UP, Direction.LEFT_UP
    };

    public Pawn(Position position) {
        super("폰", 1, position);
    }

    @Override
    public MoveStrategy moveStrategies(Position position) {
        return new CompositeMoveStrategy(Arrays.asList(
                new DirectionMoveStrategy(this.directions, super.getPosition(), position),
                new LengthMoveStrategy(super.getLength(), super.getPosition(), position)));
    }
}
