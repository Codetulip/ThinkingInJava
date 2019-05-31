/**
 * FileName: Overload
 * Author:   Code
 * Date:     2019/4/22 19:26
 * Description: 重载
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.reusing;

class BaseOverload {
    public void hello(String s) {
        System.out.println("hello" + s);
    }

    public void hello(float f) {
        System.out.println("hello" + f);
    }

    public void hello(char c) {
        System.out.println("hello" + c);
    }


    // 返回类型的不同不能用于方法的重载
    /*public String hello(char c) {
        System.out.println("hello" + c);
        return "hello" + c;
    }*/
}

public class Overload extends BaseOverload {

    public void hello(int i) {
        System.out.println("hello" + i);
    }

    public void hello(Overload overload) {
        System.out.println(overload);
    }

    public String toString() {
        return "overload";
    }
    public static void main(String[] args) {

        Overload overload = new Overload();
        overload.hello(1);
        overload.hello('c');
        overload.hello((float) 1.0);
        overload.hello("xixi");
    }
}
