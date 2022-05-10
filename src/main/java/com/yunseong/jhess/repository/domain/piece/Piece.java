package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.strategy.MoveStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Piece {

    private Position position;

    public boolean move(Position position) {
        if(!moveStrategies(position).canMove()) return false;

        this.position = position;

        return true;
    }

    public abstract MoveStrategy moveStrategies(Position position);
}
