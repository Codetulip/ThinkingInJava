package com.code.tulip.thinking_in_java.designPatterns.bridge;

/**
 * @Classname Client
 * @Description
 * @author code-tulip
 * @Date 2019/6/27 10:38 PM
 * @Version 1.0
 */


// 桥梁模式将抽象和实现解耦，使得两者可以独立的变化。
public class Client {

    public static void main(String[] args) {
        System.out.println("------房地产公司事这样运行的------");
        House house = new House();
        // 先找到我的公司
        HouseCorp houseCorp = new HouseCorp(house);
        houseCorp.makeMoney();
        System.out.println("\n");
    }
}
