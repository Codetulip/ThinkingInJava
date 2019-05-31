/**
 * FileName: FinallyTest
 * Author:   Code
 * Date:     2019/5/5 20:07
 * Description: 有关finally的测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.exceptions;

public class FinallyTest {

    static int count = 0;

    static void f() throws Exception {
        throw new Exception();
    }

    // 测试finally在设计break,continue,return时依然会执行
    // 从何处返回无关紧要，只要出了当前try/catch块，finally块就会执行
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            try {
                f();
            } catch (Exception e) {
//                if (count == 2) break;
                if (count == 2) continue;
                System.out.println("Caught " + count);
            } finally {
                System.out.println("Finally " + count++);
            }
        }
    }
}
