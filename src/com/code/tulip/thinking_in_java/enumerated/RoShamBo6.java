package com.code.tulip.thinking_in_java.enumerated;

import static com.code.tulip.thinking_in_java.enumerated.Outcome.*;

/**
 * @Classname RoShamBo6
 * @Description 使用二维数组实现两路分发(最简洁最直接，可能也是最快速的)
 * @author code-tulip
 * @Date 2019/5/25 12:06 AM
 * @Version 1.0
 */
public enum RoShamBo6 implements Competitor<RoShamBo6> {

    PAPER, SCISSORS, ROCK;

    private Outcome[][] table = {
            {DRAW, LOSE, WIN}, // PAPER
            {WIN, DRAW, LOSE}, // SCISSORS
            {LOSE, WIN, DRAW} // ROCK
    };


    @Override
    public Outcome compete(RoShamBo6 competitor) {
        return table[this.ordinal()][competitor.ordinal()];
    }
}
