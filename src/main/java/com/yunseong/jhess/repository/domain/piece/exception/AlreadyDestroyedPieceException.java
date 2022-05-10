package com.yunseong.jhess.repository.domain.piece.exception;

import com.yunseong.jhess.repository.domain.piece.Piece;

public class AlreadyDestroyedPieceException extends RuntimeException {
    
    public AlreadyDestroyedPieceException(Piece piece) {
        super("해당 피스는 이미 파괴된 상태입니다.");
    }
}
