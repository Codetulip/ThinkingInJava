/**
 * FileName: InheritInner
 * Author:   Code
 * Date:     2019/4/25 20:40
 * Description: 内部类的继承
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.innerclasses;


class WithInner {
    class Inner {}    // 此处为非静态类，下面注释处需要注意
}

public class InheritInner extends WithInner.Inner {

    InheritInner(WithInner withInner){
        withInner.super(); // 必须这么写
    }

}

// 第二种表达方式
/*
class WithInner {
    static class Inner {}
}

public class InheritInner extends WithInner.Inner {

    InheritInner(){ }

}*/
