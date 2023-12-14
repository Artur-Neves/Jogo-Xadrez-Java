/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chess.system.Aplication;

import com.mycompany.chess.system.Boardgame.Position;
import com.mycompany.chess.system.Chess.ChessMath;

/**
 *
 * @author devjava
 */
public class Main {
    public static void main (String[] args){
        ChessMath cm = new ChessMath();
        UI.printBoard(cm.getPieces());
    }
}
