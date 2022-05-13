package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.module.Position;
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
