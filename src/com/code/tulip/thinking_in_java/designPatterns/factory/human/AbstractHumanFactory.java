package com.code.tulip.thinking_in_java.designPatterns.factory.human;

/**
 * @Classname AbstractHumanFactory
 * @Description 抽象人类工厂
 * @author code-tulip
 * @Date 2019/5/21 9:40 PM
 * @Version 1.0
 */
public abstract class AbstractHumanFactory {

    // 接受人类的class
    public abstract <T extends Human> T createHuman(Class<T> c);

}
