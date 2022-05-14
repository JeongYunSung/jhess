package com.yunseong.jhess.domain.item.piece;

import com.yunseong.jhess.domain.board.Board;
import com.yunseong.jhess.domain.common.TeamColor;
import com.yunseong.jhess.domain.common.Direction;
import com.yunseong.jhess.domain.common.Position;
import com.yunseong.jhess.domain.item.MoveStrategy;
import com.yunseong.jhess.domain.item.piece.strategy.*;

import java.util.Arrays;

public class Knight extends Piece {
    private final Direction[] directions = new Direction[] {
            Direction.LEFT_LEFT_UP, Direction.RIGHT_RIGHT_UP,
            Direction.LEFT_LEFT_DOWN, Direction.RIGHT_RIGHT_DOWN,
            Direction.UP_UP_RIGHT, Direction.DOWN_DOWN_RIGHT,
            Direction.UP_UP_LEFT, Direction.DOWN_DOWN_LEFT,
    };

    public Knight(Board board, TeamColor color, Position position) {
        super("나이트", board, color, position);
    }

    @Override
    protected MoveStrategy moveStrategies(Position position) {
        return new CompositeMoveStrategy(Arrays.asList(
                new WallNotMoveStrategy(super.getBoard(), position),
                new OverlapMoveStrategy(super.getBoard(), super.getPosition(), position),
                new DirectionMoveStrategy(this.directions, super.getPosition(), super.getTeam(), position),
                new LengthMoveStrategy(2, super.getPosition(), position)));
    }
}
