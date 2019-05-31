package code.enumerated;

import static code.enumerated.Outcome.*;

/**
 * @Classname RoShamBo2
 * @Description 使用enum枚举管理实现分发
 * @Author tujing
 * @Date 2019/5/24 11:20 PM
 * @Version 1.0
 */

enum Outcome {
    WIN, LOSE, DRAW
}

public enum RoShamBo2 implements Competitor<RoShamBo2>{

    // 类似枚举的管理
    PAPER(DRAW, LOSE, WIN), // 使用构造器初始化每个enum实例，并用结果作为一组参数
    SCISSORS(WIN, DRAW, LOSE),
    ROCK(LOSE, WIN, DRAW);

    private Outcome vPATER, vSCISSORS, vROCK;


    RoShamBo2(Outcome vPATER, Outcome vSCISSORS, Outcome vROCK) {
        this.vPATER = vPATER;
        this.vSCISSORS = vSCISSORS;
        this.vROCK = vROCK;
    }

    public Outcome compete(RoShamBo2 it) {
        switch (it) {
            default:
            case PAPER:
                return vPATER;
            case SCISSORS:
                return vSCISSORS;
            case ROCK:
                return vROCK;
        }
    }


}
