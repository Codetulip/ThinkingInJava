package com.code.tulip.thinking_in_java.designPatterns.abstractFactory;

/**
 * @Classname AbstractBlackHuman
 * @Description 黑色人种抽象类
 * @author code-tulip
 * @Date 2019/6/1 11:09 PM
 * @Version 1.0
 */
public abstract class AbstractBlackHuman implements Human{

    // 黑色人种肤色是黑色的
    @Override
    public void getColor(){
        System.out.println("黑色人种肤色是黑色的");
    }

    // 黑色人种说话
    @Override
    public void talk(){
        System.out.println("黑色人种会说话，一般听不懂");
    }
}
