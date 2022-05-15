package com.yunseong.jhess.exception;

import com.yunseong.jhess.domain.item.piece.Piece;

public class AlreadyDestroyedPieceException extends RuntimeException {
    
    public AlreadyDestroyedPieceException(Piece piece) {
        super("해당 피스는 이미 파괴된 상태입니다.");
    }
}
