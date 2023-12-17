/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chess.system.Chess;

import com.mycompany.chess.system.Boardgame.Board;
import com.mycompany.chess.system.Boardgame.Piece;
import com.mycompany.chess.system.Boardgame.Position;
import com.mycompany.chess.system.Chess.pieces.King;
import com.mycompany.chess.system.Chess.pieces.Pawn;
import com.mycompany.chess.system.Chess.pieces.Rook;
import com.mycompany.chess.system.Exception.ChessException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author devjava
 */
public class ChessMath {

    private int turn;
    private Color currentPlayer;
    private Board board;
    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();
    private boolean check;
    private boolean checkMate;

    public ChessMath() {
        this.board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
        this.initialSetup();
    }

    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isCheck() {
        return check;
    }

    public boolean isCheckMate() {
        return checkMate;
    }
    

    private void nexTurn() {
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int row = 0; row < board.getRows(); row++) {
            for (int column = 0; column < board.getColumns(); column++) {
                mat[row][column] = (ChessPiece) board.piece(row, column);
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        
        piecesOnTheBoard.add(piece);
    }

    public void initialSetup() {
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
        placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('h', 2, new Pawn(board, Color.WHITE));

        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        placeNewPiece('a', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('b', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('c', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('e', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('g', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('h', 7, new Pawn(board, Color.BLACK));
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMovies();
    }

    public ChessPiece peformMove(ChessPosition sourcePosirion, ChessPosition targetPosition) {
        Position source = sourcePosirion.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        if (testCheque(currentPlayer)){
            undoMove(source, target, capturedPiece);
            throw new ChessException("You can't put yourself in check");
        }
        check = (testCheque(opponent(currentPlayer))) ? true : false;
        if (testCheckMate(opponent(currentPlayer))){
            checkMate = true;
        }
        else{
        nexTurn(); }
        return (ChessPiece) capturedPiece;
    }

    private void validateSourcePosition(Position source) {
        if (!board.thereIsAPiece(source)) {
            throw new ChessException("There is no piece on source position");
        }
        if (currentPlayer != ((ChessPiece) board.piece(source)).getColor()) {
            throw new ChessException("The chosen pice is not yours");
        }
        if (!board.piece(source).isThereAnyPossibleMove()) {
            throw new ChessException("There is no possible moves for the chosen ");
        }
    }
    private ChessPiece king( Color color){
        List<Piece> p = piecesOnTheBoard.stream().filter(x-> ((ChessPiece)x).getColor()== color).collect(Collectors.toList());
        for (Piece peca : p){
            if(peca instanceof King){
                return (ChessPiece) peca;
            }
        } 
        throw new IllegalStateException("There is no " + color + "king on the board" );
    }
    
    private boolean testCheque(Color color){
        Position p = king(color).getChessPosition().toPosition();
        List<Piece> list = piecesOnTheBoard.stream().filter(x-> ((ChessPiece)x).getColor()== opponent(color)).collect(Collectors.toList());
        for (Piece piece : list) {
            if (piece.possibleMovies()[p.getRow()][p.getColumn()]){
                return true;
            }
      
        }
        return false;
    }
    
    private boolean testCheckMate(Color color){
       if (!testCheque(color)){
           return false;
       }    
       List<Piece> p = piecesOnTheBoard.stream().filter(x-> ((ChessPiece)x).getColor()==color).collect(Collectors.toList());
        for (Piece piece : p) {
            boolean [][] mat = piece.possibleMovies();
            for(int row=0; row<board.getRows(); row++){
                for(int column=0; column<board.getColumns(); column++){
                    if (mat[row][column]){
                        Position source = ((ChessPiece)piece).getChessPosition().toPosition();
                        Position target = new Position(row, column);
                        Piece capt = makeMove(source, target);
                        boolean testcheque = !testCheque(color); 
                        undoMove(source, target, capt);
                        if (testcheque){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
       
       
    }

    private void validateTargetPosition(Position source, Position target) {
         if (!board.piece(source).possibleModve(target)) {
            throw new ChessException("The chosen piece can't move to target position");
        }
    }
    
    private Color opponent(Color color){
        return (color==Color.BLACK) ? Color.WHITE : Color.BLACK;
    }
    private Piece makeMove(Position source, Position target) {
        ChessPiece p = (ChessPiece) board.remocePiece(source);
        p.incrementMoveCount();
        Piece capt = board.remocePiece(target);
        board.placePiece(p, target);
        if (capt != null) {
            piecesOnTheBoard.remove(capt);
            capturedPieces.add(capt);
        }
        return capt;
    }

    private void undoMove(Position source, Position target, Piece capt) {
        ChessPiece p = (ChessPiece) board.remocePiece(target);
        p.decrementMoveCount();
        board.placePiece(p, source);
        if (capt != null) {
            board.placePiece(p, target);
            capturedPieces.remove(p);
            piecesOnTheBoard.add(p);
        }
    }
}
