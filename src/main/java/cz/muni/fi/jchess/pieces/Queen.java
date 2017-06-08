package cz.muni.fi.jchess.pieces;

import cz.muni.fi.jchess.Position;


public class Queen extends AbstractPiece {

    public Queen(Position startPos, PieceColour colour) {
        super(startPos, colour);
    }

    @Override
    public boolean move(Position to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
