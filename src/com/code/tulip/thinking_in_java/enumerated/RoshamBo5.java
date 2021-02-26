package com.code.tulip.thinking_in_java.enumerated;

import java.util.EnumMap;

import static com.code.tulip.thinking_in_java.enumerated.Outcome.*;

/**
 * @Classname RoshamBo5
 * @Description 使用EnumMap实现真正的两路分发
 * @author code-tulip
 * @Date 2019/5/24 11:55 PM
 * @Version 1.0
 */
public enum RoshamBo5 implements Competitor<RoshamBo5>{

    PAPER, SCISSORS, ROCK;

    static EnumMap<RoshamBo5, EnumMap<RoshamBo5, Outcome>> table = new EnumMap<RoshamBo5, EnumMap<RoshamBo5, Outcome>>(RoshamBo5.class);

    static {
        for (RoshamBo5 it : values()) {
            table.put(it, new EnumMap<RoshamBo5, Outcome>(RoshamBo5.class));
        }
        initRow(PAPER, DRAW, LOSE, WIN);
        initRow(SCISSORS, WIN, DRAW, LOSE);
        initRow(ROCK, LOSE, WIN, DRAW);
    }

    static void initRow(RoshamBo5 it, Outcome vPATER, Outcome vSCISSORS, Outcome vROCK) {
        table.get(it).put(PAPER, vPATER);
        table.get(it).put(SCISSORS, vSCISSORS);
        table.get(it).put(ROCK, vROCK);
    }

    @Override
    public Outcome compete(RoshamBo5 competitor) {
        return table.get(this).get(competitor);
    }
}
