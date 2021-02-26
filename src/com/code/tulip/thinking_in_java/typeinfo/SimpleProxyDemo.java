/**
 * FileName: SimpleProxy
 * @author:   Code
 * Date:     2019/5/8 14:50
 * Description: 简单的代理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.typeinfo;

interface Interface2 {
    void doSomething();
    void somethingElse(String arg);
}

class RealProject2 implements Interface2 {

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface2 {

    private Interface2 proxied; // 被代理的实际对象

    public SimpleProxy(Interface2 proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        proxied.somethingElse(arg);
    }
}

public class SimpleProxyDemo {

    public static void consumer(Interface2 iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealProject2 real = new RealProject2();
        consumer(real);
        consumer(new SimpleProxy(real));
    }
}