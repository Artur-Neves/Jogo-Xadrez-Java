/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chess.system.Boardgame;

/**
 *
 * @author devjava
 */
public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
    }
    
    protected Board getBoard(){
        return board;
    }
    public abstract boolean[][] possibleMovies();
    public boolean possibleModve(Position position){
       return  possibleMovies()[position.getRow()][position.getColumn()];
    }
    public boolean isThereAnyPossibleMove(){
        boolean[][] now = possibleMovies();
        for (int row=0;row<now.length; row++){
            for (int column = 0; column<now.length; column++){
                if (now[row][column])
                    return true;
            }
        }
        return false;
    }
}
