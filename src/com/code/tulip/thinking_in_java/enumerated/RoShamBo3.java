package com.code.tulip.thinking_in_java.enumerated;


/**
 * @Classname RoShamBo3
 * @Description 使用常量相关方式实现多路分发(表驱动式代码)
 * @author code-tulip
 * @Date 2019/5/24 11:39 PM
 * @Version 1.0
 */
public enum RoShamBo3 implements Competitor<RoShamBo3> {

    PAPER {
        @Override
        public Outcome compete(RoShamBo3 competitor) {
            switch (competitor) {
                default:
                case PAPER:
                    return Outcome.DRAW;
                case SCISSOR:
                    return Outcome.LOSE;
                case ROCK:
                    return Outcome.WIN;
            }
        }
    },

    SCISSOR {
        @Override
        public Outcome compete(RoShamBo3 competitor) {
            switch (competitor) {
                default:
                case PAPER:
                    return Outcome.WIN;
                case SCISSOR:
                    return Outcome.DRAW;
                case ROCK:
                    return Outcome.LOSE;
            }
        }

    },

    ROCK {
        @Override
        public Outcome compete(RoShamBo3 competitor) {
            switch (competitor) {
                default:
                case PAPER:
                    return Outcome.LOSE;
                case SCISSOR:
                    return Outcome.WIN;
                case ROCK:
                    return Outcome.DRAW;
            }
        }
    };

    @Override
    public abstract Outcome compete(RoShamBo3 competitor);
}
