package com.code.tulip.thinking_in_java.designPatterns.singleton;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Classname MoreEmperor
 * @Description 固定数量的单例实例对象(有上限的多例模式)
 * @author code-tulip
 * @Date 2019/6/7 10:38 PM
 * @Version 1.0
 */

// 有上限的多例模式，有助于系统的扩展
public class MoreEmperor {

    // 定义最多能产生的实例数量
    private static int maxNumOfEmperor = 2;

    // 每个皇帝都有名字，并使用ArrayList来容纳每个对象的私有属性
    private static ArrayList<String> nameList = new ArrayList<String>();

    // 定义个列表，容纳所有的皇帝实例
    private static ArrayList<MoreEmperor> emperorList = new ArrayList<MoreEmperor>();

    // 当前皇帝的序号
    private static int countNumOfEmperor = 0;

    // 产生所有的对象
    static {
        for (int i = 0; i < maxNumOfEmperor; i++) {
            emperorList.add(new MoreEmperor("皇" + (i + 1) + "帝"));
        }
    }

    private MoreEmperor() {

    }

    private MoreEmperor(String name) {
        nameList.add(name);
    }

    public static MoreEmperor getInstance() {
        Random random = new Random();
        // 随机产出一个皇帝，只要是就行
        countNumOfEmperor = random.nextInt(maxNumOfEmperor);
        return emperorList.get(countNumOfEmperor);
    }

    // 皇帝的私有行为
    public static void say() {
        System.out.println(nameList.get(countNumOfEmperor) + "皇帝说话啦...");
    }

}
