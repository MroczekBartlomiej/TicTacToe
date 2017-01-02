package org.bmroczek.players;


import org.bmroczek.board.Point;
import org.bmroczek.interfaces.Board;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Bartlomiej Mroczek
 */
@Component
public class PCPlayer {

    private final Board board;
    private final PlayerSign USER = PlayerSign.COMPUTER;
    private final int height;
    private final int width;

    public PCPlayer(Board board) {
        this.board = board;
        height = board.getHEIGHT();
        width = board.getWIDTH();
    }


    public boolean move(Point point) {
        return board.executeMove(USER, point);
    }

    public void randomPoint(){
        Random random = new Random();
        Point point;
        do {
            //TODO: Remove "new Point(...)"
            point = new Point(random.nextInt(height), random.nextInt(width));
        }while (!move(point));

    }
}
