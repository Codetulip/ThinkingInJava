/**
 * FileName: Detergent
 * Author:   Code
 * Date:     2019/4/22 16:13
 * Description: inherit
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.reusing;

class Cleaner {

    Cleaner(int i ) {
        System.out.println("hahahah" + i);
    }

    private String s = "Cleaner";

    public String a = "hha";

    String b = "xixi"; // 包访问权限不可以被继承，在这个文件中之所以能访问是因为属于同一个包

    public void append(String a) {
        s += a;
    }

    void apply() {
        append("  apply");
    }

    public String toString() {
        return s;
    }
}

public class Detergent extends Cleaner {

    public Detergent() {
        // System.out.println(); // 此行代码不可运行
        super(1); // 如果基类不是默认构造器，必须创建继承类构造器并调用super()，必须是第一件要做的事
    }


    public void scrub() {
        append("  scrub");
        apply();
        System.out.println(b); // 之所以能访问到default声明，是因为在同一个包，而不是因为继承
    }

    public static void main(String[] args) {

        Detergent detergent = new Detergent();
        detergent.scrub(); //定义的新方法
        detergent.apply(); //继承的方法
        System.out.println(detergent);
    }

}
