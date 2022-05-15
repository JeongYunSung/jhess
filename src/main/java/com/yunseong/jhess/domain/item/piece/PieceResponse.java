package com.yunseong.jhess.domain.item.piece;

import com.yunseong.jhess.domain.common.Position;
import lombok.Getter;

@Getter
public class PieceResponse {

    private final String name;
    private final PieceSate sate;
    private final Position position;

    public PieceResponse(Piece piece) {
        this.name = piece.getName();
        this.sate = piece.getState();
        this.position = piece.getPosition();
    }
}
