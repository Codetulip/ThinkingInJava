package com.code.tulip.thinking_in_java.designPatterns.bridge;

/**
 * @Classname HouseCorp
 * @Description 房地产公司
 * @author code-tulip
 * @Date 2019/6/27 10:34 PM
 * @Version 1.0
 */
public class HouseCorp extends Corp {

    public HouseCorp(Product product) {
        super(product);
    }

    // 房地产公司盖房子
    @Override
    protected void produce() {
        System.out.println("房地产公司盖房子...");
    }

    // 买房子
    @Override
    protected void sell() {
        System.out.println("房地产公司出售房子...");
    }

    // 计算利润
    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚大钱了...");
    }
}
