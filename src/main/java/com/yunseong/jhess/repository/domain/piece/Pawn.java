package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.module.Direction;
import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.strategy.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Setter
@Getter
public class Pawn extends Piece {

    private Position distance;
    private final Direction[] directions = new Direction[] {
            Direction.UP, Direction.RIGHT_UP, Direction.LEFT_UP
    };

    public Pawn(Position position) {
        super("폰", position);
        this.distance = new Position(1, 1);
    }

    @Override
    protected MoveStrategy moveStrategies(Position position) {
        return new CompositeMoveStrategy(Arrays.asList(
                new DirectionMoveStrategy(this.directions, super.getPosition(), position),
                new DistanceMoveStrategy(this.distance, super.getPosition(), position)));
    }
}
