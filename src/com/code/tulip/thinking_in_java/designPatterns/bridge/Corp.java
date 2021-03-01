package com.code.tulip.thinking_in_java.designPatterns.bridge;

/**
 * @Classname Corp
 * @Description 抽象公司
 * @author code-tulip
 * @Date 2019/6/27 10:27 PM
 * @Version 1.0
 */
public abstract class Corp {

    private Product product;

    public Corp(Product product) {
        this.product = product;
    }

    /**
     * 如果是公司就应该有生产，不管是软件公司还是制造业公司
     * 每家公司生产的东西不一样，由具体实现类来完成
     */
    protected abstract void produce();

    /**
     * 销售产品
     */
    protected abstract void sell();

    /**
     * 公司的目的
     */
    public void makeMoney() {
        // 生产产品
        this.product.beProducted();
        // 销售
        this.product.beSelled();
    }
}
