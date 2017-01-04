package org.bmroczek.players;


import org.bmroczek.board.Point;
import org.bmroczek.board.SmallBoard;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * @author Bartlomiej Mroczek
 */
@Component
public class PCPlayer {

    private final SmallBoard board;
    private final PlayerSign USER = PlayerSign.COMPUTER;

    public PCPlayer(SmallBoard board) {
        this.board = board;
    }

    public boolean move() {
        return board.executeMove(USER, randomPoint());
    }

    private Point randomPoint() {
        Random random = new Random();
        List<Point> emptyPoints = board.getEmptyPoints();
        int numberOfEmptyPoints = emptyPoints.size();
        return emptyPoints.get(random.nextInt(numberOfEmptyPoints));
    }
}
