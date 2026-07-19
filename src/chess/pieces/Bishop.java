package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);

        p.setValue(position.getRows() -1,position.getColumn() +1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRows()][p.getColumn()] = true;
            p.setValue(p.getRows() -1,p.getColumn()-1);
        }
        p.setValue(position.getRows()-1,position.getColumn()-1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRows()][p.getColumn()] = true;
            p.setValue(p.getRows() -1,p.getColumn()-1);
        }
        p.setValue(position.getRows() + 1,position.getColumn()-1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRows()][p.getColumn()] = true;
            p.setValue(p.getRows()+1,p.getColumn()-1);
        }
        p.setValue(position.getRows()+1,position.getColumn()+1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            matrix[p.getRows()][p.getColumn()] = true;
            p.setValue(p.getRows()+1,p.getColumn()+1);
        }
        return matrix;
    }

    @Override
    public String toString() {
        return "B";
    }
}
