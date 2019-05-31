/**
 * FileName: Interation
 * Author:   Code
 * Date:     2019/3/6 10:10
 * Description: break和cintinue的简单区别
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

public class Iteration {


    public static void main(String[] args) {
        int i = 0;
        for (; i < 5; i++) {
            System.out.println(" " + i);
            if (i == 3) break; // break直接跳出循环，自增不执行
        }
        System.out.println("分割线：" + i);
        for (; i < 10; i++) {
            if (i == 8) continue; // continue跳出本次循环，执行自增，并进入下一次循环
            System.out.println(" " + i);
        }
    }
}
