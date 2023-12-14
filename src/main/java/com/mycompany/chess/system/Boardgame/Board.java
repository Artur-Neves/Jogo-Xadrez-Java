/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chess.system.Boardgame;

import com.mycompany.chess.system.Exception.BoardException;

/**
 *
 * @author devjava
 */
public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExist(position)) {
            throw new BoardException("Position not on the board");
        }
        System.out.println("error");
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) throws BoardException {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        piece.position = position;
        pieces[position.getRow()][position.getColumn()] = piece;
    }
    public Piece remocePiece(Position position){ 
          if (!positionExist(new Position(position.getRow(), position.getColumn()))) {
            throw new BoardException("Position not on the board");
          }
          else if (piece(position.getRow(), position.getColumn())==null){
              return null;
          }
        Piece aux = piece(position.getRow(), position.getColumn());
        aux.position = null;
        pieces[position.getRow()][position.getColumn()]=null;
        return aux;   
    }
    private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

    public boolean positionExist(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExist(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position.getRow(), position.getColumn()) != null;
    }

  

}
