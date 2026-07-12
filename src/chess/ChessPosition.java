package chess;

import boardgame.Position;

public class ChessPosition {
    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if(row < 1 || row > 8 || column < 'a' || column > 'h'){
            throw new ChessException("Invalid position. Valid values are from a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }
    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
    }
    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a'- position.getColumn()),8- position.getRows());
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
