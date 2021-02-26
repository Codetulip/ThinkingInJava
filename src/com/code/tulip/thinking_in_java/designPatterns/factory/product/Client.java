package com.code.tulip.thinking_in_java.designPatterns.factory.product;

/**
 * @Classname Client
 * @Description 产品生产的管理者
 * @author code-tulip
 * @Date 2019/5/21 10:40 PM
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product = creator.createProduct(ConcreteProduct1.class);
        // 继续业务逻辑
        Product product1 = ProductFactory.createProduct("ConcreteProduct1");
        System.out.println(product + " " + product1);
    }
}
