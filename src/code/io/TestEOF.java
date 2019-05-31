/**
 * FileName: TestEOF
 * Author:   Code
 * Date:     2019/5/16 15:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("D:\\ideaProjects\\thinkingInJava\\src\\code\\io\\MemoryInput.java")));
        // available()方法表示在没有阻塞的情况下所能读取的字节数
        // 对于不同的流结果可能不同，要谨慎使用
        while (in.available() != 0)
            System.out.print((char) in.readByte());

    }
}
