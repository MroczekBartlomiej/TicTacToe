package org.bmroczek.GUI;


import org.bmroczek.interfaces.Board;
import org.bmroczek.interfaces.BoardDisplay;
import org.springframework.stereotype.Component;

/**
 * This class display game board in console
 * @author Bartlomiej Mroczek
 */
@Component
public class BoardDisplayInConsole implements BoardDisplay {

    private Board board;

    private int height;
    private int width;

    public BoardDisplayInConsole(Board board) {
        this.board = board;
        height = board.getHEIGHT();
        width = board.getWIDTH();
    }

    @Override
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

