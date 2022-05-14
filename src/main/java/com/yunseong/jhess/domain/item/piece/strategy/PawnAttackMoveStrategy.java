package com.yunseong.jhess.domain.item.piece.strategy;

import com.yunseong.jhess.domain.board.Board;
import com.yunseong.jhess.domain.common.TeamColor;
import com.yunseong.jhess.domain.common.Direction;
import com.yunseong.jhess.domain.common.Position;
import com.yunseong.jhess.domain.item.Item;
import com.yunseong.jhess.domain.item.MoveStrategy;
import com.yunseong.jhess.domain.item.piece.EmptyItem;
import com.yunseong.jhess.domain.item.piece.Piece;
import com.yunseong.jhess.util.GameUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PawnAttackMoveStrategy implements MoveStrategy {

    private final Board board;
    private final Position position;
    private final Position target;

    @Override
    public boolean canMove() {
        Direction direction = GameUtil.getDirection(position, target);

        Item<?> item = this.board.getItem(this.position);

        if(this.board.getItem(this.position) instanceof EmptyItem) return false;

        if(item.getTeam() == TeamColor.WHITE) {
            direction = Direction.getReverseDirection(direction);
        }

        if(!(direction == Direction.RIGHT_UP || direction == Direction.LEFT_UP)) return false;

        if(!board.isExistItem(target)) return false;

        return true;
    }
}
