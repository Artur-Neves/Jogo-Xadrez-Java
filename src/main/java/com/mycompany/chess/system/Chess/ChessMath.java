/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chess.system.Chess;

import com.mycompany.chess.system.Boardgame.Board;
import com.mycompany.chess.system.Boardgame.Piece;
import com.mycompany.chess.system.Boardgame.Position;
import com.mycompany.chess.system.Chess.pieces.King;
import com.mycompany.chess.system.Chess.pieces.Rook;
import com.mycompany.chess.system.Exception.ChessException;

/**
 *
 * @author devjava
 */
public class ChessMath {
    private Board board;

    public ChessMath() {
        this.board = new Board(8, 8);
        this.initialSetup();
    }
    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int row=0; row<board.getRows(); row++){
            for (int column=0; column<board.getColumns(); column++){
            mat[row][column] = (ChessPiece) board.piece(row, column);
            }
        }
        return mat;
    }
    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }
    public void initialSetup(){
     	placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));   
    }
    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMovies();
    }
    public ChessPiece peformMove (ChessPosition sourcePosirion, ChessPosition targetPosition){
        Position source = sourcePosirion.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece caoturedPiece = makeMove(source, target);
        return (ChessPiece) caoturedPiece;
    }
    
    private void validateSourcePosition(Position source) {
        if (!board.thereIsAPiece(source)){
            throw new ChessException("There is no piece on source position");
        }
        if(!board.piece(source).isThereAnyPossibleMove()){
            throw new ChessException("There is no possible moves for the chosen ");
        }
    }
    private void validateTargetPosition(Position source, Position target){
        if (!board.piece(source).possibleModve(target)){
            throw new ChessException("The chosen piece can't move to target position");
        }
    }

    private Piece makeMove(Position source, Position target) {
       Piece p = board.remocePiece(source);
       Piece capt = board.remocePiece(target);
       board.placePiece(p, target);
       return capt;
    }
}
