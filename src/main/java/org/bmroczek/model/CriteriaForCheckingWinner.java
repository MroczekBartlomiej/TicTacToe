package org.bmroczek.model;

import lombok.Builder;
import lombok.Data;
import org.bmroczek.players.PlayerSign;

/**
 * @author Bartlomiej Mroczek
 */
@Data
@Builder
public class CriteriaForCheckingWinner {

    private int startElement;
    private int step;
    private PlayerSign playerSign;
}
