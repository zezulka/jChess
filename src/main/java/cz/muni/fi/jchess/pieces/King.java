package cz.muni.fi.jchess.pieces;

import cz.muni.fi.jchess.Position;

public class King extends AbstractPiece {

    public King(Position startPos, PieceColour col) {
        super(startPos, col);
    }

    @Override
    public boolean move(Position to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
