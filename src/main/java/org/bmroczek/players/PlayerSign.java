package org.bmroczek.players;

import lombok.Getter;

/**
 * @author Bartlomiej Mroczek
 */
public enum PlayerSign {

    COMPUTER('O'),HUMAN('X');

    @Getter
    private char sign;

    PlayerSign(char s) {
        sign = s;
    }

}
