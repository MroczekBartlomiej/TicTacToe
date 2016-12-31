package org.bmroczek.players;


import org.bmroczek.board.Point;
import org.bmroczek.interfaces.Board;
import org.bmroczek.interfaces.Player;
import org.springframework.stereotype.Component;

/**
 * @author Bartlomiej Mroczek
 */
@Component
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

