package com.code.tulip.thinking_in_java.designPatterns.chainOfResponsibility.case1;

/**
 * @Interfacename Handler
 * @Description 有处理权的人员接口
 * @author code-tulip
 * @Date 2019/7/2 10:25 PM
 * @Version 1.0
 */
public interface IHandler {

    // 一个女性要求咋咋咋，你要处理这个请求
    void handleMessage(IWomen women);
}
