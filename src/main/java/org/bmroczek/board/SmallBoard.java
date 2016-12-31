package org.bmroczek.board;

import org.bmroczek.interfaces.Board;
import org.bmroczek.players.PlayerSign;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Bartlomiej Mroczek
 */
@Component
public class SmallBoard implements Board {

    private final int HEIGHT = 3;
    private final int WIDTH = 3;
    private static char BOARD[][];
    private List<Point> emptyPoints;

    public SmallBoard() {
        BOARD = new char[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                BOARD[i][j] = '-';
            }
        }
    }

    private boolean isCorrect(Point point) {
        return BOARD[point.getX()][point.getY()] == '-';
    }

    public boolean isGameOver() {
        return (hasXWon() || hasOWon() || getEmptyPoints().isEmpty());
    }

    public boolean hasXWon() {
        if ((BOARD[0][0] == BOARD[1][1] && BOARD[0][0] == BOARD[2][2] && BOARD[0][0] == 'X') ||
                (BOARD[0][2] == BOARD[1][1] && BOARD[0][2] == BOARD[2][0] && BOARD[0][2] == 'X')) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (((BOARD[i][0] == BOARD[i][1] && BOARD[i][0] == BOARD[i][2] && BOARD[i][0] == 'X')
                    || (BOARD[0][i] == BOARD[1][i] && BOARD[0][i] == BOARD[2][i] && BOARD[0][i] == 'X'))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasOWon() {
        if ((BOARD[0][0] == BOARD[1][1] && BOARD[0][0] == BOARD[2][2] && BOARD[0][0] == 'O') ||
                (BOARD[0][2] == BOARD[1][1] && BOARD[0][2] == BOARD[2][0] && BOARD[0][2] == 'O')) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if ((BOARD[i][0] == BOARD[i][1] && BOARD[i][0] == BOARD[i][2] && BOARD[i][0] == 'O')
                    || (BOARD[0][i] == BOARD[1][i] && BOARD[0][i] == BOARD[2][i] && BOARD[0][i] == 'O')) {
                return true;
            }
        }
        return false;
    }


    @Override
    public List<Point> getEmptyPoints() {
        emptyPoints = new ArrayList<>();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (BOARD[i][j] == '-') {
                    emptyPoints.add(new Point(i, j));
                }
            }
        }
        return emptyPoints;
    }

    public boolean executeMove(PlayerSign player, Point point) {
        if (isCorrect(point)) {
            BOARD[point.getX()][point.getY()] = player.getSign();
            return true;
        }
        return false;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }


    public int getWIDTH() {
        return WIDTH;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(BOARD);
    }

    public char[][] getBoard() {
        return BOARD;

    }

}
