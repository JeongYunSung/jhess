package com.yunseong.jhess.domain.item.piece.event;

import com.yunseong.jhess.domain.item.Event;
import com.yunseong.jhess.domain.item.piece.PieceResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PieceMovedEvent implements Event<PieceResponse> {

    private PieceResponse pieceResponse;
    @Override
    public PieceResponse getTarget() {
        return this.pieceResponse;
    }
}