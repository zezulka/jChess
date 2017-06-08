package cz.muni.fi.jchess;

/**
 *
 * @author Miloslav Zezulka, 2017
 */
public class Position {

    private final int column;
    private final int row;

    public Position(int row, int column) {
        if(column < 0 || column > ChessBoard.COLUMN_MAX) {
            throw new IllegalArgumentException(
                    String.format("Column index must be in interval [0;%d].", ChessBoard.COLUMN_MAX));
        }
        if(row < 0 || row > ChessBoard.ROW_MAX) {
            throw new IllegalArgumentException(
                    String.format("Row index must be in interval [0;%d].", ChessBoard.ROW_MAX));
        }
        this.column = column;
        this.row = row;
    }
    
    public int getColumn() {
        return this.column;
    }
    
    public int getRow() {
        return this.row;
    }
    
    public int getColumnDifference(Position first, Position second) {
        return first.column - second.column;
    }
    
    public int getRowDifference(Position first, Position second) {
        return first.row - second.column;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.column;
        hash = 19 * hash + this.row;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.column != other.column) {
            return false;
        }
        if (this.row != other.row) {
            return false;
        }
        return true;
    }

        
}
