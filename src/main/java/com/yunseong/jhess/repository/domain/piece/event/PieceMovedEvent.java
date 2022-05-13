package com.yunseong.jhess.repository.domain.piece.event;

import com.yunseong.jhess.repository.domain.piece.Piece;
import com.yunseong.jhess.repository.domain.piece.PieceResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class PieceMovedEvent implements PieceEvent {

    private PieceResponse pieceResponse;
    @Override
    public PieceResponse getPiece() {
        return this.pieceResponse;
    }
}