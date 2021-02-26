package com.code.tulip.thinking_in_java.designPatterns.observer;

/**
 * @Classname LiSi
 * @Description 观察者
 * @author codetulip
 * @Date 2019/7/6 14:46
 * @Version 1.0
 */
public class LiSi implements ILiSi {

    // 观察到行动后开始工作
    @Override
    public void update(String context) {
        System.out.println("观察到韩非子活动，开始向老板汇报....");
        this.reportToBoss(context);
        System.out.println("汇报完毕...\n");
    }

    // 汇报工作
    private void reportToBoss(String reportContext) {
        System.out.println("报告老板，韩非子有活动了--->" + reportContext);
    }
}
