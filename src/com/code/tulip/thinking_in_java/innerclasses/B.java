/**
 * FileName: Parcel4
 * @author:   Code
 * Date:     2019/4/25 19:50
 * Description:内部类的测试使用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.innerclasses;

import java.util.ArrayList;

class A {
    public U makeU() {
        return new U() {
            @Override
            public void f() {

            }

            @Override
            public void g() {

            }

            @Override
            public void h() {

            }
        };
    }
}

public class B {
    public ArrayList<U> w = new ArrayList<>();

    public void addU(U u) {
        w.add(u);
    }

    public void empty(int i) {
        w.remove(i);
    }

    public void iteration() {
        for (U u : w) {
            u.f();
            u.g();
            u.h();
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        b.addU(a.makeU());
        b.iteration();
    }
}


