package com.code.tulip.thinking_in_java.designPatterns.abstractFactory;

/**
 * @Classname MaleHumanFactory
 * @Description 男性工厂
 * @author code-tulip
 * @Date 2019/6/1 11:18 PM
 * @Version 1.0
 */

// 生产方式也可以使用Class进行
public class MaleHumanFactory implements HumanFactory{

    @Override
    public Human createYellowHuman() {
        return new MaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
//        return new MaleWhitewHuman();
        return null;
    }

    @Override
    public Human createBlackHuman() {
//        return new MaleBlackHuman();
        return null;
    }
}
