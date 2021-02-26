package com.code.tulip.thinking_in_java.designPatterns.factory.product;

/**
 * @Classname Creator
 * @Description 抽象工厂类
 * @author code-tulip
 * @Date 2019/5/21 10:32 PM
 * @Version 1.0
 */
public abstract class Creator {

    /**
     * 创建一个产品类型，其输入参数类型可以自行设置
     * 通常为String,Enum,Class等，当然也可以为空
     */
    public abstract <T extends Product> T createProduct(Class<T> c);

}
