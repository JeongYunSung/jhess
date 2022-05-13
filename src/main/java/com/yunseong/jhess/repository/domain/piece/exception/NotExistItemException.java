package com.yunseong.jhess.repository.domain.piece.exception;

import com.yunseong.jhess.repository.domain.module.Position;

public class NotExistItemException extends RuntimeException {

    public NotExistItemException(Position position) {
        super("[" + position.getX() + ", " + position.getY() + "]해당 위치에는 아이템이 존재하지않습니다.");
    }
}
