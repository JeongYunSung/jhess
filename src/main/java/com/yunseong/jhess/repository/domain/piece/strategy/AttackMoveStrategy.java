package com.yunseong.jhess.repository.domain.piece.strategy;

import com.yunseong.jhess.repository.domain.game.Board;
import com.yunseong.jhess.repository.domain.module.Position;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AttackMoveStrategy implements MoveStrategy {

    private Board board;
    private Position target;

    @Override
    public boolean canMove() {
        return this.board.isExistItem(target);
    }
}
