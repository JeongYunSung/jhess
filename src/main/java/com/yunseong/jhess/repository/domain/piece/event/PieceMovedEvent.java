package com.yunseong.jhess.repository.domain.piece.event;

import com.yunseong.jhess.repository.domain.piece.Piece;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class PieceMovedEvent implements Event {

    private Piece piece;

    @Override
    public Piece getTarget() {
        return this.piece;
    }
}