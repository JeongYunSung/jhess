package com.yunseong.jhess.repository.domain.game;

import com.yunseong.jhess.repository.domain.module.Color;
import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.*;
import com.yunseong.jhess.repository.domain.piece.exception.NotExistItemException;
import com.yunseong.jhess.repository.domain.piece.exception.OutOfBoardIndexException;
import lombok.Getter;

import java.util.Random;

@Getter
public class ChessBoard implements Board {

    private final Item[][] board;

    private final Position position;

    private BoardState state;

    private Color turn;

    public ChessBoard() {
        this.position = new Position(8, 8);
        this.board = new Item[this.position.getY()][this.position.getX()];
        this.state = BoardState.WAITING;
        this.turn = Color.valueOf(new Random().nextInt(2));
        this.init();
    }

    private void init() {
        int[] special = {0, 7};
        for(int x=0;x<board[0].length;x++) {
            this.board[1][x] = new Pawn(this, Color.BLACK, new Position(x, 1));
            this.board[6][x] = new Pawn(this, Color.WHITE, new Position(x, 6));
        }
        for(int y=2;y<board.length-2;y++) {
            for(int x=0;x<board[y].length;x++) {
                this.board[y][x] = new EmptyItem();
            }
        }
        for(int i=0;i<special.length;i++) {
            this.board[special[i]][0] = new Rook(this, Color.valueOf(7%special[i]), new Position(0, i));
            this.board[special[i]][1] = new Knight(this, Color.valueOf(7%special[i]), new Position(1, i));
            this.board[special[i]][2] = new Bishop(this, Color.valueOf(7%special[i]), new Position(2, i));
            this.board[special[i]][3] = new King(this, Color.valueOf(7%special[i]), new Position(3, i));
            this.board[special[i]][4] = new Queen(this, Color.valueOf(7%special[i]), new Position(4, i));
            this.board[special[i]][5]= new Bishop(this, Color.valueOf(7%special[i]), new Position(5, i));
            this.board[special[i]][6] = new Knight(this, Color.valueOf(7%special[i]), new Position(6, i));
            this.board[special[i]][7] = new Rook(this, Color.valueOf(7%special[i]), new Position(7, i));
        }
    }

    @Override
    public Item getItem(Position position) {
        if(position.getX() > this.getPosition().getX() || position.getY() > this.getPosition().getY()) throw new OutOfBoardIndexException(position);

        Item origin = this.board[position.getY()][position.getX()];
        if(origin instanceof EmptyItem) throw new NotExistItemException(position);

        return origin;
    }

    @Override
    public void process() {
        this.state = BoardState.PROCEEDING;
    }

    @Override
    public void finish() {
        this.state = BoardState.FINISHED;
    }

    @Override
    public Position getSize() {
        return this.position;
    }

    @Override
    public void move(Position position, Position target) {
        Item origin = this.getItem(this.position);

        Item temp = this.board[target.getY()][target.getX()];
        if(!(temp instanceof EmptyItem)) ((Piece)temp).destroy();

        origin.move(target);

        this.board[target.getY()][target.getX()] = origin;
        this.board[position.getY()][position.getX()] = temp;

        this.nextTurn();
    }

    @Override
    public boolean isExistItem(Position position) {
        if(position.getX() > this.getPosition().getX() || position.getY() > this.getPosition().getY()) throw new OutOfBoardIndexException(position);
        return this.board[position.getY()][position.getX()] != null && !(this.board[position.getY()][position.getX()] instanceof EmptyItem);
    }

    private void nextTurn() {
        this.turn = Color.valueOf(1%this.turn.getMultiple());
    }
}
