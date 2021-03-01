package com.code.tulip.thinking_in_java.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * @Classname FileLocking
 * @Description
 * @author code-tulip
 * @Date 2019/5/22 8:56 PM
 * @Version 1.0
 */
public class FileLocking {

    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream out = new FileOutputStream("/Users/code-tulip/testdataset/data.txt");
        FileLock fl = out.getChannel().tryLock(); // 锁住整个文件，设置参数可以指定锁定部分文件
        if (fl != null) {
            System.out.println("Locked file");
            System.out.println(fl.isShared()); // 查看锁的类型，独占锁还是共享锁
            TimeUnit.MILLISECONDS.sleep(100);
            fl.release();
            System.out.println("Released lock");
        }
        out.close();
    }

}
