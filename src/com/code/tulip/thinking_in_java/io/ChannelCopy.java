package com.code.tulip.thinking_in_java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Classname ChannelCopy
 * @Description 利用两个通道和缓冲器完成数据的传输
 * @author code-tulip
 * @Date 2019/5/22 2:38 PM
 * @Version 1.0
 */
public class ChannelCopy {

    private static final int B_SIZE = 1024;

    public static void main(String[] args) throws Exception{
        if (args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }
        FileChannel
                in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(B_SIZE);
        // 利用两个通道和缓冲器完成数据的传输
        while (in.read(byteBuffer) != -1) {
            byteBuffer.flip(); // 准备好写数据
            out.write(byteBuffer); //write之后数据依然在缓冲区中
            byteBuffer.clear(); // 准备好读数据
        }
    }
}
