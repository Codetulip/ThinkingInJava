package com.code.tulip.thinking_in_java.designPatterns.observer;

/**
 * @Classname HanFeiZi
 * @Description 具体的被观察者
 * @author codetulip
 * @Date 2019/7/6 14:35
 * @Version 1.0
 */
public class HanFeiZi implements IHanFeiZi {

    // 是否在吃饭，监控的判断标准
    private boolean isHavingBreakfast = false;

    // 是否在娱乐
    private boolean isHavingFun = false;

    // 吃饭
    @Override
    public void haveBreakfast() {
        System.out.println("开始吃饭了。。。");
        this.isHavingBreakfast = true;
    }

    // 娱乐
    @Override
    public void haveFun() {
        System.out.println("开始娱乐了。。。");
        this.isHavingFun = true;
    }

    public boolean isHavingBreakfast() {
        return isHavingBreakfast;
    }

    public void setHavingBreakfast(boolean havingBreakfast) {
        isHavingBreakfast = havingBreakfast;
    }

    public boolean isHavingFun() {
        return isHavingFun;
    }

    public void setHavingFun(boolean havingFun) {
        isHavingFun = havingFun;
    }
}
