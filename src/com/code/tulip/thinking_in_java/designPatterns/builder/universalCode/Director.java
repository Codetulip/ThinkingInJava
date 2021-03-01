package com.code.tulip.thinking_in_java.designPatterns.builder.universalCode;

/**
 * @Classname Director
 * @Description 导演类
 * @author code-tulip
 * @Date 2019/6/11 12:35 AM
 * @Version 1.0
 */
public class Director {

    private Builder builder = new ConcreteProduct();

    // 构建不同的产品
    public Product getAProduct() {
        // 设置不同的表示，产生不同的产品
        builder.setPart();
        return builder.buildProduct();
    }
}
