package GUI;

import interfaces.Board;
import players.PCPlayer;

/**
 * @author Bartlomiej Mroczek
 */
public class PCMoveInConsole extends PCPlayer{

    public PCMoveInConsole(Board board) {
        super(board);
    }

    public void doMove(){
        System.out.println("PC Move: ");
        randomPoint();
    }
}
