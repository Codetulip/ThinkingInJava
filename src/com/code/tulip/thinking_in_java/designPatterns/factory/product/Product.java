package com.code.tulip.thinking_in_java.designPatterns.factory.product;

/**
 * @Classname Product
 * @Description 抽象产品类
 * @author code-tulip
 * @Date 2019/5/21 10:29 PM
 * @Version 1.0
 */
public abstract class Product {

    // 共性方法
    public void method1() {
        // 业务逻辑处理
    }

    // 不同产品的特有方法
    public abstract void method2();

}
