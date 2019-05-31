package code.enumerated;

<<<<<<< HEAD
import static code.enumerated.Outcome.DRAW;
import static code.enumerated.Outcome.LOSE;
import static code.enumerated.Outcome.WIN;
=======
import static code.enumerated.Outcome.*;
>>>>>>> initial commit

/**
 * @Classname RoShamBo3
 * @Description 使用常量相关方式实现多路分发(表驱动式代码)
 * @Author tujing
 * @Date 2019/5/24 11:39 PM
 * @Version 1.0
 */
public enum RoShamBo3 implements Competitor<RoShamBo3> {

    PAPER {
        public Outcome compete(RoShamBo3 competitor) {
            switch (competitor) {
                default:
                case PAPER:
                    return DRAW;
                case SCISSOR:
                    return LOSE;
                case ROCK:
                    return WIN;
            }
        }
    },

    SCISSOR {
        public Outcome compete(RoShamBo3 competitor) {
            switch (competitor) {
                default:
                case PAPER:
                    return WIN;
                case SCISSOR:
                    return DRAW;
                case ROCK:
                    return LOSE;
            }
        }

    },

    ROCK {
        public Outcome compete(RoShamBo3 competitor) {
            switch (competitor) {
                default:
                case PAPER:
                    return LOSE;
                case SCISSOR:
                    return WIN;
                case ROCK:
                    return DRAW;
            }
        }
    };

    public abstract Outcome compete(RoShamBo3 competitor);
}
