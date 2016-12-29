package org.bmroczek.interfaces;

import org.bmroczek.board.Point;
import org.bmroczek.players.PlayerSign;

import java.util.List;

/**
 * @author Bartlomiej Mroczek
 */
public interface Board {

    boolean isGameOver();

    char[][] getBoard();


    boolean hasXWon();

    boolean hasOWon();

    List<Point> getEmptyPoints();

    boolean executeMove(PlayerSign player, Point point);

    int getHEIGHT();

    int getWIDTH();

}
