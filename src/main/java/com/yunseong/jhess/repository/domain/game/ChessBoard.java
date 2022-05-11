package com.yunseong.jhess.repository.domain.game;

import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.Item;
import lombok.Getter;

@Getter
public class ChessBoard implements Board {

    private final Position position;
    private final Item[][] board;

    public ChessBoard() {
        this.position = new Position(8, 8);
        this.board = new Item[this.position.getY()][this.position.getX()];
        this.init();
    }

    private void init() {
        // 세팅할 예정
    }

    @Override
    public Position getSize() {
        return this.position;
    }

    @Override
    public Item getTarget(Position position) {
        return this.board[position.getY()][position.getX()];
    }
}
