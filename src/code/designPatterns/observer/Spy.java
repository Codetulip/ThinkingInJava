package code.designPatterns.observer;

/**
 * @Classname Spy
 * @Description 间谍
 * @Author codetulip
 * @Date 2019/7/6 14:49
 * @Version 1.0
 */

// 有很严重的缺陷，无限循环监测，cpu飙升
public class Spy extends Thread {

    private HanFeiZi hanFeiZi; // 被观察者
    private LiSi liSi; // 观察者
    private String type; // 观察的内容

    // 通过构造函数传递参数，要监控的是谁，谁来监控，要监控的内容
    public Spy(HanFeiZi hanFeiZi, LiSi liSi, String type) {
        this.hanFeiZi = hanFeiZi;
        this.liSi = liSi;
        this.type = type;
    }

    public void run() {
        while (true) {
            // 监控是否在吃饭
            if (this.type.equals("breakfast")) {
                // 如果确实在吃饭，通知李斯
                if (this.hanFeiZi.isHavingBreakfast()) {
                    this.liSi.update("韩非子在吃饭");
                    // 重置状态，继续监控
                    this.hanFeiZi.setHavingBreakfast(false);
                }
            } else {
                if (this.hanFeiZi.isHavingFun()) {
                    this.liSi.update("韩非子在娱乐");
                    this.hanFeiZi.setHavingFun(false);
                }
            }
        }
    }
}
