package com.code.tulip.thinking_in_java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Classname GetChannel
 * @Description 演示三种类型的流产生通道
 * @author code-tulip
 * @Date 2019/5/22 1:04 PM
 * @Version 1.0
 */
public class GetChannel {

    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        // 写文件
        FileChannel fc = new FileOutputStream("/Users/code/testdataset/data.txt").getChannel();
        // wrap方法将字节数组封装成ByteBuffer
        fc.write(ByteBuffer.wrap("some text ".getBytes()));
        fc.close();

        // 移动到文件最后 再写入信息
        fc = new RandomAccessFile("/Users/code/testdataset/data.txt","rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("some more".getBytes()));
        fc.close();

        // 读文件
        fc = new FileInputStream("/Users/code/testdataset/data.txt").getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE); //ByteBuffer为抽象类，不能直接创建
        fc.read(byteBuffer); // 方法指定读取的文件存放地
        // 在一系列通道读取或放置操作之后，调用以下方法为一系列通道写入或相对获取操作做好准备。
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            System.out.print((char) byteBuffer.get()); // get方法获得是byte,并且ByteBuffer中的position会移动，类似迭代器的Next
        }
    }
}
