package org.bmroczek.players;


import org.bmroczek.board.Point;
import org.bmroczek.board.SmallBoard;
import org.springframework.stereotype.Component;

/**
 * @author Bartlomiej Mroczek
 */
@Component
public class HumanPlayer {

    private final SmallBoard board;
    private final PlayerSign user = PlayerSign.HUMAN;

    public HumanPlayer(SmallBoard board) {
        this.board = board;
    }

    public boolean move(Point point) {
        return board.executeMove(user, point);
    }
}

