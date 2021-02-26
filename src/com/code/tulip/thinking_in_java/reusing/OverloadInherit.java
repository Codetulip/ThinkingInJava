/**
 * FileName: OverloadInherit
 * @author:   Code
 * Date:     2019/4/22 20:18
 * Description: 继承
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.reusing;

public class OverloadInherit extends Overload {

    /*public String toString() {
        return "overloadInherit";
    }*/

    @Override
    public void hello(int i) {
        System.out.println("xixi" + i);
    }

    // 这种改变返回类型的方式覆盖基类的方法，会报错
    /*public String hello(int i) {
        return "xixi";
    }*/

    public static void main(String[] args) {
        OverloadInherit overloadInherit = new OverloadInherit();
        overloadInherit.hello(overloadInherit);
        overloadInherit.hello(1);
    }
}
