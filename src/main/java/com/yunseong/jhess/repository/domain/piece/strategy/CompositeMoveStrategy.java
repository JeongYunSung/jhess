package com.yunseong.jhess.repository.domain.piece.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CompositeMoveStrategy implements MoveStrategy {

    private List<MoveStrategy> list;

    @Override
    public boolean canMove() {
        for(MoveStrategy moveStrategy : this.list) {
            if(!moveStrategy.canMove())
                return false;
        }
        return true;
    }
}
