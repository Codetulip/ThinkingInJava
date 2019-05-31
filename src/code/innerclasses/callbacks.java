/**
 * FileName: callbacks
 * Author:   Code
 * Date:     2019/4/25 20:13
 * Description: 闭包与回调
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.innerclasses;

class Callee1 implements Incrementable {

    private int i = 0;

    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
    public void increment() {
        System.out.println("other operation");
    }

    static void f(MyIncrement mi) {
        mi.increment();
    }
}

class Callee2 extends MyIncrement {
    private int i = 0;

    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    // 闭包
    private class Closure implements Incrementable {

        @Override
        public void increment() {
            // 回调
            Callee2.this.increment(); // 明确使用外部类的increment，不然会无限循环
        }
    }

    Incrementable getCallbackReference() {
        return new Closure();
    }
}

class Caller {
    private Incrementable callBackReference;

    Caller(Incrementable cbh) {
        this.callBackReference = cbh;
    }

    void go() {
        callBackReference.increment();
    }
}

public class callbacks {

    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }
}
