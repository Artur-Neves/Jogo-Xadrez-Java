/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chess.system.Chess.pieces;

import com.mycompany.chess.system.Boardgame.Board;
import com.mycompany.chess.system.Chess.ChessPiece;
import com.mycompany.chess.system.Chess.Color;

/**
 *
 * @author devjava
 */
public class King extends ChessPiece {
    
    public King(Color color, Board board) {
        super(color, board);
    }
    
    @Override
    public String toString(){
        return "K";
    }
}
