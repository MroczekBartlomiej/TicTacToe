package players;

import interfaces.Board;
import interfaces.Player;
import boards.Point;

import java.util.Random;

/**
 * @author Bartlomiej Mroczek
 */
public class PCPlayer {
    private final Board board;
    private final PlayerSign user = PlayerSign.COMPUTER;
    private final int hight;
    private final int width;
    public PCPlayer(Board board) {
        this.board = board;
        hight = board.getHight();
        width = board.getWidth();
    }


    public boolean move(Point point) {
        if (board.executeMove(user, point)){
            return true;
        }
            return false;
    }

    public void randomPoint(){
        Random random = new Random();
        Point point;
        do {
             point = new Point(random.nextInt(hight), random.nextInt(width));
        }while (!move(point));

    }
}
