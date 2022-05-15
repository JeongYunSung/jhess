package com.yunseong.jhess.exception;

public class DontMoveException extends RuntimeException {

    public DontMoveException() {
        super("해당 아이템은 해당 위치로 움직일 수 없습니다.");
    }
}
