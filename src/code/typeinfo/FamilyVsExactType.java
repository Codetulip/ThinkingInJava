/**
 * FileName: FamilyVsExactType
 * Author:   Code
 * Date:     2019/5/8 10:19
 * Description: isInstance()、instanceof 和 ==
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.typeinfo;


class Base {
}

class Derived extends Base {
}

public class FamilyVsExactType {

    static void test(Object x) {
        System.out.println("Testing x of type " + x.getClass());
        // 1
        System.out.println("x instanceof Base " + (x instanceof Base));
        System.out.println("x instanceof Derived " + (x instanceof Derived));
        // 2与1处等价，instanceof 等价于 isInstance()方法，这个类或其派生类
        System.out.println("Base.isInstance(x) " + Base.class.isInstance(x));
        System.out.println("Derived.isInstance(x) " + Derived.class.isInstance(x));
        System.out.println("Base.isAssignableFrom(x) " + Base.class.isAssignableFrom(x.getClass()));
        System.out.println("Derived.isAssignableFrom(x) " + Derived.class.isAssignableFrom(x.getClass()));
        // 3
        System.out.println("x.getClass() == Base.class " + (x.getClass() == Base.class));
        System.out.println("x.getClass() == Derived.class " + (x.getClass() == Derived.class));
        // 4与3处等价，即==与equals等价，比较实际的Class对象
        System.out.println("x.getClass().equals(Base.class) " + (x.getClass().equals(Base.class)));
        System.out.println("x.getClass().equals(Derived.class) " + (x.getClass().equals(Derived.class)));
    }

    public static void main(String[] args) {
        test(new Base());
        test(new Derived());
    }
}
