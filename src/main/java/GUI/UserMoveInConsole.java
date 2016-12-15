package GUI;

import boards.Point;
import interfaces.Board;
import players.HumanPlayer;

import java.util.Scanner;

/**
 * @author Bartlomiej Mroczek
 */
public class UserMoveInConsole {

    public UserMoveInConsole(Board board) {
        this.board = board;
    }

    private Board board;


    public void userMoveInConsole(){
        Scanner scanner = new Scanner(System.in);
        HumanPlayer humanPlayer = new HumanPlayer(board);
        Point point;
        boolean repeat;
        do {
            System.out.println("Your move: (enter coordinates e.g 0 0, 2 2, 2 1)");
            point = new Point(scanner.nextInt(), scanner.nextInt());
            if (humanPlayer.move(point)){
                repeat = false;
            }else {
                repeat = true;
                System.out.println(" Given coordinates are incorrect, tray again");
                System.out.println("Available point: " + board.getEmptyPoints());

            }

        }while (repeat);
    }
}
