package players;

import board.Point;
import interfaces.Board;
import interfaces.Player;

/**
 * @author Bartlomiej Mroczek
 */
public class HumanPlayer implements Player {
    private final Board board;
    private final PlayerSign user = PlayerSign.HUMAN;

    public HumanPlayer(Board board) {
        this.board = board;
    }

    @Override
    public boolean move(Point point) {
            if (board.executeMove(user, point)){
                return true;
            } else {
                return false;
            }
        }
    }

