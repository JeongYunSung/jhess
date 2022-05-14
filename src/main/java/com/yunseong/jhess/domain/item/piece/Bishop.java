package com.yunseong.jhess.domain.item.piece;

import com.yunseong.jhess.domain.board.Board;
import com.yunseong.jhess.domain.common.TeamColor;
import com.yunseong.jhess.domain.common.Direction;
import com.yunseong.jhess.domain.common.Position;
import com.yunseong.jhess.domain.item.MoveStrategy;
import com.yunseong.jhess.domain.item.piece.strategy.*;

import java.util.Arrays;

public class Bishop extends Piece {

    private final Direction[] directions = new Direction[] {
            Direction.LEFT_UP, Direction.RIGHT_UP,
            Direction.LEFT_DOWN, Direction.RIGHT_DOWN
    };

    public Bishop(Board board, TeamColor color, Position position) {
        super("비숍", board, color, position);
    }

    @Override
    protected MoveStrategy moveStrategies(Position position) {
        return new CompositeMoveStrategy(Arrays.asList(
                new WallNotMoveStrategy(super.getBoard(), position),
                new OverlapMoveStrategy(super.getBoard(), super.getPosition(), position),
                new DirectionMoveStrategy(this.directions, super.getPosition(), super.getTeam(), position),
                new DistanceMoveStrategy(new Position(8, 8), super.getPosition(), position),
                new DontJumpStrategy(super.getBoard(), super.getPosition(), position)));
    }
}