/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chess.system.Aplication;

import com.mycompany.chess.system.Chess.ChessMath;
import com.mycompany.chess.system.Chess.ChessPiece;

/**
 *
 * @author devjava
 */
public class UI {

   public static void printBoard(ChessPiece[][] cm) {
        for (int row=0; row<cm.length; row++){
              System.out.print((8-row)+" ");
        for (int column=0; column<cm.length; column++){
            printPiece(cm[row][column]);
        }
            System.out.println("");
        }
        System.out.println("  a b c d e f g h");
    }
    private static void printPiece(ChessPiece piece){
    if (piece==null){
        System.out.print("-");
    }
    else {
        System.out.print(piece);
        
    }
        System.out.print(" ");
    }
}
