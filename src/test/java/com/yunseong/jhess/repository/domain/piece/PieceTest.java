package com.yunseong.jhess.repository.domain.piece;

import com.yunseong.jhess.repository.domain.module.Position;
import com.yunseong.jhess.repository.domain.piece.event.EventType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PieceTest {

    @Test
    void 체스말_움직임_테스트() {
        // Arrange
        Piece[] pawns = {
                new Pawn(new Position(0, 1)), new Pawn(new Position(1, 1)), new Pawn(new Position(2, 1)), new Pawn(new Position(3, 1)),
                new Pawn(new Position(4, 1)), new Pawn(new Position(5, 1)), new Pawn(new Position(6, 1)), new Pawn(new Position(7, 1))
        };
        Piece[] rooks = { new Rook(new Position(0, 0)), new Rook(new Position(0, 7)) };
        Piece[] knights = { new Knight(new Position(1, 0)), new Knight(new Position(6, 0)) };
        Piece[] bishops = { new Bishop(new Position(2, 0)), new Bishop(new Position(5, 0)) };
        Piece queen = new Queen(new Position(3, 0));
        Piece king = new King(new Position(4, 0));
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
        boolean bishop3_move = bishops[1].move(new Position(3, 2));

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
                assertEquals(bishops[1].getPosition().getX(), 3);
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
        Piece pawn = new Pawn(new Position(0, 0));
        pawn.addEventListener(EventType.CREATED, e -> {
            Piece piece = e.getPiece();
            piece.setLength(5);
        });
        pawn.addEventListener(EventType.MOVED, e -> {
            System.out.println("MOVED");
        });
        // Act
        pawn.create();
        pawn.move(new Position(4, 4));
        // Assert
        assertEquals(4, pawn.getPosition().getX());
        assertEquals(4, pawn.getPosition().getY());
    }
}