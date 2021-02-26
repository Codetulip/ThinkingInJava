package com.code.tulip.thinking_in_java.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Classname LargeMappedFiles
 * @Description
 * @author code-tulip
 * @Date 2019/5/22 8:27 PM
 * @Version 1.0
 */
public class LargeMappedFiles {

    static int length = 0x8FFFFFF; //128MB

    public static void main(String[] args) throws IOException {
        // 映射文件中所有输出必须使用RandomAccessFile(具体未知)
        MappedByteBuffer mappedByteBuffer = new RandomAccessFile("/Users/code-tulip/testdat" +
                "aset/data.txt", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            mappedByteBuffer.put((byte) 'x');
        }
        System.out.println("Finished writing");
        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.print(mappedByteBuffer.get(i));
        }
    }
}
