package cz.muni.fi.jchess.pieces;

import cz.muni.fi.jchess.Position;

/**
 *
 * @author Miloslav Zezulka, 2017
 */
public abstract class AbstractPiece implements Piece {
    
    Position pos;
    PieceColour colour;

    public AbstractPiece(Position startPos, PieceColour colour) {
        if(pos == null) {
            throw new IllegalArgumentException("Position cannot be null.");
        }
        if(colour == null) {
            throw new IllegalArgumentException("Colour cannot be null.");
        }
        this.pos = startPos;
        this.colour = colour;
    }

    @Override
    public PieceColour getColour() {
        return this.colour;
    }

    @Override
    public Position getPosition() {
        return this.pos;
    }

    @Override
    public void setPosition(Position pos) {
        if(pos == null) {
            throw new IllegalArgumentException("Position cannot be null.");
        }
        this.pos = pos;
    }
    
}
