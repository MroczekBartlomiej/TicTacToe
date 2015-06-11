package boards;

import interfaces.Board;

import java.util.ArrayList;
import java.util.List;

import players.PlayerSign;

/**
 * @author Bartlomiej Mroczek
 */
public class SmallBoard implements Board {
    private final int hight = 3;
    private final int width = 3;
    private static char board[][];

    public SmallBoard() {
        board = new char[hight][width];
        for (int i = 0; i < hight; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = '-';
            }
        }
    }

    private boolean isCorrect(Point point) {
        return board[point.x][point.y] == '-';
    }

    public boolean isGameOver() {
        return (hasXWon() || hasOWon() || getEmptyPoints().isEmpty());
    }

    public boolean hasXWon() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 'X') || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 'X')) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 'X')
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 'X'))) {

                return true;
            }
        }
        return false;
    }

    public boolean hasOWon() {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 'O') || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 'O')) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 'O')
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 'O')) {
                return true;
            }
        }
        return false;
    }

    List<Point> emptyPoints;

    @Override
    public List<Point> getEmptyPoints() {
        emptyPoints = new ArrayList<>();
        for (int i = 0; i < hight; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == '-') {
                    emptyPoints.add(new Point(i, j));
                }
            }
        }
        return emptyPoints;
    }

    public boolean executeMove(PlayerSign player, Point point) {
        if (isCorrect(point)) {
            board[point.x][point.y] = player.getSign();
            return true;
        }
        return false;
    }

    @Override
    public int getHight() {
        return hight;
    }


    @Override
    public int getWidth() {
        return width;
    }

    public char[][] getBoard() {
        return board;

    }

}
