/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chess.system.Aplication;

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

                System.out.println("");
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(s);
                System.out.println("target"+target.toString());
                ChessPiece capturedPiece =  cm.peformMove(source, target);
                System.out.println("error");                
//System.out.println("");
                //s.nextLine();
            }
            catch(ChessException e){
                System.out.println(e.getMessage());
              
                System.out.println("error");
            }
            catch(InputMismatchException e){
               System.out.println(e.getMessage());
             
                System.out.println("error");
            }
            catch(BoardException e){
                e.printStackTrace();
            }
            catch(Exception e){
               e.printStackTrace();
            }
        }
    }
}
