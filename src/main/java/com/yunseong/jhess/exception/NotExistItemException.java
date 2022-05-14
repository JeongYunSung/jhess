package com.yunseong.jhess.exception;

import com.yunseong.jhess.domain.common.Position;

public class NotExistItemException extends RuntimeException {

    public NotExistItemException(Position position) {
        super("[" + position.getX() + ", " + position.getY() + "]해당 위치에는 아이템이 존재하지않습니다.");
    }
}
