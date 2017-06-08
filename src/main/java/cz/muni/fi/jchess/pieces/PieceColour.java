package cz.muni.fi.jchess.pieces;

/**
 *
 * @author Miloslav Zezulka, 2017
 */
public enum PieceColour {
    BLACK, WHITE;
    
    public boolean isOppositeOf(PieceColour colour) {
        return !colour.equals(this);
    }
}
