package GUI;

import interfaces.Board;
import interfaces.BoardDisplay;

/**
 * This class display game board in console
 * @author Bartlomiej Mroczek
 */
public class BoardDisplayInConsole implements BoardDisplay {
    private Board board;
    private int hight;
    private int width;

    public BoardDisplayInConsole(Board board) {
        this.board = board;
        hight = board.getHight();
        width = board.getWidth();
    }

    @Override
    public void displayBoard() {
        char boardToDisplay[][] = board.getBoard();
        for (int i = 0; i < hight; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(boardToDisplay[i][j] + " ");
            }
            System.out.println();
        }
    }
}

