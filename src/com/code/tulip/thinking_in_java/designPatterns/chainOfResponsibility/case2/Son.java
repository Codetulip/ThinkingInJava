package com.code.tulip.thinking_in_java.designPatterns.chainOfResponsibility.case2;

/**
 * @Classname Husband
 * @Description 处理类3
 * @author code-tulip
 * @Date 2019/7/2 10:29 PM
 * @Version 1.0
 */
public class Son extends Handler {
    public Son() {
        super(SON_LEVEL_REQUEST);
    }

    @Override
    public void response(IWomen women) {
        System.out.println("母亲的请示是:" + women.getRequest());
        System.out.println("儿子的答复是：同意");
    }
}
