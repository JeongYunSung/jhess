package com.yunseong.jhess.repository.domain.piece.strategy;

import com.yunseong.jhess.repository.domain.module.Position;
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
