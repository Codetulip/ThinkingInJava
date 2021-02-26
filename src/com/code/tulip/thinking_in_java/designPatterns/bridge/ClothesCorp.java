package com.code.tulip.thinking_in_java.designPatterns.bridge;

/**
 * @Classname HouseCorp
 * @Description 服装公司
 * @author code-tulip
 * @Date 2019/6/27 10:34 PM
 * @Version 1.0
 */
public class ClothesCorp extends Corp {
    public ClothesCorp(Product product) {
        super(product);
    }

    // 生产衣服
    @Override
    protected void produce() {
        System.out.println("服装公司生产衣服...");
    }

    // 卖衣服
    @Override
    protected void sell() {
        System.out.println("服装公司出售衣服...");
    }

    // 计算利润
    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("服装公司赚小钱...");
    }
}
