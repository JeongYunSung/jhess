package com.yunseong.jhess.repository.board;

import com.yunseong.jhess.domain.board.Board;
import com.yunseong.jhess.domain.common.TeamColor;
import com.yunseong.jhess.domain.common.Position;
import com.yunseong.jhess.domain.item.Item;
import com.yunseong.jhess.domain.item.piece.EmptyItem;
import com.yunseong.jhess.domain.item.piece.Piece;

public class TestPieceBoard implements Board {

    private final Position size;
    private final Item[][] board;
    public TestPieceBoard(Position size) {
        this.size = size;
        this.board = new Item[this.size.getY()][this.size.getX()];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
               board[i][j] = new EmptyItem();
            }
        }
    }

    @Override
    public boolean addItem(Item item) {
        if(this.isExistItem(item.getPosition())) return false;

        this.board[item.getPosition().getY()][item.getPosition().getX()] = item;

        return true;
    }
    @Override
    public Position getSize() {
        return this.size;
    }
    @Override
    public Item getItem(Position position) {
        return this.board[position.getY()][position.getX()];
    }

    @Override
    public void move(Position position, Position target) {
        Piece origin = (Piece) this.getItem(position);
        Item temp = this.board[target.getY()][target.getX()];

        if(!origin.move(target)) return;

        this.board[target.getY()][target.getX()] = origin;
        this.board[position.getY()][position.getX()] = temp;

        if(temp instanceof Piece) ((Piece)temp).destroy();
    }

    @Override
    public boolean isExistItem(Position position) {
        return !(this.board[position.getY()][position.getX()] instanceof EmptyItem);
    }
}
