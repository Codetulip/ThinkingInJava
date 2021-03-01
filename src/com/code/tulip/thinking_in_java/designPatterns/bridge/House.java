package com.code.tulip.thinking_in_java.designPatterns.bridge;

/**
 * @Classname House
 * @Description 房子产品
 * @author code-tulip
 * @Date 2019/6/27 10:47 PM
 * @Version 1.0
 */
public class House extends Product {
    @Override
    public void beProducted() {
        System.out.println("建造房子...");
    }

    @Override
    public void beSelled() {
        System.out.println("卖房子...");
    }
}
