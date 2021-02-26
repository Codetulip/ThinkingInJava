/**
 * FileName: FormattedMemoryInput
 * @author:   Code
 * Date:     2019/5/16 15:41
 * Description: 格式化的内存输入
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {

    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream
                    (BufferedInputFile.read("D:\\ideaProjects\\thinkingInJava\\src\\code\\io\\MemoryInput.java").getBytes()));
            while (true) {
                System.out.print((char) in.readByte());
            }
        } catch (EOFException e) {
            // EOFException end of file，输入过程中意外到了文件末尾
            System.err.println("End of stream");
        }
    }
}
