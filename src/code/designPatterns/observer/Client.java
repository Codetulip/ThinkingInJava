package code.designPatterns.observer;

/**
 * @Classname Client
 * @Description 场景类
 * @Author codetulip
 * @Date 2019/7/6 14:54
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        // 定义出被观察者和观察者
        LiSi liSi = new LiSi();
        HanFeiZi hanFeiZi = new HanFeiZi();
        // 观察早餐
        Spy watchBreakfast = new Spy(hanFeiZi, liSi, "breakfast");
        watchBreakfast.start();
        // 观察娱乐
        Spy watchFun = new Spy(hanFeiZi, liSi, "fun");
        watchFun.start();
        // 观察韩非子在做什么
        Thread.sleep(1000);
        hanFeiZi.haveBreakfast();

        Thread.sleep(1000);
        hanFeiZi.haveFun();
    }
}
