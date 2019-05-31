package code.enumerated;

import java.io.Serializable;

/**
 * @Classname EnumClass
 * @Description enum的简单使用
 * @Author tujing
 * @Date 2019/5/23 4:17 PM
 * @Version 1.0
 */

// 除了不能继承，可以将enum当成一个类
// enum的实例（如Shrubbery）都继承自Enum，Enum没有values()方法，
// 而enum却有，values()方法是编译器添加的静态方法
// enum实例还能实现接口
enum Shrubbery implements Serializable {
    GROUND, CRAWLING, HANGING  // 其中每个都是enum实例Shrubbery的对象
}

public class EnumClass {

    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " ordinal(顺序):" + s.ordinal());
            // 枚举类型compareTo方法比较的Ordinal
            System.out.print(s.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.print(s.equals(Shrubbery.CRAWLING) + " ");
            System.out.print(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("--------------");
        }

        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            // valueOf(Class<T> enumType, String name)返回带指定名称的指定枚举类型的枚举常量。
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrubbery);
        }

    }
}
