package com.yunseong.jhess.exception;

import com.yunseong.jhess.domain.common.Position;

public class OutOfBoardIndexException extends RuntimeException {

    public OutOfBoardIndexException(Position position) {
        super("[" + position.getX() + ", " + position.getY() + "]은 존재하지 않는 영역이다.");
    }
}
