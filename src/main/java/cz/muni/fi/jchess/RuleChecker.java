package cz.muni.fi.jchess;

import cz.muni.fi.jchess.pieces.PieceColour;

/**
 *
 * @author Miloslav Zezulka, 2017
 */
public class RuleChecker {

    private static boolean isChecked(PieceColour colour) {
        return isKingEndangeredDiagonally(colour) ||
               isKingEndangeredInColumn(colour) ||
               isKingEndangeredInRow(colour);
    }

    private static boolean isKingEndangeredDiagonally(PieceColour colour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static boolean isKingEndangeredInColumn(PieceColour colour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static boolean isKingEndangeredInRow(PieceColour colour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
