package com.yunseong.jhess.repository.domain.piece.strategy;

import com.yunseong.jhess.repository.domain.game.Board;
import com.yunseong.jhess.repository.domain.module.Position;

public class WallMoveStrategy implements MoveStrategy {

    private Board board;
    private Position position;
    private Position target;

    @Override
    public boolean canMove() {
        return false;
    }
}
