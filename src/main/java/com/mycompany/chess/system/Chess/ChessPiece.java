/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chess.system.Chess;

import com.mycompany.chess.system.Boardgame.Board;
import com.mycompany.chess.system.Boardgame.Piece;
import com.mycompany.chess.system.Boardgame.Position;

/**
 *
 * @author devjava
 */
public abstract class ChessPiece extends Piece{
    private Color color;

    public ChessPiece(Color color, Board board) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    protected boolean isThereOpponentPiece( Position position){
       return this == (ChessPiece) getBoard().piece(position);
    }
    

    
    
}
