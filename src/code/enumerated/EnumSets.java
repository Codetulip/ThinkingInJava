package code.enumerated;

import java.util.EnumSet;

import static code.enumerated.AlarmPoints.*;

/**
 * @Classname EnumSets
 * @Description 结合使用AlarmPoints作为数据
 * @Author tujing
 * @Date 2019/5/24 12:07 AM
 * @Version 1.0
 */
public class EnumSets {

    public static void main(String[] args) {
        // EnumSet为抽象类不可以直接new出来（需要实现指定方法）
        // noneOf方法返回空的EnumSet，参数指定元素类型
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class); //空的EnumSet
        // 添加方法
        points.add(BATHROOM);
        System.out.println(points);
        // EnumSet.of()返回指定枚举常量的EnumSet
        points.addAll(EnumSet.of(STAIR1, STAIT2, KITCHEN));
        System.out.println(points);
        // EnumSet.allOf()返回指定枚举的全部常量的EnumSet
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIT2, KITCHEN));
        System.out.println(points);
        // EnumSet.range(常量1，常量2)返回从常量1到常量2所有的枚举类
        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        System.out.println(points);
        points = EnumSet.complementOf(points); // 返回指定参数的补集
        System.out.println(points);
        // 输出按照enum中的顺序
    }


}
