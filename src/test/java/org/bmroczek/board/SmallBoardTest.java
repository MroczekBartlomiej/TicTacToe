package org.bmroczek.board;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.bmroczek.players.PlayerSign;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static junitparams.JUnitParamsRunner.$;

/**
 * @author Bartlomiej Mroczek
 */
@RunWith(JUnitParamsRunner.class)
public class SmallBoardTest extends Assertions {

    private SmallBoard SMALL_BOARD;
    private int height;
    private int width;
    private final char PLAYER_o_COMPUTER = PlayerSign.COMPUTER.getSign();
    private final char EMPTY_BOARD_SIGN = '-';
    private final Point POINT = new Point(1, 1);


    @Before
    public void setup() {

        SMALL_BOARD = new SmallBoard();
        height = SMALL_BOARD.getHEIGHT();
        width = SMALL_BOARD.getWIDTH();
    }

    @Test
    public void moveShouldBeExecutedWhenBoardIsEmpty() {

        SMALL_BOARD.executeMove(PlayerSign.COMPUTER, POINT);
        char[][] board = SMALL_BOARD.getBoard();
        assertThat(board).contains(new char[]{EMPTY_BOARD_SIGN, PLAYER_o_COMPUTER, EMPTY_BOARD_SIGN});
    }

    @Test
    public void moveShouldNotBeExecutedTwiceTimeInTheSamePoint() {

        SMALL_BOARD.executeMove(PlayerSign.COMPUTER, POINT);
        boolean result = SMALL_BOARD.executeMove(PlayerSign.COMPUTER, POINT);
        assertThat(result).isFalse();
    }

    @Test
    public void allPointsInBoardShouldBeEmptyBeforeGameStart() {

        List<Point> emptyPoints = SMALL_BOARD.getEmptyPoints();
        assertThat(emptyPoints).hasSize(height * width);
    }

    @Test
    @Parameters(method = "parametersForWinMove")
    public void computerPlayerShouldWinWhenBoardContainsThreeOInOneLine(List<Point> points) {

        points.forEach(point -> SMALL_BOARD.executeMove(PlayerSign.COMPUTER, point));
        boolean result = SMALL_BOARD.hasOWon();
        assertThat(result).isTrue();
    }

    @Test
    @Parameters(method = "parametersForNotWinMove")
    public void computerPlayerShouldNotWinWhenBoardContainsThreeOInNotOneLine(List<Point> points) {

        points.forEach(point -> SMALL_BOARD.executeMove(PlayerSign.COMPUTER, point));
        boolean result = SMALL_BOARD.hasOWon();
        assertThat(result).isFalse();
    }

    @Test
    @Parameters(method = "parametersForNotWinMove")
    public void humanPlayerShouldNotWinWhenBoardContainsThreeXInNotOneLine(List<Point> points) {

        points.forEach(point -> SMALL_BOARD.executeMove(PlayerSign.HUMAN, point));
        boolean result = SMALL_BOARD.hasXWon();
        assertThat(result).isFalse();
    }

    @Test
    @Parameters(method = "parametersForWinMove")
    public void humanPlayerShouldWinWhenBoardContainsThreeXInOneLine(List<Point> points) {

        points.forEach(point -> SMALL_BOARD.executeMove(PlayerSign.HUMAN, point));
        boolean result = SMALL_BOARD.hasXWon();
        assertThat(result).isTrue();
    }

    @Test
    @Parameters(method = "movesForOneWin")
    public void gameShouldBeOverWhenOnePlayerWin(List<Point> points) {

        points.forEach(point -> SMALL_BOARD.executeMove(PlayerSign.HUMAN, point));
        boolean result = SMALL_BOARD.isGameOver();
        assertThat(result).isTrue();
    }

    @Test
    public void gameShouldBeOverWhenBoardIsFull() {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                SMALL_BOARD.executeMove(PlayerSign.COMPUTER, new Point(i, j));
            }
        }
        boolean result = SMALL_BOARD.isGameOver();
        assertThat(result).isTrue();
    }

    private Object[] parametersForNotWinMove() {

        return $(
                $(Arrays.asList(new Point(0, 0), new Point(1, 1), new Point(1, 2))),
                $(Arrays.asList(new Point(0, 0), new Point(2, 1), new Point(2, 2))),
                $(Arrays.asList(new Point(0, 0), new Point(1, 1), new Point(2, 1)))
        );
    }

    private Object[] parametersForWinMove() {

        return $(
                $(Arrays.asList(new Point(0, 0), new Point(1, 1), new Point(2, 2))),
                $(Arrays.asList(new Point(0, 0), new Point(1, 0), new Point(2, 0))),
                $(Arrays.asList(new Point(0, 0), new Point(0, 1), new Point(0, 2)))
        );
    }

    private Object[] movesForOneWin() {

        return $(
                $(Arrays.asList(new Point(0, 0), new Point(1, 1), new Point(2, 2)))
        );
    }

}