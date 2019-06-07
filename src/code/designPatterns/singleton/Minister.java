package code.designPatterns.singleton;

/**
 * @Classname Minister
 * @Description 需要用到单例的类（与Emperor类关联）
 * @Author tujing
 * @Date 2019/6/7 10:16 PM
 * @Version 1.0
 */
public class Minister {


    public static void main(String[] args) {
        for (int day = 0; day < 3; day++) {
            Emperor emperor = Emperor.getInstance();
            System.out.println(emperor); // 具有相同的hashCode
            emperor.say();
        }
        // 每次产出的单例都是同一个
    }
}
