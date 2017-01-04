package org.bmroczek.GUI;


import org.bmroczek.board.SmallBoard;
import org.bmroczek.players.PlayerSign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Bartlomiej Mroczek
 */
@Component
public class GameInConsole {

    @Autowired
    private SmallBoard board;
    @Autowired
    private BoardDisplayInConsole boardInConsole;
    @Autowired
    private UserMoveInConsole userMove;
    @Autowired
    private PCMoveInConsole pcPlayer;


    public void game() {
        Random lottery = new Random();

        do {
            board = new SmallBoard();
            if (lottery.nextBoolean()){
                pcPlayer.doMove();
                boardInConsole.displayBoard();
            }
            while (!board.isGameOver()) {
                userMove.userMoveInConsole();
                boardInConsole.displayBoard();
                pcPlayer.doMove();
                boardInConsole.displayBoard();

            }
            if (board.getEmptyPoints().isEmpty()){
                System.out.println("DRAW!");
            } else if (board.checkWinner(PlayerSign.HUMAN)) {
                System.out.println("Unfortunately you LOST!");
            } else if (board.checkWinner(PlayerSign.COMPUTER)) {
                System.out.println("Congratulation, you WIN!");
            }
        } while (repeatLoop());
    }

    private boolean repeatLoop(){
        char repeatChar = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you want play again insert 'R' or press Enter to exit.");
        try {
            repeatChar = scanner.nextLine().charAt(0);
        }catch (StringIndexOutOfBoundsException exc){
        }
        return repeatChar == 'R';
    }
}
