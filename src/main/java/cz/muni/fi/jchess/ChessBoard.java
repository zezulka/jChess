package cz.muni.fi.jchess;

import cz.muni.fi.jchess.pieces.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.List;

/**
 *
 * @author Miloslav Zezulka, 2017
 */
public class ChessBoard {

    private static final List<List<Piece>> PIECES = initBoard();
    private static Position blackKingPos = null;
    private static Position whiteKingPos = null;
    
    public  static final int COLUMN_MAX = 7;
    public  static final int ROW_MAX = 7;

    private static List<List<Piece>> initBoard() {
        List<List<Piece>> result = new ArrayList<>(ROW_MAX);
        for(int i = 0; i < result.size(); i++) {
            PieceColour colour = (i <= 2)  ? PieceColour.BLACK : PieceColour.WHITE;
            if(i == 0 || i == ROW_MAX - 1) {
                result.set(i, getNonPawnRow(colour));
                continue;
            }
            if(i == 1 || i == ROW_MAX - 2) {
                for(int k = 0; k < result.get(0).size(); k++){
                    result.get(i).add(new Pawn(new Position(k, i), colour));
                }
                continue;
            }
            for(int k = 0; k < result.get(0).size(); k++){
                    result.get(i).add(k, null);
            }
        }
        return result;
    }
    
    private static List<Piece> getNonPawnRow(PieceColour color) {
        int row = color.equals(PieceColour.BLACK) ? ROW_MAX - 1 : 0;
        return Arrays.asList( new Piece[]{
            new Rook(new Position(row, 0), color),
            new Knight(new Position(row, 1), color),
            new Bishop(new Position(row, 2),color),
            new Queen(new Position(row, 3), color),
            new King(new Position(row, 4), color),
            new Bishop(new Position(row, 5), color),
            new Knight(new Position(row, 6), color),
            new Rook(new Position(row, 7), color)
        });
    }
    
    private static Piece getPieceFromPosition(Position pos) {
        return PIECES.get(pos.getRow()).get(pos.getColumn());
    }
    
    private static Piece setPieceToPosition(Piece piece, Position pos) {
        return PIECES.get(pos.getRow()).set(pos.getColumn(), piece);
    }

    public static Position getBlackKingPos() {
        return blackKingPos;
    }

    public static Position getWhiteKingPos() {
        return whiteKingPos;
    }

    public static List<Piece> getColumnFromPosition(Position pos) {
        return Collections.unmodifiableList(PIECES.get(pos.getColumn()));
    }

    public static List<Piece> getRowFromPosition(Position pos) {
        return Collections.unmodifiableList(PIECES.get(pos.getRow()));
    }

    public static boolean isPositionOccupied(Position pos) {
        if (pos == null) {
            throw new IllegalArgumentException("Posítion cannot be null.");
        }
        return getPieceFromPosition(pos) != null;
    }

    private static boolean isPositionOccupiedByColour(Position pos, PieceColour colour) {
        if (pos == null) {
            throw new IllegalArgumentException("Posítion cannot be null.");
        }
        Piece piece = getPieceFromPosition(pos);
        return piece != null && piece.getColour().equals(colour);
    }

    public static boolean isPositionOccupiedByWhite(Position pos) {
        return isPositionOccupiedByColour(pos, PieceColour.WHITE);
    }

    public static boolean isPositionOccupiedByBlack(Position pos) {
        return isPositionOccupiedByColour(pos, PieceColour.BLACK);
    }

    public static Piece putPieceToPosition(Piece piece, Position pos) {
        if (piece == null) {
            throw new IllegalArgumentException("Piece cannot be null.");
        }
        if (pos == null) {
            throw new IllegalArgumentException("Position cannot be null.");
        }
        if (piece.equals(getPieceFromPosition(piece.getPosition()))) {
            if (piece instanceof King) {
                switch (piece.getColour()) {
                    case BLACK:
                        blackKingPos = pos;
                        break;
                    case WHITE:
                        whiteKingPos = pos;
                        break;
                    default:
                        throw new RuntimeException("Piece does not have valid colour");
                }
            }
            piece.setPosition(pos);
            setPieceToPosition(null, piece.getPosition());
            setPieceToPosition(piece, pos);
        }
        throw new IllegalStateException("The piece supplied does not exist on the position specified.");
    }

    public static boolean removePiece(Piece piece) {
        Position pos = piece.getPosition();
        return setPieceToPosition(null, pos) != null;
    }
}
