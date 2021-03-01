package com.code.tulip.thinking_in_java.enumerated;

import java.util.Random;

/**
 * @EnumName Input
 * @Description 使用enum实现状态机
 * @author code-tulip
 * @Date 2019/5/24 3:09 PM
 * @Version 1.0
 */
public enum Input {

    // 以下看起来代码并没有分离，不够清晰，可以使用枚举管理使代码变得清晰
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100), // 货币对应的价格
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50), // 商品对应的价格
    ABORT_TRANSACTION {
        @Override
        public int amount() {
            throw new RuntimeException("ABORT.amount");
        }
    },
    STOP {
        @Override
        public int amount() {
            throw new RuntimeException("SHUT_DOWN.amount");
        }
    };

    int value;

    private Input(int value) {
        this.value = value;
    }

    private Input() {
    }

    int amount() {
        return value;
    }

    static Random rand = new Random(47);

    public static Input randomSelector() {
        return values()[rand.nextInt(values().length - 1)];
    }
}
