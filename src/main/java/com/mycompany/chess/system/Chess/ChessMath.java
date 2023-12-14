/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chess.system.Chess;

import com.mycompany.chess.system.Boardgame.Board;
import com.mycompany.chess.system.Boardgame.Position;
import com.mycompany.chess.system.Chess.pieces.King;
import com.mycompany.chess.system.Chess.pieces.Rook;

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
    public void initialSetup(){
        board.placePiece(new Rook(Color.BLACK, board), new Position(2, 4));
        board.placePiece(new King(Color.WHITE, board), new Position(0, 2));    
    }
}
