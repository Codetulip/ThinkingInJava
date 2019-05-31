/**
 * FileName: Cleanup
 * Author:   Code
 * Date:     2019/5/5 22:12
 * Description: 与InputFile共同测试构造器异常
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.exceptions;

public class Cleanup {
    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("ss");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null) {

                }
            } catch (Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            } finally {
                // 外部try失败时，不会执行内部的finally.即in的创建异常不会出现在这里处理
                // 即保证了此时文件确实是被打开的
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("InputFile construction failed");
        }
    }
}
