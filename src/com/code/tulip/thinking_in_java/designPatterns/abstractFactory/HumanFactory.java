package com.code.tulip.thinking_in_java.designPatterns.abstractFactory;

/**
 * @Interfacename HumanFactory
 * @Description 人类工厂
 * @author code-tulip
 * @Date 2019/6/1 11:14 PM
 * @Version 1.0
 */
public interface HumanFactory {

    // 制造一个黄色人种
    public Human createYellowHuman();

    // 制造一个白色人种
    public Human createWhiteHuman();

    // 制造一个黑色人种
    public Human createBlackHuman();
}
