package cz.muni.fi.jchess.pieces;

import cz.muni.fi.jchess.Position;


/**
 *
 * @author Miloslav Zezulka, 2017
 */
public interface Piece {
    boolean move(Position to);
    PieceColour getColour();
    Position getPosition();
    void setPosition(Position pos);
}
