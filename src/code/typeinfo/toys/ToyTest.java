/**
 * FileName: ToyTest
 * Author:   Code
 * Date:     2019/5/7 15:41
 * Description: Class对象方法的使用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.typeinfo.toys;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

class Count extends HashMap<String, Integer> {

    public void count(String type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
    }
}

class Toy {

    public Toy() {
    }

    public Toy(int i) {
        System.out.println("非默认构造器" + i);
    }
}

class FancyToy extends Toy implements HasBatteries, Shoots, Waterproof {
    FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class c) {
        System.out.println("Class name : " + c.getName() + "is interface? [" + c.isInterface() + "]");
        System.out.println("SimpleName : " + c.getSimpleName());
        System.out.println("Canonical name : " + c.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
//        Class<FancyToy> c = null;
//        c = FancyToy.class;  // 且不会触发初始化
        try {
            c = Class.forName("code.typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("can not find FancyToy");
            System.exit(1);
        }
        // 此时newInstance()将返回确切类型
      /*  try {
            FancyToy fancyToy = c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/
       // 利用反射机制调用非默认构造器
        try {
            c = Class.forName("code.typeinfo.toys.Toy");
            try {
                // 非public构造器 无法获取
                Object o = c.getConstructors()[1].newInstance(2);
                Toy o1 = (Toy) o;
                System.out.println(o1);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // 必须带有默认构造器，如果没有将会产生InstantiationException
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
