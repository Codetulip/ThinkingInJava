package com.code.tulip.thinking_in_java.designPatterns.chainOfResponsibility.case2;

/**
 * @Classname Father
 * @Description 处理类1
 * @author code-tulip
 * @Date 2019/7/2 10:27 PM
 * @Version 1.0
 */
public class Father extends Handler {

    public Father() {
        super(FATHER_LEVEL_REQUEST);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("女儿的请示是：" + women.getRequest());
        System.out.println("父亲的回答是：同意" );
    }
}
