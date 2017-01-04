package org.bmroczek.GUI;

import org.bmroczek.board.SmallBoard;
import org.springframework.stereotype.Component;

/**
 * This class display game board in console
 * @author Bartlomiej Mroczek
 */
@Component
public class BoardDisplayInConsole {

    private SmallBoard board;

    private int height;
    private int width;

    public BoardDisplayInConsole(SmallBoard board) {
        this.board = board;
        height = board.getHEIGHT();
        width = board.getWIDTH();
    }

    public void displayBoard() {
        char boardToDisplay[][] = board.getBoard();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(boardToDisplay[i][j] + " ");
            }
            System.out.println();
        }
    }
}

