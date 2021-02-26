package com.code.tulip.thinking_in_java.designPatterns.agent.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Classname GamePlayIH
 * @Description 动态代理类
 * @author code-tulip
 * @Date 2019/6/13 12:06 AM
 * @Version 1.0
 */
public class GamePlayIH implements InvocationHandler {

    // 被代理者抽象类（即代理需要实现的接口）
    Class cls = null;

    // 被代理的实例
    Object obj = null; // Object类型，不需要具体类型

    public GamePlayIH(Object obj) {
        this.obj = obj;
    }

    // 调用被代理的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result =  method.invoke(this.obj, args);
        // 如果是登录方法
        if (method.getName().equalsIgnoreCase("login")) {
            System.out.println("有人在用我的账号登录！");
        }
        return result;
    }
}
