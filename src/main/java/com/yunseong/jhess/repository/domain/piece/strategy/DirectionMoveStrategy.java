package com.yunseong.jhess.repository.domain.piece.strategy;

import com.yunseong.jhess.repository.domain.module.Direction;
import com.yunseong.jhess.repository.domain.module.GameUtil;
import com.yunseong.jhess.repository.domain.module.Position;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class DirectionMoveStrategy implements MoveStrategy {

    private Direction[] directions;
    private Position position;
    private Position target;

    @Override
    public boolean canMove() {
        Direction direction = GameUtil.getDirection(this.position, this.target);

        return Arrays.asList(this.directions).contains(direction);
    }
}
