package com.code.tulip.thinking_in_java.designPatterns.chainOfResponsibility.case1;

/**
 * @Classname Women
 * @Description 古代妇女
 * @author code-tulip
 * @Date 2019/7/2 10:22 PM
 * @Version 1.0
 */
public class Women implements IWomen{
    /**
     * 通过一个int类型的参数描述妇女的个人状况
     * 1--未出嫁
     * 2--出嫁
     * 3--父死
     */
    private int type = 0;

    // 妇女的请示
    private String request = "";

    // 通过构造函数传递过来请求
    public Women(int type, String request) {
        this.type = type;
        this.request = request;
    }

    // 获得自己的状况
    @Override
    public int getType() {
        return this.type;
    }

    // 获得妇女的请求
    @Override
    public String getRequest() {
        return this.request;
    }
}
