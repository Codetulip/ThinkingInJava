package com.code.tulip.thinking_in_java.designPatterns.decorator;

/**
 * @Classname SortDecorator
 * @Description
 * @author code-tulip
 * @Date 2019/6/17 11:01 PM
 * @Version 1.0
 */
public class SortDecorator extends Decorator {

    public SortDecorator(SchoolReport sr) {
        super(sr);
    }

    // 定义装饰方法
    private void reportSort() {
        System.out.println("排名第38名...");
    }

    @Override
    public void report() {
        this.reportSort();
        super.report();
    }
}
