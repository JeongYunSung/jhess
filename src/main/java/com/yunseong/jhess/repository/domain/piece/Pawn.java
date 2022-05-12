package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.game.Board;
import com.yunseong.jhess.repository.domain.module.Direction;
import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.strategy.*;

import java.util.Arrays;

public class Pawn extends Piece {

    private boolean isNotFirst;
    private final Direction[] directions = new Direction[] {
            Direction.UP, Direction.RIGHT_UP, Direction.LEFT_UP
    };

    public Pawn(Board board, Position position) {
        super("폰", board, position);
    }

    @Override
    protected MoveStrategy moveStrategies(Position position) {
        Position distance;
        if(this.isNotFirst) {
            distance = new Position(0, 1);
        }else {
            distance = new Position(0, 2);
            this.isNotFirst = true;
        }
        return new CompositeMoveStrategy(Arrays.asList(
                new WallNotMoveStrategy(super.getBoard(), position),
                new DirectionMoveStrategy(this.directions, super.getPosition(), position),
                new DistanceMoveStrategy(distance, super.getPosition(), position),
                new AttackMoveStrategy(this.getBoard(), position),
                new DontJumpStrategy(super.getBoard(), super.getPosition(), position)));
    }
}
