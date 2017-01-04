package org.bmroczek.board;

import org.bmroczek.model.CriteriaForCheckingWinner;
import org.bmroczek.players.PlayerSign;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Bartlomiej Mroczek
 */
@Component
public class SmallBoard {

    private static char BOARD[][];
    private final int HEIGHT = 3;
    private final int WIDTH = 3;
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
        return (checkWinner(PlayerSign.COMPUTER) || checkWinner(PlayerSign.HUMAN) || getEmptyPoints().isEmpty());
    }

    public boolean checkWinner(PlayerSign playerSign) {
        return (checkDiagonally(playerSign) || checkVertically(playerSign) || checkHorizontally(playerSign));
    }

    private boolean checkDiagonally(PlayerSign playerSign) {
        CriteriaForCheckingWinner fromLeftTopToRightBottom = CriteriaForCheckingWinner.builder()
                .startElement(0).step(HEIGHT + 1).playerSign(playerSign).build();

        CriteriaForCheckingWinner fromRightTopToLeftBottom = CriteriaForCheckingWinner.builder()
                .startElement(2).step(HEIGHT - 1).playerSign(playerSign).build();

        return (checkBoardAccordingToCriteria(fromRightTopToLeftBottom)
                || checkBoardAccordingToCriteria(fromLeftTopToRightBottom));
    }

    private boolean checkVertically(PlayerSign playerSign) {
        int step = HEIGHT;
        boolean b = false;
        int startPosition = 0;
        int maxStartPosition = 2;
        while (!b && startPosition <= maxStartPosition) {
            CriteriaForCheckingWinner criteriaForCheckingWinner = CriteriaForCheckingWinner.builder().
                    startElement(startPosition).step(step).playerSign(playerSign).build();
            b = checkBoardAccordingToCriteria(criteriaForCheckingWinner);
            startPosition++;
        }
        return b;
    }

    private boolean checkHorizontally(PlayerSign playerSign) {
        int step = 1;
        boolean b;
        int startPosition = 0;
        int maxStartPosition = WIDTH * HEIGHT - WIDTH;
        do {
            CriteriaForCheckingWinner criteriaForCheckingWinner = CriteriaForCheckingWinner.builder()
                    .startElement(startPosition).step(step).playerSign(playerSign).build();
            b = checkBoardAccordingToCriteria(criteriaForCheckingWinner);
            startPosition += WIDTH;
        } while (!b && startPosition <= maxStartPosition);
        return b;
    }

    private boolean checkBoardAccordingToCriteria(CriteriaForCheckingWinner criteriaForCheckingWinner) {
        List<Character> boardAsList = getBoardAsList();
        Character tempCharacter = '-';
        int startElement = criteriaForCheckingWinner.getStartElement();
        int step = criteriaForCheckingWinner.getStep();
        char sign = criteriaForCheckingWinner.getPlayerSign().getSign();

        for (int i = 0; i < HEIGHT; i++) {
            if (tempCharacter != '-' && tempCharacter != boardAsList.get(startElement)) {
                return false;
            } else if (sign == tempCharacter) {
                if (tempCharacter == boardAsList.get(startElement)) {
                    if ((startElement + step <= boardAsList.size())
                            && tempCharacter == boardAsList.get(startElement + step)) {
                        return true;
                    }
                }
                return false;
            }
            tempCharacter = boardAsList.get(criteriaForCheckingWinner.getStartElement());
            startElement += criteriaForCheckingWinner.getStep();
        }
        return false;
    }

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

    public String toString() {
        return Arrays.deepToString(BOARD);
    }

    public char[][] getBoard() {
        return BOARD;
    }

    public List<Character> getBoardAsList() {
        List<Character> boardAsList = new ArrayList<>();

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                boardAsList.add(BOARD[i][j]);
            }
        }
        return boardAsList;
    }
}
