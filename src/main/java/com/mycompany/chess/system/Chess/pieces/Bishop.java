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
public class Bishop extends ChessPiece{

    public Bishop( Board board, Color color) {
        super(color, board);
    }
    
    @Override
    public String toString(){
        return "B";
    }

    @Override
    public boolean[][] possibleMovies() {
      boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
      Position p = new Position(0,0);
     //diagonal up right
      p.setValues(position.getRow()+1, position.getColumn()+1);
      while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
          p.setValues(p.getRow()+1, p.getColumn()+1);
      }
      if (getBoard().positionExist(p) && isThereOpponentPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
      }
       //diagonal up left
      p.setValues(position.getRow()+1, position.getColumn()-1);
      while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
          p.setValues(p.getRow()+1, p.getColumn()-1);
      }
      if (getBoard().positionExist(p) && isThereOpponentPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
      }
       //diagonal right down
      p.setValues(position.getRow()-1, position.getColumn()+1);
      while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
           p.setValues(p.getRow()-1, p.getColumn()+1);
      }
      if (getBoard().positionExist(p) && isThereOpponentPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
      }
       //diagonal left down
      p.setValues(position.getRow()-1, position.getColumn()-1);
      while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
          p.setValues(p.getRow()-1, p.getColumn()-1);
      }
      if (getBoard().positionExist(p) && isThereOpponentPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
      }
      return mat;
    }
    
}
