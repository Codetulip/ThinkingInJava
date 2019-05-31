package code.enumerated;

import java.util.Random;

/**
 * @Classname Enums
 * @Description 创建随机产生enum内常量的方法
 * @Author tujing
 * @Date 2019/5/23 5:26 PM
 * @Version 1.0
 */

// 随机返回枚举常量
public class Enums {

    private static Random rand = new Random(47);


    public static <T extends Enum> T random(Class<T> c) {
        return random(c.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
