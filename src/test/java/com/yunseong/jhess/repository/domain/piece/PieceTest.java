package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.game.Board;
import com.yunseong.jhess.repository.domain.game.ChessBoard;
import com.yunseong.jhess.repository.domain.game.EmptyBoard;
import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.event.EventType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class PieceTest {

    @Test
    void 체스말_움직임_테스트() {
        // Arrange
        Board board = new EmptyBoard(new Position(8, 8));
        Piece[] pawns = {
                new Pawn(board, new Position(0, 1)), new Pawn(board, new Position(1, 1)), new Pawn(board, new Position(2, 1)), new Pawn(board, new Position(3, 1)),
                new Pawn(board, new Position(4, 1)), new Pawn(board, new Position(5, 1)), new Pawn(board, new Position(6, 1)), new Pawn(board, new Position(7, 1))
        };
        Piece[] rooks = { new Rook(board, new Position(0, 0)), new Rook(board, new Position(0, 7)) };
        Piece[] knights = { new Knight(board, new Position(1, 0)), new Knight(board, new Position(6, 0)) };
        Piece[] bishops = { new Bishop(board, new Position(2, 0)), new Bishop(board, new Position(5, 0)) };
        Piece queen = new Queen(board, new Position(3, 0));
        Piece king = new King(board, new Position(4, 0));

        Arrays.stream(pawns).forEach(Piece::create);
        Arrays.stream(rooks).forEach(Piece::create);
        Arrays.stream(knights).forEach(Piece::create);
        Arrays.stream(bishops).forEach(Piece::create);
        queen.create();
        king.create();
        // Act
        boolean pawn1_move = pawns[0].move(new Position(10, 0));
        boolean pawn2_move = pawns[1].move(new Position(1, 5));
        boolean pawn3_move = pawns[2].move(new Position(2, 2));

        boolean rook1_move = rooks[0].move(new Position(10, 0));
        boolean rook2_move = rooks[0].move(new Position(6, 5));
        boolean rook3_move = rooks[1].move(new Position(6, 7));

        boolean knight1_move = knights[0].move(new Position(3, 7));
        boolean knight2_move = knights[0].move(new Position(2, 9));
        boolean knight3_move = knights[1].move(new Position(4, 1));

        boolean bishop1_move = bishops[0].move(new Position(1, 0));
        boolean bishop2_move = bishops[0].move(new Position(9, 9));
        boolean bishop3_move = bishops[1].move(new Position(1, 4));

        boolean queen1_move = queen.move(new Position(10, 10));
        boolean queen2_move = queen.move(new Position(6, 3));

        boolean king1_move = king.move(new Position(2, 5));
        boolean king2_move = king.move(new Position(3, 1));
        // Assert
        assertAll(() -> assertFalse(pawn1_move, "Exception"), () -> assertFalse(pawn2_move, "Exception"), () -> {
                assertTrue(pawn3_move, "Exception");
                assertEquals(pawns[2].getPosition().getX(), 2);
            }, () -> assertFalse(knight1_move, "Exception"), () -> assertFalse(knight2_move, "Exception"), () -> {
                assertTrue(knight3_move, "Exception");
                assertEquals(knights[1].getPosition().getX(), 4);
                assertEquals(knights[1].getPosition().getY(), 1);
            }, () -> assertFalse(rook1_move, "Exception"), () -> assertFalse(rook2_move, "Exception"), () -> {
                assertTrue(rook3_move, "Exception");
                assertEquals(rooks[1].getPosition().getX(), 6);
            }, () -> assertFalse(bishop1_move, "Exception"), () -> assertFalse(bishop2_move, "Exception"), () -> {
                assertTrue(bishop3_move, "Exception");
                assertEquals(bishops[1].getPosition().getX(), 1);
            }, () -> assertFalse(queen1_move, "Exception"), () -> {
                assertTrue(queen2_move, "Exception");
                assertEquals(queen.getPosition().getX(), 6);
                assertEquals(queen.getPosition().getY(), 3);
            }, () -> assertFalse(king1_move, "Exception"), () -> {
                assertTrue(king2_move, "Exception");
                assertEquals(king.getPosition().getX(), 3);
                assertEquals(king.getPosition().getY(), 1);
            }
        );
    }
    
    @Test
    void 체스말_생성_이벤트_테스트() {
        // Arrange
        String[] message = new String[1];
        Piece pawn = new Pawn(new EmptyBoard(new Position(8, 8)), new Position(0, 0));
        pawn.addEventListener(EventType.MOVED, e -> {
            message[0] = "MOVED";
        });
        // Act
        pawn.create();
        pawn.move(new Position(0, 2));
        // Assert
        assertEquals(2, pawn.getPosition().getY());
        assertEquals("MOVED", message[0]);
    }
}