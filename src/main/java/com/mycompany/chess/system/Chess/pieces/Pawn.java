/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chess.system.Chess.pieces;

import com.mycompany.chess.system.Boardgame.Board;
import com.mycompany.chess.system.Boardgame.Position;
import com.mycompany.chess.system.Chess.ChessPiece;
import com.mycompany.chess.system.Chess.Color;

/**
 *
 * @author g15
 */
public class Pawn extends ChessPiece{

    public Pawn(Board board, Color color) {
        super(color, board);
    }

   
    @Override
    public String toString(){
        return "P";
    }
    

    @Override
    public boolean[][] possibleMovies() {
       // o peáo começa com dois movimentos para frente
       // apoś o primeiro movimento o peão somente poderá andar 1 casa a frente
       // ele so pode andar nas diagonais se tiver outra peça para ser comida lá
       boolean mat[][] = new boolean[getBoard().getRows()][getBoard().getColumns()];
       Position p = new Position(0, 0);
       // Primeiro movimento 
       if(getColor() == Color.WHITE){
       p.setValues(position.getRow()-1, position.getColumn());
       if (  canMove(p) ||  getBoard().positionExist(position) && !getBoard().thereIsAPiece(p)){
           mat[p.getRow()][p.getColumn()] = true;
           mat[p.getRow()-1][p.getColumn()] = (getMoveCount()==0 && !getBoard().thereIsAPiece(p)) ? true : false;
       }
       p.setValues(position.getRow()-1, position.getColumn()+1);
       if(canMove(p)){
           mat[p.getRow()][p.getColumn()] = true;
       }

       p.setValues(position.getRow()-1, position.getColumn()-1);
      if (canMove(p)){
           mat[p.getRow()][p.getColumn()] = true;
           
       }}
       else{
            p.setValues(position.getRow()+1, position.getColumn());
       if (  canMove(p) ||  getBoard().positionExist(position) && !getBoard().thereIsAPiece(p)){
           mat[p.getRow()][p.getColumn()] = true;
           mat[p.getRow()+1][p.getColumn()] = (getMoveCount()==0 && !getBoard().thereIsAPiece(p)) ? true : false;
       }
       p.setValues(position.getRow()+1, position.getColumn()+1);
       if(canMove(p)){
           mat[p.getRow()][p.getColumn()] = true;
       }

       p.setValues(position.getRow()+1, position.getColumn()-1);
      if (canMove(p)){
           mat[p.getRow()][p.getColumn()] = true;
           
       }
       }
       
       return mat;
    }


    protected boolean canMove(Position position) {
        
        return (getBoard().positionExist(position) && isThereOpponentPiece(position)) ? true : false;  
    }
    
}
