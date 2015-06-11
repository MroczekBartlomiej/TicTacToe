package interfaces;

import java.util.List;

import boards.Point;
import players.PlayerSign;

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

    int getHight();

    int getWidth();

}
