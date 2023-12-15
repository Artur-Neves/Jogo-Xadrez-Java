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
 * @author devjava
 */
public class Rook extends ChessPiece {
    
    public Rook( Board board, Color color) {
        super(color, board);
    }
    
    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] possibleMovies() {
      boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
      Position p = new Position(0,0);
     //above
      p.setValues(position.getRow()-1, position.getColumn());
      while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
          p.setRow(p.getRow()-1);
      }
      if (getBoard().positionExist(p) && isThereOpponentPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
      }
       //left
      p.setValues(position.getRow(), position.getColumn()-1);
      while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
          p.setColumn(p.getColumn()-1);
      }
      if (getBoard().positionExist(p) && isThereOpponentPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
      }
       //above
      p.setValues(position.getRow(), position.getColumn()+1);
      while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
          p.setColumn(p.getColumn()+1);
      }
      if (getBoard().positionExist(p) && isThereOpponentPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
      }
       //below
      p.setValues(position.getRow()+1, position.getColumn());
      while(getBoard().positionExist(p) && !getBoard().thereIsAPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
          p.setRow(p.getRow()+1);
      }
      if (getBoard().positionExist(p) && isThereOpponentPiece(p)){
          mat[p.getRow()][p.getColumn()] = true;
      }
      return mat;
    }
}
