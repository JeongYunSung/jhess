package com.yunseong.jhess.repository.domain.piece.event;

import com.yunseong.jhess.repository.domain.piece.Piece;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PieceMovedEvent implements Event {

    private Piece piece;
}