package org.bmroczek.board;

import lombok.Builder;
import lombok.Data;

/**
 * @author Bartlomiej Mroczek
 */
@Data
@Builder
public class Point {

    private int x;
    private int y;

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
