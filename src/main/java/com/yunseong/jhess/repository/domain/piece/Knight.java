package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.game.Board;
import com.yunseong.jhess.repository.domain.module.Direction;
import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.strategy.*;

import java.util.Arrays;

public class Knight extends Piece {

    private final Direction[] directions = new Direction[] {
            Direction.LEFT_LEFT_UP, Direction.RIGHT_RIGHT_UP,
            Direction.LEFT_LEFT_DOWN, Direction.RIGHT_RIGHT_DOWN,
            Direction.UP_UP_RIGHT, Direction.DOWN_DOWN_RIGHT,
            Direction.UP_UP_LEFT, Direction.DOWN_DOWN_LEFT,
    };

    public Knight(Board board, Position position) {
        super("나이트", board, position);
    }

    @Override
    protected MoveStrategy moveStrategies(Position position) {
        return new CompositeMoveStrategy(Arrays.asList(
                new WallNotMoveStrategy(super.getBoard(), position),
                new DirectionMoveStrategy(this.directions, super.getPosition(), position),
                new LengthMoveStrategy(2, super.getPosition(), position)));
    }
}
