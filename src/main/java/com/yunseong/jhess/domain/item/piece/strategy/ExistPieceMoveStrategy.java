package com.yunseong.jhess.domain.item.piece.strategy;

import com.yunseong.jhess.domain.board.Board;
import com.yunseong.jhess.domain.common.Position;
import com.yunseong.jhess.domain.item.MoveStrategy;
import com.yunseong.jhess.domain.item.piece.EmptyItem;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExistPieceMoveStrategy implements MoveStrategy {

    private final Board board;
    private final Position position;
    private final Position target;
    private final boolean isExist;

    @Override
    public boolean canMove() {
        if(this.board.getItem(this.position) instanceof EmptyItem) return false;

        boolean existItem = board.isExistItem(target);

        if(!existItem && !isExist)
            return true;

        if(existItem && isExist)
            return true;

        return false;
    }
}
