/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chess.system.Aplication;

import com.mycompany.chess.system.Boardgame.Position;
import com.mycompany.chess.system.Chess.ChessMath;
import com.mycompany.chess.system.Chess.ChessPiece;
import com.mycompany.chess.system.Chess.ChessPosition;
import com.mycompany.chess.system.Exception.BoardException;
import com.mycompany.chess.system.Exception.ChessException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author devjava
 */
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ChessMath cm = new ChessMath();
        while (true) {
            try{
                UI.clearScreen();
                UI.printBoard(cm.getPieces());
                System.out.println("");
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(s);
                boolean[][] b = cm.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(cm.getPieces(), b);
                System.out.print("possíveis posições: ");
                for (int row=0; row<b.length; row++){
                    for (int column = 0; column<b.length; column++){
                        if (b[row][column]){

                            System.out.print(" "+UI.printChessPosition(new Position(row, column)));
                        }}
                }
                System.out.println("");
                System.out.println("Target: ");
                ChessPosition target = UI.readChessPosition(s);
                ChessPiece capture = cm.peformMove(source, target);
            }
            catch(ChessException e){
                System.out.println(e.getMessage());
                s.nextLine();
            }
            catch(InputMismatchException e){
               System.out.println(e.getMessage());
                s.nextLine(); 
            }
            catch(BoardException e){
                
            }
        }
    }
}
