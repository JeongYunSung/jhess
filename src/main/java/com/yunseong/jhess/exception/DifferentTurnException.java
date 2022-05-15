package com.yunseong.jhess.exception;

import com.yunseong.jhess.domain.common.TeamColor;

public class DifferentTurnException extends RuntimeException {

    public DifferentTurnException(TeamColor teamColor) {
        super("현재 차례는 [" + teamColor.name() + "]입니다.");
    }
}
