package com.yunseong.jhess.repository.domain.game;

import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.*;
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
        int[] special = {0, 7};
        for(int x=0;x<board[0].length;x++) {
            this.board[1][x] = new Pawn(this, new Position(x, 1));
            this.board[6][x] = new Pawn(this, new Position(x, 6));
        }
        for(int y=2;y<board.length-2;y++) {
            for(int x=0;x<board[y].length;x++) {
                this.board[y][x] = new EmptyItem(new Position(x, y));
            }
        }
        for(int i=0;i<special.length;i++) {
            this.board[special[i]][0] = new Rook(this, new Position(0, i));
            this.board[special[i]][1] = new Knight(this, new Position(1, i));
            this.board[special[i]][2] = new Bishop(this, new Position(2, i));
            this.board[special[i]][3] = new King(this, new Position(3, i));
            this.board[special[i]][4] = new Queen(this, new Position(4, i));
            this.board[special[i]][5]= new Bishop(this, new Position(5, i));
            this.board[special[i]][6] = new Knight(this, new Position(6, i));
            this.board[special[i]][7] = new Rook(this, new Position(7, i));
        }
    }

    @Override
    public Position getSize() {
        return this.position;
    }

    @Override
    public boolean isExistItem(Position position) {
        return this.board[position.getY()][position.getX()] != null && !(this.board[position.getY()][position.getX()] instanceof EmptyItem);
    }
}
