package com.code.tulip.thinking_in_java.designPatterns.observer;

/**
 * @Classname HanFeiZi2
 * @Description 修改后的被观察者
 * @author codetulip
 * @Date 2019/7/6 15:06
 * @Version 1.0
 */
public class HanFeiZi2 implements IHanFeiZi {

    // 把观察者声明出来
    private ILiSi liSi = new LiSi();

    // 吃饭
    @Override
    public void haveBreakfast() {
        System.out.println("开始吃饭了。。。");
        // 通知李斯
        this.liSi.update("韩非子在吃饭");
    }


    // 娱乐
    @Override
    public void haveFun() {
        System.out.println("开始娱乐了。。。");
        this.liSi.update("韩非子在娱乐");
    }
}
