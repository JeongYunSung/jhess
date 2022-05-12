package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.game.Board;
import com.yunseong.jhess.repository.domain.module.Direction;
import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.strategy.*;

import java.util.Arrays;

public class Rook extends Piece {

    private final Direction[] directions = new Direction[] {
            Direction.UP, Direction.RIGHT,
            Direction.DOWN, Direction.LEFT
    };

    public Rook(Board board, Position position) {
        super("룩", board, position);
    }

    @Override
    protected MoveStrategy moveStrategies(Position position) {
        return new CompositeMoveStrategy(Arrays.asList(
                new WallNotMoveStrategy(super.getBoard(), position),
                new DirectionMoveStrategy(this.directions, super.getPosition(), position),
                new DistanceMoveStrategy(new Position(8, 8), super.getPosition(), position),
                new DontJumpStrategy(super.getBoard(), super.getPosition(), position)));
    }
}
