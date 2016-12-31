package org.bmroczek.GUI;


import org.bmroczek.interfaces.Board;
import org.bmroczek.players.PCPlayer;
import org.springframework.stereotype.Component;

/**
 * @author Bartlomiej Mroczek
 */
@Component
public class PCMoveInConsole extends PCPlayer {

    public PCMoveInConsole(Board board) {
        super(board);
    }

    public void doMove(){
        System.out.println("PC Move: ");
        randomPoint();
    }
}
