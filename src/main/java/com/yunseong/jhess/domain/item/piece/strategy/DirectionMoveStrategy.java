package com.yunseong.jhess.domain.item.piece.strategy;

import com.yunseong.jhess.domain.common.Direction;
import com.yunseong.jhess.domain.common.Position;
import com.yunseong.jhess.domain.common.TeamColor;
import com.yunseong.jhess.domain.item.MoveStrategy;
import com.yunseong.jhess.util.GameUtil;
import lombok.AllArgsConstructor;

import java.util.Arrays;

public class DirectionMoveStrategy implements MoveStrategy {

    private final Direction[] directions;
    private final Position position;
    private final Position target;

    public DirectionMoveStrategy(Direction[] directions, Position position, TeamColor turn, Position target) {
        if(turn == TeamColor.WHITE)
            this.directions = Direction.getReverseDirections(directions);
        else
            this.directions = directions;
        this.position = position;
        this.target = target;
    }

    @Override
    public boolean canMove() {
        Direction direction = GameUtil.getDirection(this.position, this.target);

        return Arrays.asList(this.directions).contains(direction);
    }
}
