package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);

        p.setValue(position.getRows()-1, position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRows()][p.getColumn()] = true;
        }
        p.setValue(position.getRows()+1, position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRows()][p.getColumn()] = true;
        }
        p.setValue(position.getRows(), position.getColumn()-1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRows()][p.getColumn()]=true;
        }
        p.setValue(position.getRows(), position.getColumn()+1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRows()][p.getColumn()] = true;
        }
        p.setValue(position.getRows() - 1, position.getColumn() +1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRows()][p.getColumn()] = true;
        }
        p.setValue(position.getRows() + 1, position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRows()][p.getColumn()] = true;
        }
        p.setValue(position.getRows() -1, position.getColumn()-1 );
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRows()][p.getColumn()] = true;
        }
        p.setValue(position.getRows() + 1, position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRows()][p.getColumn()] = true;
        }
        return matrix;
    }
    @Override
    public String toString() {
        return "K";
    }

}
