package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.api.Color;
import com.yunseong.jhess.repository.domain.api.Direction;
import com.yunseong.jhess.repository.domain.api.Position;
import com.yunseong.jhess.repository.domain.game.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Piece {

    private Board board;
    private Color color;
    private Position position;

    public boolean move(Position position) {
        Direction[] directions = canDirection();

        return false;
    }

    public abstract boolean canMove();
    public abstract Direction[] canDirection();
}
