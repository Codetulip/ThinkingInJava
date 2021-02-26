package com.code.tulip.thinking_in_java.designPatterns.chainOfResponsibility.case2;

/**
 * @Interfacename IWomen
 * @Description 抽象女性接口
 * @author code-tulip
 * @Date 2019/7/2 10:21 PM
 * @Version 1.0
 */
public interface IWomen {

    // 获得个人状况
    int getType();

    // 获得个人请示
    String getRequest();
}
