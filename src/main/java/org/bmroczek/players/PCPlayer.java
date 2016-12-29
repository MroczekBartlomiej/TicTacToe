package org.bmroczek.players;


import org.bmroczek.board.Point;
import org.bmroczek.interfaces.Board;

import java.util.Random;

/**
 * @author Bartlomiej Mroczek
 */
public class PCPlayer {
    private final Board board;
    private final PlayerSign user = PlayerSign.COMPUTER;
    private final int height;
    private final int width;
    public PCPlayer(Board board) {
        this.board = board;
        height = board.getHEIGHT();
        width = board.getWIDTH();
    }


    public boolean move(Point point) {
        return board.executeMove(user, point);
    }

    public void randomPoint(){
        Random random = new Random();
        Point point;
        do {
            point = new Point(random.nextInt(height), random.nextInt(width));
        }while (!move(point));

    }
}
