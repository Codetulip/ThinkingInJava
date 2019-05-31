/**
 * FileName: Parcel2
 * Author:   Code
 * Date:     2019/4/25 15:24
 * Description: 静态内部类(嵌套类)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.innerclasses;

public class Parcel2 {

    private int i = 1;

    void hello() {}

    public static class Contents {

        public void hello() {
            // System.out.println(i); // 不能访问外部非静态对象
        }

        public static void main(String[] args) {

        }
    }

    // 为了不必要的对象创建，方法最好也使用static
    public Contents contents() {
        hello();
        return new Contents();
    }

    private static class PDestination implements Destination {

    }

    public static PDestination destination() {
        return new PDestination();
    }

    public static void main(String[] args) {
<<<<<<< HEAD
       Parcel2.Contents c = new Parcel2.Contents(); // 外部类和本类皆可使用方法
=======
       Contents c = new Contents(); // 外部类和本类皆可使用方法
>>>>>>> initial commit
       Contents c2 = new Contents(); // 仅限本类中使用方法
       PDestination p = destination();
       Parcel2 parcel2 = new Parcel2();
       Contents c3 = parcel2.contents(); // 这种非常没有必要，所以最好对应方法也使用static
    }
}
