package org.bmroczek.GUI;

import org.bmroczek.board.Point;
import org.bmroczek.interfaces.Board;
import org.bmroczek.players.HumanPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * @author Bartlomiej Mroczek
 */
@Component
public class UserMoveInConsole {

    @Autowired
    private HumanPlayer humanPlayer;
    private Board board;

    public UserMoveInConsole(Board board) {
        this.board = board;
    }

    public void userMoveInConsole() {
        Scanner scanner = new Scanner(System.in);

        Point point;
        boolean repeat;
        do {
            System.out.println("Your move: (enter coordinates e.g 0 0, 2 2, 2 1)");
            //TODO: Remove "new Point(...)"
            point = new Point(scanner.nextInt(), scanner.nextInt());
            if (humanPlayer.move(point)) {
                repeat = false;
            } else {
                repeat = true;
                System.out.println(" Given coordinates are incorrect, tray again");
                System.out.println("Available point: " + board.getEmptyPoints());

            }

        } while (repeat);
    }
}
