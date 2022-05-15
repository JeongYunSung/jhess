package com.yunseong.jhess.domain.item.piece.strategy;

import com.yunseong.jhess.domain.item.MoveStrategy;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class OptionalMoveStrategy implements MoveStrategy {

    private final CompositeMoveStrategy requiredMoveStrategy;
    private final List<MoveStrategy> optionalMoveStrategy;

    @Override
    public boolean canMove() {
        if(!this.requiredMoveStrategy.canMove()) return false;
        boolean move = false;

        for(MoveStrategy moveStrategy : this.optionalMoveStrategy) {
            if(moveStrategy.canMove()) move = true;
        }

        return move;
    }
}
