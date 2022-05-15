package com.yunseong.jhess.domain.item.piece;

import com.yunseong.jhess.domain.board.Board;
import com.yunseong.jhess.domain.common.TeamColor;
import com.yunseong.jhess.domain.common.Direction;
import com.yunseong.jhess.domain.common.Position;
import com.yunseong.jhess.domain.item.MoveStrategy;
import com.yunseong.jhess.domain.item.piece.strategy.*;

import java.util.Arrays;

public class Pawn extends Piece {
    private boolean isNotFirst;
    private final Direction[] directions = new Direction[] {
            Direction.UP
    };

    private final Direction[] attackDirections = new Direction[] {
            Direction.LEFT_UP, Direction.RIGHT_UP
    };

    public Pawn(Board board, TeamColor color, Position position) {
        super("폰", board, color, position);
    }

    @Override
    protected MoveStrategy moveStrategies(Position position) {
        Position distance;
        if(this.isNotFirst) {
            distance = new Position(1, 1);
        }else {
            distance = new Position(0, 2);
            this.isNotFirst = true;
        }
        return new OptionalMoveStrategy(new CompositeMoveStrategy(Arrays.asList(
                    new WallNotMoveStrategy(super.getBoard(), position),
                    new OverlapMoveStrategy(super.getBoard(), super.getPosition(), position),
                    new DistanceMoveStrategy(distance, super.getPosition(), position))),
                Arrays.asList(
                        new CompositeMoveStrategy(Arrays.asList(
                            new DirectionMoveStrategy(this.directions, super.getPosition(), super.getTeam(), position),
                            new ExistPieceMoveStrategy(super.getBoard(), super.getPosition(), position, false))),
                        new CompositeMoveStrategy(Arrays.asList(
                                new DirectionMoveStrategy(this.attackDirections, super.getPosition(), super.getTeam(), position),
                                new ExistPieceMoveStrategy(super.getBoard(), super.getPosition(), position, true)))));
    }
}
