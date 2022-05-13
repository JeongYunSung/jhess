package com.yunseong.jhess.repository.domain.piece.event;

import com.yunseong.jhess.repository.domain.piece.Piece;
import com.yunseong.jhess.repository.domain.piece.PieceResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PieceDestroyedEvent implements PieceEvent {

    private PieceResponse pieceResponse;
    @Override
    public PieceResponse getTarget() {
        return this.pieceResponse;
    }
}