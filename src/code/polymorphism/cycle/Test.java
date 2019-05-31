/**
 * FileName: Test
 * Author:   Code
 * Date:     2019/4/24 11:04
 * Description: 测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.polymorphism.cycle;

public class Test {

    public static void main(String[] args) {
        Cycle[] x = new Cycle[]{
            new Bicycle(),
                new Unicycle(),
                    new Tricycle()
        };
        ((Bicycle)x[0]).balance();
        ((Unicycle)x[1]).balance();
//        ((Tricycle)x[2]).balance();

    }
}
