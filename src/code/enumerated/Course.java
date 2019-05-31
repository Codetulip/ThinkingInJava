package code.enumerated;

import java.util.Arrays;

/**
 * @EnumName Course
 * @Description 枚举的枚举
 * @Author tujing
 * @Date 2019/5/23 11:24 PM
 * @Version 1.0
 */
public enum Course {

    // 用Course中的实例包装Food中的每一个enum类
    APPETISZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class);

    private Food[] values;

    private Course(Class<? extends Food> c) {
        // c就对应了上面常量括号里的值
        values = c.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }

    // 同样可以使用Food和Course的方式，枚举中嵌套接口，接口中再嵌套枚举实现枚举的管理

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        for (Course c : values()) {
            // 本类中使用
            System.out.println(Arrays.toString(c.values));
            /*// 外部类使用
            Field values = c.getClass().getDeclaredField("values");
            values.setAccessible(true);
            System.out.println(Arrays.toString((Food[])values.get(c)));*/
            System.out.println(c.randomSelection());
        }
    }
}
