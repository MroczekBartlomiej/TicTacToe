package org.bmroczek.GUI;


import org.bmroczek.interfaces.Board;
import org.bmroczek.players.PCPlayer;

/**
 * @author Bartlomiej Mroczek
 */
public class PCMoveInConsole extends PCPlayer {

    public PCMoveInConsole(Board board) {
        super(board);
    }

    public void doMove(){
        System.out.println("PC Move: ");
        randomPoint();
    }
}
