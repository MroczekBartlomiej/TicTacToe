package org.bmroczek.players;

/**
 * @author Bartlomiej Mroczek
 */
public enum PlayerSign {
    COMPUTER('O'),HUMAN('X');
    private char sign;

    PlayerSign(char s) {
        sign = s;
    }

    public char getSign() {
        return sign;
    }
}
