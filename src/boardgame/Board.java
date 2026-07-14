package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int column) {
        if(rows < 1 || column < 1){
            throw new BoardException("Error creating the board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = column;
        pieces = new Piece[rows][column];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row,int column){
        if(!positionExists(row,column)){
            throw new BoardException("The position informed doesn't exists");
        }
        return pieces[row][column];
    }
    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("The position informed doesn't exists");
        }
        return pieces[position.getRows()][position.getColumn()];
    }
    public void placePieces(Piece piece,Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("Impossible to place: the position already have a piece");
        }
        pieces[position.getRows()][position.getColumn()] = piece;
        piece.position = position;
    }
    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Impossible to place: the position already have a piece");
        }
        if(piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        pieces[position.getRows()][position.getColumn()] = null;
        return aux;
    }
    private boolean positionExists(int row,int column){
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRows(),position.getColumn());
    }
    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("The position informed doesn't exists");
        }
        return piece(position) != null;
    }

}
