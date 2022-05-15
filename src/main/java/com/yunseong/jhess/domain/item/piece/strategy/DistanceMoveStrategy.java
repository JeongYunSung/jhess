package com.yunseong.jhess.domain.item.piece.strategy;

import com.yunseong.jhess.domain.common.Position;
import com.yunseong.jhess.domain.item.MoveStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DistanceMoveStrategy implements MoveStrategy {

    private final Position distance;
    private final Position position;
    private final Position target;

    @Override
    public boolean canMove() {
        int x = Math.abs(this.target.getX() - this.position.getX());
        int y = Math.abs(this.target.getY() - this.position.getY());

        return (this.distance.getX() >= x) && (this.distance.getY() >= y);
    }
}
