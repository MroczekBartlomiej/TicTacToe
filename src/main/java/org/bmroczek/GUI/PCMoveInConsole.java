package org.bmroczek.GUI;

import org.bmroczek.board.SmallBoard;
import org.bmroczek.players.PCPlayer;
import org.springframework.stereotype.Component;

/**
 * @author Bartlomiej Mroczek
 */
@Component
public class PCMoveInConsole extends PCPlayer {

    public PCMoveInConsole(SmallBoard board) {
        super(board);
    }

    public void doMove(){
        System.out.println("PC Move: ");
        move();
    }
}
