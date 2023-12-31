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
public class Knight extends ChessPiece {
        public Knight(Board board, Color color) {
        super(color, board);
    }
    
    @Override
    public String toString(){
        return "N";
    }

    protected boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p== null || p.getColor() != getColor();
    }
     @Override
    public boolean[][] possibleMovies() {
      boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
      Position p = new Position(0, 0);
      //above
      p.setValues(position.getRow()+2, position.getColumn()+1);
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
       
       p.setValues(position.getRow()+2, position.getColumn()-1);
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
      
       p.setValues(position.getRow()-2, position.getColumn()+1);
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
      
       p.setValues(position.getRow()-2, position.getColumn()-1);
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
       
       p.setValues(position.getRow()+1, position.getColumn()+2);
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
      
       p.setValues(position.getRow()-1, position.getColumn()+2);
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
       
       p.setValues(position.getRow()+1, position.getColumn()-2);
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
              p.setValues(position.getRow()-1, position.getColumn()-2);
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
       

      return mat;
    }
}
