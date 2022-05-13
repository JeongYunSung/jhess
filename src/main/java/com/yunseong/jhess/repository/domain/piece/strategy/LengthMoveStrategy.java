package com.yunseong.jhess.repository.domain.piece.strategy;

import com.yunseong.jhess.repository.domain.module.Position;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LengthMoveStrategy implements MoveStrategy {

    private final int length;
    private final Position position;
    private final Position target;

    @Override
    public boolean canMove() {
        double distance = Math.sqrt(Math.pow((this.target.getX()+1) - (this.position.getX()+1), 2) + Math.pow((this.target.getY()+1) - (this.position.getY()+1), 2));

        return (int)distance <= this.length;
    }
}
