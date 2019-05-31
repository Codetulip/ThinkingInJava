/**
 * FileName: Sandwich
 * Author:   Code
 * Date:     2019/4/24 10:19
 * Description: 初始化顺序测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.polymorphism.initialization;

class Bread {

    private int i = init(1);

    Bread() {
        System.out.println("Bread");
    }

    public int init(int i) {
        System.out.println("成员变量初始化" + i);
        return i;
    }

}

class Meal {
    private int i = init(2);

    Meal() {
        System.out.println("Meal");
    }

    public int init(int i) {
        System.out.println("成员变量初始化" + i);
        return i;
    }
}

public class Sandwich extends Bread {
    Meal m = new Meal();

    Sandwich() {
        System.out.println("SandWich");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}
