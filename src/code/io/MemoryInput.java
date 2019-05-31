/**
 * FileName: MemoryInput
 * Author:   Code
 * Date:     2019/5/16 15:26
 * Description: 从内存输入
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.io;

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {

    public static void main(String[] args) throws IOException {
        StringReader sr = new StringReader("xixiixahha");
        int c;
        // StringReader.read()方法返回值为int
        while ((c = sr.read()) != -1)
            System.out.print((char) c);
    }
}
