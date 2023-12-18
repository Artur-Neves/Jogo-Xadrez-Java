/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chess.system.Chess.pieces;

import com.mycompany.chess.system.Boardgame.Board;
import com.mycompany.chess.system.Boardgame.Position;
import com.mycompany.chess.system.Chess.ChessMath;
import com.mycompany.chess.system.Chess.ChessPiece;
import com.mycompany.chess.system.Chess.Color;

/**
 *
 * @author devjava
 */
public class King extends ChessPiece {
    private ChessMath cm;
    public King(Board board, Color color, ChessMath cm) {
        super(color, board);
        this.cm = cm;
    }
    
    @Override
    public String toString(){
        return "K";
    }
    public boolean testRoolCastling(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() ==0;
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
      p.setValues(position.getRow()+1, position.getColumn());
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
       
       p.setValues(position.getRow(), position.getColumn()+1);
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
      
       p.setValues(position.getRow(), position.getColumn()-1);
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
      
       p.setValues(position.getRow()-1, position.getColumn());
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
       
       p.setValues(position.getRow()+1, position.getColumn()+1);
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
      
       p.setValues(position.getRow()+1, position.getColumn()-1);
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
       
       p.setValues(position.getRow()-1, position.getColumn()+1);
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
              p.setValues(position.getRow()-1, position.getColumn()-1);
      if (getBoard().positionExist(p) && canMove(p)){
          mat[p.getRow()][p.getColumn()]= true;
      }
      
      if (getMoveCount() == 0 && !cm.isCheck()){
          Position pT1 = new Position(position.getRow(), position.getColumn()+3);
          if (testRoolCastling(pT1)){
              Position p1 = new Position(position.getRow(), position.getColumn()+1);
              Position p2 = new Position(position.getRow(), position.getColumn()+2);
              if (getBoard().piece(p1) == null && getBoard().piece(p2) == null){
                  mat[position.getRow()][position.getColumn()+1] = true;
              mat[position.getRow()][position.getColumn()+2] = true;    
              }
           
          }
          pT1.setColumn(position.getColumn()-4);
          if (testRoolCastling(pT1)){
              Position p1 = new Position(position.getRow(), position.getColumn()-1);
              Position p2 = new Position(position.getRow(), position.getColumn()-2);
               Position p3 = new Position(position.getRow(), position.getColumn()-3);
              if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
                  mat[position.getRow()][position.getColumn()-1] = true;
              mat[position.getRow()][position.getColumn()-2] = true;    
              }
           
          }
      }
       

      return mat;
    }
}
