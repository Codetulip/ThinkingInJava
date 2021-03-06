package com.code.tulip.thinking_in_java.designPatterns.factory.human;

/**
 * @Classname YellowHumanFactory
 * @Description 具体类的工厂（多工厂模式）
 * @author code-tulip
 * @Date 2019/5/21 11:58 PM
 * @Version 1.0
 */
public class YellowHumanFactory extends AbstractHumanFactory1 {
    @Override
    public Human createHuman() {
        return new YellowHuman();
    }
}
