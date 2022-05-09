package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.api.Direction;
import com.yunseong.jhess.repository.domain.api.GameUtil;
import com.yunseong.jhess.repository.domain.api.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
public abstract class Piece {

    private int power;
    private Position position;

    public boolean move(Position position) {
        Direction[] directions = canDirection();

        Direction direction = GameUtil.getDirection(this.position, position);

        if(!Arrays.asList(directions).contains(direction)) return false;

        double distance = Math.sqrt(Math.pow((position.getX()+1) - (this.position.getX()+1), 2) + Math.pow((position.getY()+1) - (this.position.getY()+1), 2));

        if((int)distance > this.power) return false;

        if(!canMove()) return false;

        this.position = position;

        return true;
    }

    public abstract boolean canMove();
    public abstract Direction[] canDirection();
}
