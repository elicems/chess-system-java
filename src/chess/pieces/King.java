package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;
    public King(Board board, Color color,ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }
    private boolean testRookCastling(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p instanceof Rook && p.getMoveCount() == 0 && p.getColor() == getColor();
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
        if(getMoveCount() == 0 && !chessMatch.getCheck()){
            Position p1 = new Position(position.getRows(), position.getColumn() + 3);
            if(testRookCastling(p1)){
                Position p2 = new Position(position.getRows(), position.getColumn() + 1);
                Position p3 = new Position(position.getRows(), position.getColumn() + 2);
                if(getBoard().piece(p2) == null && getBoard().piece(p3) == null){
                    matrix[position.getRows()][position.getColumn() + 2] = true;
                }
            }
        }
        if(getMoveCount() == 0 && !chessMatch.getCheck()){
            Position p1 = new Position(position.getRows(), position.getColumn() - 4);
            if(testRookCastling(p1)){
                Position p2 = new Position(position.getRows(), position.getColumn() - 1);
                Position p3 = new Position(position.getRows(), position.getColumn() -2);
                Position p4 = new Position(position.getRows(), position.getColumn() -3);
                if(getBoard().piece(p2) == null && getBoard().piece(p3) == null && getBoard().piece(p4) == null){
                    matrix[position.getRows()][position.getColumn()-2] = true;
                }
            }
        }
        return matrix;
    }
    @Override
    public String toString() {
        return "K";
    }

}
