/**
 * FileName: SimpleDynamicProxy
 * @author:   Code
 * Date:     2019/5/8 13:18
 * Description: 简单的动态代理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealProject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("do something");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

// 调用处理器
class DynamicProxyHandler implements InvocationHandler {

    public static int count = 0; //调用次数计数

    private Object proxied; // 被代理的实际对象

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy" + proxy.getClass() + ", method: " + method + ", args: " + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println(" " + arg);
            }
        }
        // proxy就是代理类本身
        // 在Invoke内部调用proxy就会异常，无限循环
        // System.out.println("proxy: " + proxy.toString());
        count++;
        return method.invoke(proxied, args);
    }
}

public class SimpleDynamicProxy {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealProject real = new RealProject();
        consumer(real);
        // 插入一个动态代理并且再次调用
        // 返回一个实现了指定接口并代理了实际对象的代理
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),  // 类加载器，通常可以从被加载的对象中获取
                new Class[]{Interface.class},  // 希望该代理实现的接口列表
                new DynamicProxyHandler(real)); // InvocationHandler的实现
        consumer(proxy);
        proxy.doSomething();
        proxy.somethingElse("bonobo");
        System.out.println(DynamicProxyHandler.count);
    }
}
