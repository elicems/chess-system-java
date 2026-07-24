package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    private ChessMatch chessMatch;
    public Pawn(Board board, Color color,ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }
    public ChessMatch getChessMatch(){
        return chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);
        if(getColor() == Color.WHITE){
            p.setValue(position.getRows()-1,position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                matrix[p.getRows()][p.getColumn()] = true;
            }
            p.setValue(position.getRows()-2,position.getColumn());
            Position p2 = new Position(p.getRows()+1,p.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)){
                matrix[p.getRows()][p.getColumn()] = true;
            }
            p.setValue(position.getRows()-1, position.getColumn()+1 );
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                matrix[p.getRows()][p.getColumn()] = true;
            }
            p.setValue(position.getRows()-1, position.getColumn() -1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                matrix[p.getRows()][p.getColumn()] = true;
            }
            if(position.getRows() == 3){
                Position left = new Position(position.getRows(), position.getColumn()-1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()){
                    matrix[left.getRows()-1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRows(), position.getColumn() + 1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()){
                    matrix[right.getRows() - 1][right.getColumn()] = true;
                }
            }
        }
        else {
            p.setValue(position.getRows()+1,position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                matrix[p.getRows()][p.getColumn()] = true;
            }
            p.setValue(position.getRows()+2,position.getColumn());
            Position p2 = new Position(p.getRows()-1,p.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)){
                matrix[p.getRows()][p.getColumn()] = true;
            }
            p.setValue(position.getRows()+1, position.getColumn()+1 );
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                matrix[p.getRows()][p.getColumn()] = true;
            }
            p.setValue(position.getRows()+1, position.getColumn() -1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                matrix[p.getRows()][p.getColumn()] = true;
            }
            if(position.getRows()==4){
                Position left = new Position(position.getRows(), position.getColumn() - 1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left)== chessMatch.getEnPassantVulnerable()){
                    matrix[left.getRows()+1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRows(), position.getColumn() + 1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()){
                    matrix[right.getRows() + 1][right.getColumn()]=true;
                }
            }
        }
        return matrix;
    }

    @Override
    public String toString() {
        return "P";
    }
}
