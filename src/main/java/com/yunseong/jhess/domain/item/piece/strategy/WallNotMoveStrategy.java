package com.yunseong.jhess.domain.item.piece.strategy;

import com.yunseong.jhess.domain.board.Board;
import com.yunseong.jhess.domain.common.Position;
import com.yunseong.jhess.domain.item.MoveStrategy;
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
