package com.yunseong.jhess.repository.domain.piece.event;

import com.yunseong.jhess.repository.domain.piece.Piece;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PieceDestroyedEvent implements Event {

    private Piece piece;

    @Override
    public Piece getTarget() {
        return this.piece;
    }

}