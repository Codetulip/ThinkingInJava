package com.code.tulip.thinking_in_java.designPatterns.factory.product;

/**
 * @Classname ConcreteCreator
 * @Description 工厂实现类
 * @author code-tulip
 * @Date 2019/5/21 10:41 PM
 * @Version 1.0
 */
public class ConcreteCreator extends Creator{

    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
//            T t = c.newInstance(); // 这种方式目前测试没有问题
            product = (T) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
