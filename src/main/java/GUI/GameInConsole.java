package GUI;

import boards.SmallBoard;
import interfaces.Board;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Bartlomiej Mroczek
 */
public class GameInConsole {
    private Board board;

    public GameInConsole(){
        initialBoard();
    }

    private void initialBoard(){
        board = new SmallBoard();
    }

    public void game() {

        BoardDisplayInConsole boardInConsole = new BoardDisplayInConsole(board);
        UserMoveInConsole userMove = new UserMoveInConsole(board);
        PCMoveInConsole pcPlayer = new PCMoveInConsole(board);
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
            }else if (board.hasOWon()){
                System.out.println("Unfortunately you LOST!");
            }else if (board.hasXWon()){
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
        if (repeatChar == 'R')
            return true;
       else
            return false;
    }
}
