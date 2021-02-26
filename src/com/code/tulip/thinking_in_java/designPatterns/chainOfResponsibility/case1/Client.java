package com.code.tulip.thinking_in_java.designPatterns.chainOfResponsibility.case1;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Classname Client
 * @Description 场景类
 * @author code-tulip
 * @Date 2019/7/2 10:31 PM
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        // 随机挑选几个女性
        Random rand = new Random();
        ArrayList<IWomen> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(new Women(rand.nextInt(4), "我要出去旅游"));
        }
        // 定义三个请示对象
        IHandler father = new Father();
        IHandler husband = new Husband();
        IHandler son = new Son();
        // 请示(代码臃肿，耦合过重)
        for (IWomen women : arrayList) {
            if (women.getType() == 1) {
                System.out.println("\n------女儿向父亲请示------");
                father.handleMessage(women);
            } else if (women.getType() == 2) {
                System.out.println("\n------妻子向丈夫请示------");
                husband.handleMessage(women);
            } else if (women.getType() == 3) {
                System.out.println("\n------母亲向儿子请示------");
                son.handleMessage(women);
            } else {
                // 暂时什么也不做

            }
        }
    }
}
