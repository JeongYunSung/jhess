package com.yunseong.jhess.domain.item.piece.strategy;

import com.yunseong.jhess.domain.board.Board;
import com.yunseong.jhess.domain.common.Position;
import com.yunseong.jhess.domain.item.Item;
import com.yunseong.jhess.domain.item.MoveStrategy;
import com.yunseong.jhess.domain.item.piece.EmptyItem;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OverlapMoveStrategy implements MoveStrategy {

    private Board board;
    private Position position;
    private Position target;

    @Override
    public boolean canMove() {
        Item<?> targetItem = this.board.getItem(this.target);

        if(targetItem instanceof EmptyItem) return true;

        Item<?> item = this.board.getItem(this.position);

        return item.getTeam() != targetItem.getTeam();
    }
}