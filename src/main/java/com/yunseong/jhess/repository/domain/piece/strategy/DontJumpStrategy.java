package com.yunseong.jhess.repository.domain.piece.strategy;

import com.yunseong.jhess.repository.domain.game.Board;
import com.yunseong.jhess.repository.domain.module.Direction;
import com.yunseong.jhess.repository.domain.module.GameUtil;
import com.yunseong.jhess.repository.domain.module.Position;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DontJumpStrategy implements MoveStrategy {

    private Board board;
    private Position position;
    private Position target;

    @Override
    public boolean canMove() {
        int size;
        Direction direction = GameUtil.getDirection(this.target, this.position);
        Position nowPosition = new Position(this.position.getX(), this.position.getY());

        if(direction.getX() != 0 && direction.getY() != 0) {
            size = Math.max(Math.abs(this.target.getX()-this.position.getX()), Math.abs(this.target.getY()-this.position.getY()))-1;
            for(int i=0;i<size;i++) {
                nowPosition = isExist(nowPosition, nowPosition.getX() + direction.getX(), nowPosition.getY() + direction.getY());
                if (nowPosition == null) return false;
            }
        }else if(direction.getX() != 0 && direction.getY() == 0) {
            size = Math.abs(this.target.getX()-this.position.getX())-1;
            for(int i=0;i<size;i++) {
                nowPosition = isExist(nowPosition, nowPosition.getX() + direction.getX(), nowPosition.getY());
                if (nowPosition == null) return false;
            }
        }else {
            size = Math.abs(this.target.getY()-this.position.getY())-1;
            for(int i=0;i<size;i++) {
                nowPosition = isExist(nowPosition, nowPosition.getX(), nowPosition.getY() + direction.getY());
                if (nowPosition == null) return false;
            }
        }

        return true;
    }

    private Position isExist(Position nowPosition, int x, int y) {
        nowPosition = nowPosition.setLocation(x, y);
        if(board.isExistItem(nowPosition)) return null;
        return nowPosition;
    }
}
