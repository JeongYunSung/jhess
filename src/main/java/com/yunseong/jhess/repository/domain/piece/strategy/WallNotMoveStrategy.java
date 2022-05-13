package com.yunseong.jhess.repository.domain.piece.strategy;

import com.yunseong.jhess.repository.domain.game.Board;
import com.yunseong.jhess.repository.domain.module.Position;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WallNotMoveStrategy implements MoveStrategy {

    private final Board board;
    private final Position target;

    @Override
    public boolean canMove() {
        return this.board.getSize().getX() > this.target.getX() || this.board.getSize().getY() > this.target.getY();
    }
}
