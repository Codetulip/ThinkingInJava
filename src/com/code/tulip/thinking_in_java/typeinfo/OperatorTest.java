/**
 * FileName: OperatorTest
 * @author:   Code
 * Date:     2019/5/9 16:53
 * Description: + 、+=的测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.typeinfo;

public class OperatorTest {

    public static void main(String[] args) {
        int i = 1;
        int j = new Integer(2);
        // +和+=的测试、区别
        i = (int) (i + 1.0); // 需要强转
        i += 1.0; // 不需要
        j = (int) (j + 1.0);
        j += 1.0;
    }
}
