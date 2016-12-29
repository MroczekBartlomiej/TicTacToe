package org.bmroczek.players;

import org.assertj.core.api.Assertions;
import org.bmroczek.board.Point;
import org.bmroczek.board.SmallBoard;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Bartlomiej Mroczek
 */
public class PCPlayerTest extends Assertions {

    private SmallBoard SMALL_BOARD;
    private int height;
    private int width;

    @Before
    public void setup() {

        SMALL_BOARD = new SmallBoard();
        height = SMALL_BOARD.getHEIGHT();
        width = SMALL_BOARD.getWIDTH();
    }

    @Test
    public void randomPoint() {

        PCPlayer pcPlayer = new PCPlayer(SMALL_BOARD);
        pcPlayer.randomPoint();
        List<Point> emptyPoints = SMALL_BOARD.getEmptyPoints();
        assertThat(emptyPoints).hasSize((height * width) - 1);
    }

}